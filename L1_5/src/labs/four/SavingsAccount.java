package labs.four;



//Lab 4.2a
public class SavingsAccount extends Account{

	final boolean isSavings = true;
	final double minBalance = 500;
	
	@Override
	public boolean withdraw(double amount) {
		boolean check = true;
		if(balance - amount < minBalance) {
			System.out.println("Insufficient balance.");
			check = false;
		}
		balance -= amount;
		if(balance <0)
			balance = 0;
		return check;
	}
	
	
	
	public static Account createAccount(Person accH) {
		Account newacc = new SavingsAccount();
		newacc.setAccHolder(accH);
		newacc.setAccNum(++accounts);
		newacc.setBalance(500);
		accountList.put(accounts, newacc);
		return newacc;
	}
	


	public static Account createAccount(Person accH, double initBalance) {
		Account newacc = new SavingsAccount();
		newacc.setAccHolder(accH);
		newacc.setAccNum(++accounts);
		newacc.setBalance(initBalance);
		accountList.put(accounts, newacc);
		return newacc;
	}
	
	
}
