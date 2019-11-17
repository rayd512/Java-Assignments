/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code Employee} interface
 */
public class Employee extends Person {
	// holds the baseSalary
	private double baseSalary;

	// Constructor
	public Employee(String name, double baseSalary) {
		// Call super
		super (name);
		// Set basesalary
		this.baseSalary = baseSalary;

	}

	// Getter method to get the baseSalary
	public double getBaseSalary() {
		return this.baseSalary;
	}

	@Override
	public boolean equals(Object obj) {
		// Check if the object is itself
	    if (obj == this)
	      return true;
	  	// Check is obj is an instance of SwEngineer
	    if (!(obj instanceof Employee)) {
	        return false;
	    }
	    // Cast obj to SwEngineer
	    Employee employee = (Employee) obj;
	    // Check if all attributes are equal
	    return getName().equals(employee.getName()) &&
	    		getBaseSalary() == (employee.getBaseSalary());
	}

}