package labs.four;


//Lab 4.2b
public class CurrentAccount extends Account{

	final boolean isSavings = false;
	final double overDraftLimit = -300;
	
	
	@Override
	public boolean withdraw(double amount) {
		if(balance - amount < overDraftLimit) {
			System.out.println("Overdraft limit reached.");
			return false;
		}
		balance -= amount;
		return true;
	}
	
	
	public static Account createAccount(Person accH) {
		Account newacc = new CurrentAccount();
		newacc.setAccHolder(accH);
		newacc.setAccNum(++accounts);
		newacc.setBalance(500);
		accountList.put(accounts, newacc);
		return newacc;
	}
	


	public static Account createAccount(Person accH, double initBalance) {
		Account newacc = new CurrentAccount();
		newacc.setAccHolder(accH);
		newacc.setAccNum(++accounts);
		newacc.setBalance(initBalance);
		accountList.put(accounts, newacc);
		return newacc;
	}
	
}
