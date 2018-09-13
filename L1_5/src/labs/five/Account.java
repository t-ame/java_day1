package labs.five;

import java.util.HashMap;

import labs.four.Person;


abstract public class Account {

	public static long accounts;
	
	public static HashMap<Long, Account> accountList = new HashMap<>();
	
	
	private long accNum;
	protected double balance;
	private Person accHolder;
	
	
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	
	
	//Lab 5.3
	abstract boolean withdraw(double amount);
	
	
	

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

