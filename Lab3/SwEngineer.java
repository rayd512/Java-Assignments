/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code SwEngineer interface
 */
public class SwEngineer extends Employee {
	// The name of the project
	private String projName;

	// Constructor
	public SwEngineer(String name, double baseSalary, String projName) {
		super(name, baseSalary);
		this.projName = projName;
	}

	// Getter method to get the projName
	public String getProjName() {
		return this.projName;
	}

	/** Override the equals method
	*	@return{true or false}
	**/
	@Override
	public boolean equals(Object obj) {
		// Check if the object is itself
	    if (obj == this)
	      return true;
	  	// Check is obj is an instance of SwEngineer
	    if (!(obj instanceof SwEngineer)) {
	        return false;
	    }
	    // Cast obj to SwEngineer
	    SwEngineer swengineer = (SwEngineer) obj;
	    // Check if all attributes are equal
	    return getName().equals(swengineer.getName()) &&
	    		getProjName().equals(swengineer.getProjName()) &&
	    		getBaseSalary() == (swengineer.getBaseSalary());
	}

	/** hashes the object
	*   @return{the hashcode of the object}
	**/
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		Double base = this.getBaseSalary();
		result = prime * result +((getName() == null) ? 0 : getName().hashCode());
		result = prime * result +((getProjName() == null) ? 0 : getProjName().hashCode());
		result = prime * result +((base == null) ? 0 : base.hashCode());
		return result;
	}
}
