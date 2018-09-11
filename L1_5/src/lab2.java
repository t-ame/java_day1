
import java.util.Scanner;


public class lab2 {

	//Lab 2.1
	void printPersonDetail(String fname, String lname, char gender, int age, float weight) {
		
		System.out.println("Person Details:\n\n");
		System.out.println("First Name: "+fname);
		System.out.println("Last Name: "+lname);
		System.out.println("Gender: "+gender);
		System.out.println("Age: "+age);
		System.out.println("Weight: "+weight);
	
	}
	
	//Lab 2.2
	boolean checkNumberPositive() {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		if((a*(-1)) <= 0) {
			System.out.println("Positive");
			return true;
		} else {
			System.out.println("Negative");
			return false;
		}
	}
	
}
