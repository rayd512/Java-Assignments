public class Person {
	// Age of the person
	private int age;

	// Constructor
	public Person(int age) {
		this.age = age;
	}
	
	// Getter method for age
	public int getAge() {
		return this.age;
	}
	
	// For print a person
	public String toString() {
		return "Person, Age: " + getAge();
	}

}