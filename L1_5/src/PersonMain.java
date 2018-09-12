

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Calendar;



//Lab 2.3a-b
public class PersonMain {

	public static void main(String[] args) {
		
//		Person obj1 = new Person("Jane", "Doe", 'F', 25, 240.34f);
//		Person obj2 = new Person("John", "Doe", 'F', 28, 260.8f, 2341473829l);
//		Person obj3 = new Person("Jane", "Doe", Person.Gender.M, 25, 240.34f, 2341473829l);
//		lab2 l = new lab2();
		
//		l.checkNumberPositive();
//		System.out.println(l.manString("hello my dearest", 4));
//		System.out.println(l.checkPositiveString("ANT"));
		
//		obj1.printDetails();
//		obj2.printDetails();
//		obj3.printDetails();
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		
		
		
		
		
	}

}
