package labs.four;

public class AccountMain {

	
	public static void main(String[] args) {
		
		//Lab 4.1a
		Account smith = Account.createAccount(new Person("Smith"), 2000);
		Account kathy = Account.createAccount(new Person("Kathy"), 3000);
		
		//Lab 4.1b
		smith.deposit(2000);
		
		//Lab 4.1c
		kathy.withdraw(2000);
		
		//Lab 4.1d
		System.out.println("Smith's balance: "+smith.getBalance());
		System.out.println("Kathy's balance: "+kathy.getBalance());
		
		
	}
	
	
}
