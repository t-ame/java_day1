package labs.four;

public class Person {

	String name;
	float age;
	
	public Person() {
		super();
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public Person(String name, float age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	
}
