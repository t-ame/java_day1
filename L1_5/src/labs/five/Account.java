package labs.five;

import java.util.HashMap;

import labs.four.Person;


public class Account {

	public static long accounts;
	
	public static HashMap<Long, Account> accountList = new HashMap<>();
	
	
	private long accNum;
	protected double balance;
	private Person accHolder;
	
	
	//Lab 4.2
	public boolean isSavings;
	

	
	public static Account createAccount(Person accH) {
		Account newacc = new Account();
		newacc.setAccHolder(accH);
		newacc.setAccNum(++accounts);
		newacc.setBalance(500);
		accountList.put(accounts, newacc);
		return newacc;
	}
	


	public static Account createAccount(Person accH, double initBalance) {
		Account newacc = new Account();
		newacc.setAccHolder(accH);
		newacc.setAccNum(++accounts);
		newacc.setBalance(initBalance);
		accountList.put(accounts, newacc);
		return newacc;
	}
	
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public boolean withdraw(double amount) {
		if(balance - amount < 500) {
			System.out.println("Insufficient balance.");
			return false;
		}
		balance -= amount;
		return true;
	}
	
	

	//Lab 4.1e
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", balance=" + balance + ", accHolder=" + accHolder + "]";
	}

	
	

	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Person getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	
	
	
	
	
	
	
}

