

//import Person.Gender;

//Lab 2.3a-b
public class PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person obj1 = new Person("Jane", "Doe", 'F', 25, 240.34f);
		Person obj2 = new Person("John", "Doe", 'F', 28, 260.8f, 2341473829l);
		Person obj3 = new Person("Jane", "Doe", Person.Gender.M, 25, 240.34f, 2341473829l);
//		lab2 l = new lab2();
//		
//		l.checkNumberPositive();
		
		//obj3.setGen(Person.Gender.M);
		
		obj1.printDetails();
		obj2.printDetails();
		obj3.printDetails();
		
	}

}
