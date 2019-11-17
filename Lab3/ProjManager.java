/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code ProjManager} interface
 */
import java.util.Date; // import date 

public class ProjManager extends SwEngineer implements Printable, SalaryRaisable {
	// Date of the project deadline
	private Date projDeadline;

	// Constructor
	public ProjManager(String name, double baseSalary, String projName, Date projDeadline) {
		super(name, baseSalary, projName);
		this.projDeadline = projDeadline;
	}

	// Getter method to get the projDeadline
	public Date getProjDeadline() {
		return this.projDeadline;
	}

    /**
     * @return      {@code double} The amount of salary after raising
     */
	@Override
	public double RaiseSalary() {
		return getBaseSalary()*(1+0.24);
	}

    /**
     * @return      {@code String} The printable information in the string type.
     */
	@Override
	public String PrintInfo() {
		return "Name: " + getName() + ", Final Salary: " +
				RaiseSalary() + ", Project Deadline: " + getProjDeadline() +
				", Project Name: " + getProjName();
	}

	// Ovveride the equals method
	@Override
	public boolean equals(Object obj) {
		// First check if the object is itself
	    if (obj == this)
	      return true;
	  	// Check if obj is an instance of ProjManager
	    if (!(obj instanceof ProjManager)) {
	        return false;
	    }
	    // Assign obj as a ProjManager
	    ProjManager projmanager = (ProjManager) obj;
	    // Check if every attribute is the same
	    return getName().equals(projmanager.getName()) &&
	    		getProjName().equals(projmanager.getProjName()) &&
	    		getBaseSalary() == (projmanager.getBaseSalary()) &&
	    		this.projDeadline.equals(getProjDeadline());
	}

	@Override
	public int hashCode() {
		// Prime
		int prime = 31;
		// Result
		int result = 1;
		// get the base salary
		Double base = this.getBaseSalary();
		// Perform hashing on each atribute
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getProjName() == null) ? 0 : getProjName().hashCode());
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result + ((this.projDeadline == null) ? 0 : this.projDeadline.hashCode());

		// return the result after hashing
		return result;
	}

}