package labs.two_n_three;


import java.time.LocalDate;
import java.time.Period;

//Lab 2.3
public class Person {
	
	//ATTRIBUTES
	//
	String firstName;
	String lastName;
	char gender;
	long phoneNumber;
	
	//Lab 2.5
	public enum Gender {F,M;}
	Gender gen;
	
	
	
	
	//CONSTRUCTORS
	//
	//Default ctor
	public Person() {
		super();
	}
	
	//Parameterized ctor
	public Person(String fname, String lname, char gender) {
		super();
		this.firstName = fname;
		this.lastName = lname;
		this.gender = gender;
	}
	
	//Lab 2.4
	//Parameterized ctor with phone number
	public Person(String fname, String lname, char gender, long pnumber) {
		super();
		this.firstName = fname;
		this.lastName = lname;
		this.gender = gender;
		this.phoneNumber = pnumber;
	}
	
	//Lab 2.5
	//Parameterized ctor with enum gender
	public Person(String fname, String lname, Gender gen, long pnumber) {
		super();
		this.firstName = fname;
		this.lastName = lname;
		this.gen = gen;
		this.phoneNumber = pnumber;
	}
	
	
	//GETTERS AND SETTERS
	//
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGen() {
		return gen;
	}

	public void setGen(Gender gen) {
		this.gen = gen;
	}
	
	
	
	//SUPPORT METHODS
	//
	//Lab 3.7
	int calculateAge(LocalDate date) {
		LocalDate today = LocalDate.now();
		Period p = Period.between(date,  today);
		
		return p.getYears();
	}
	
	String getFullName(String firstName, String lastName) {
		return firstName+" "+ lastName;
	}
	
	void detailsFullName() {
		
	}
	
	
	
	
	//PRINTING METHOD
	//
	//Lab 2.3b
	public void printDetails(LocalDate bday) {
		System.out.println("Person Details:\n");
		System.out.println("---------------\n");
		System.out.println("Full Name: "+getFullName(firstName, lastName));
		if(gender == 'F' || gender == 'M')
			System.out.println("Gender: "+gender);
		if(bday != null)
			System.out.println("Age: "+calculateAge(bday));
		
		
		//Lab 2.4
		if(phoneNumber > 0)
			System.out.println("Phone Number: "+phoneNumber);
		
		
		//Lab 2.5
		if(gen == Gender.F || gen == Gender.M)
			System.out.println("Enumerated Gender: "+gen);
		System.out.println("\n");
	}
	
}

