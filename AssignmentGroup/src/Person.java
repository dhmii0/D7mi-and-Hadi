package AssignmentGroup;

public class Person {

	//These are attributes
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//This is a method to get Name
	public String getName() {
		return name;
	}

	//This is a method to get age
	public int getAge() {
		return age;
	}

	//This is a method to display messages.
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	

}
