
import java.util.*;



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
	
	//Lab 3.1
	String manString(String s, int choice) {
		int len = s.length();
		switch (choice) {
		case 1:
			return s+s;
		case 2:
			String n="";
			for(int i=0; i<len; ++i) {
				if(i%2 != 0)
					n+='#';
				else
					n+=s.charAt(i);
			}
			return n;
		case 3:
			String ns = "";
			Set<Character> news = new HashSet<Character>();
			for(int i=0; i<len; ++i)
				if(news.add(s.charAt(i)))
					ns+=s.charAt(i);
			return ns;
		case 4:
			String np="";
			for(int i=0; i<len; ++i) {
				if(i%2 != 0)
					np+=Character.toUpperCase(s.charAt(i));
				else
					np+=s.charAt(i);
			}
			return np;
		}
		return s;
	}
	
	
	//Lab 3.2
	boolean checkPositiveString(String s) {
		int len=s.length();
		for(int i=0; i<len-1; ++i) {
			if(Character.toLowerCase(s.charAt(i)) > Character.toLowerCase(s.charAt(i+1)))
				return false;
		}
		return true;
	}
	
	
	
}
