

//Lab 2.3
public class Person {
	
	//ATTRIBUTES
	//
	String firstName;
	String lastName;
	char gender;
	int age;
	float weight;
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
	public Person(String fname, String lname, char gender, int age, float weight) {
		super();
		this.firstName = fname;
		this.lastName = lname;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
	}
	
	//Lab 2.4
	//Parameterized ctor with phone number
	public Person(String fname, String lname, char gender, int age, float weight, long pnumber) {
		super();
		this.firstName = fname;
		this.lastName = lname;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.phoneNumber = pnumber;
	}
	
	//Lab 2.5
	//Parameterized ctor with enum gender
	public Person(String fname, String lname, Gender gen, int age, float weight, int pnumber) {
		super();
		this.firstName = fname;
		this.lastName = lname;
		this.gen = gen;
		this.age = age;
		this.weight = weight;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
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
	
	
	//PRINTING METHOD
	//
	//Lab 2.3b
	public void printDetails() {
		System.out.println("Person Details:\n");
		System.out.println("---------------\n");
		System.out.println("First Name: "+firstName);
		System.out.println("Last Name: "+lastName);
		//if(gender != '')
		System.out.println("Gender: "+gender);
		System.out.println("Age: "+age);
		System.out.println("Weight: "+weight);
		
		//Lab 2.4
		if(phoneNumber > 0)
			System.out.println("Phone Number: "+phoneNumber);
		
		//Lab 2.5
		System.out.println("Enumerated Gender: "+gen+"\n");
	}
	
}
