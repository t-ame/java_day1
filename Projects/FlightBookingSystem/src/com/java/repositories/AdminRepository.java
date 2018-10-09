package com.java.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.java.components.Account;
import com.java.components.User;
import com.java.exception.GeneralException;
import com.java.utils.MyDataSource;

public class AdminRepository {

	private static AdminRepository rep=null;
	private static BasicDataSource ds;
	private static String errorMsg = "";

	static {
		try {
			ds = MyDataSource.getDataSource();
		} catch (GeneralException e) {
			errorMsg = "Loading Data Source failed: " + e.getMessage();
		}
	}
	
	private AdminRepository() {
		super();
	}
	
	public static AdminRepository getAdminRepository() {
		if(rep == null) {
			synchronized(AdminRepository.class) {
				if(rep == null)
					rep = new AdminRepository();
			}
		}
		return rep;
	}

	public User getUser(String userName) throws GeneralException {

		User user = new User();
		Account account = new Account();
		String fetchUserSQL = "select * from Admin where username = ?";

		try (Connection conn = ds.getConnection();
				PreparedStatement fetchUserSt = conn.prepareStatement(fetchUserSQL);) {

			fetchUserSt.setString(1, userName.toUpperCase());
			ResultSet set = fetchUserSt.executeQuery();

			while (set.next()) {
				user.setId(set.getInt("id"));
				account.setFirstName(set.getString("first_name"));
				account.setLastName(set.getString("last_name"));
				account.setAddress(set.getString("address"));
				account.setDateOfBirth(
						set.getDate("date_of_birth").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				account.setPassword(set.getString("password"));
				if (set.getString("gender").equalsIgnoreCase("female")) {
					account.setGender(Account.Gender.FEMALE);
				} else {
					account.setGender(Account.Gender.MALE);
				}
			}
			user.setAdmin(false); 
			user.setAccount(account);
			
			set.close();
		} catch (SQLException e) {
			throw new GeneralException("Unable to retrieve user: " + e.getMessage());
		}

		return user;
	}

	public void addUser(User user) throws GeneralException {

		if(!user.isAdmin()) {
			throw new GeneralException("Cannot add Customer to Admin database.");
		}
		Account account = user.getAccount();
		
		String insertUserSQL = "insert into Admin (id, first_name, last_name, user_name, address, date_of_birth, gender)\n" + 
				"values (adminIdGen.nextval, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ds.getConnection();
				PreparedStatement insertUserSt = conn.prepareStatement(insertUserSQL);) {
			insertUserSt.setString(1, account.getFirstName().toUpperCase());
			insertUserSt.setString(2, account.getLastName().toUpperCase());
			insertUserSt.setString(3, account.getUserName().toUpperCase());
			insertUserSt.setString(4, account.getAddress().toUpperCase());
			insertUserSt.setDate(5, java.sql.Date.valueOf(account.getDateOfBirth()));
			if(account.getGender() == Account.Gender.FEMALE) {
				insertUserSt.setString(6, "female".toUpperCase());
			} else {
				insertUserSt.setString(6, "male".toUpperCase());
			}
			
			insertUserSt.executeUpdate();  
			conn.commit();
			
		} catch (SQLException e) {
			throw new GeneralException("Unable to Add user to db : " + e.getMessage());
		}
	}

	public void updateUser(User user) throws GeneralException {
		
		if(!user.isAdmin()) {
			throw new GeneralException("Cannot Update Customer in Admin database.");
		}
		Account account = user.getAccount();
		
		String updateUserSQL = "update Admin set first_name=?, last_name=?, user_name=?, "
				+ 								"address=?, date_of_birth=?, gender=? where user_name=?";

		try (Connection conn = ds.getConnection();
				PreparedStatement updateUserSt = conn.prepareStatement(updateUserSQL);) {

			updateUserSt.setString(1, account.getFirstName().toUpperCase());
			updateUserSt.setString(2, account.getLastName().toUpperCase());
			updateUserSt.setString(3, account.getAddress().toUpperCase());
			updateUserSt.setDate(4, java.sql.Date.valueOf(account.getDateOfBirth()));
			if(account.getGender() == Account.Gender.FEMALE) {
				updateUserSt.setString(5, "female".toUpperCase());
			} else {
				updateUserSt.setString(5, "male".toUpperCase());
			}
			updateUserSt.setString(6, account.getUserName().toUpperCase());
			
			updateUserSt.executeUpdate();  
			conn.commit();
			
		} catch (SQLException e) {
			throw new GeneralException("Unable to Update user db : " + e.getMessage());
		}
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
