/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code HwEngineer} interface
 */
public class HwEngineer extends Employee implements SalaryRaisable{
	// Constructor
	public HwEngineer(String name, double baseSalary) {
		super(name, baseSalary);
	}
	/**
     * @return      {@code double} The amount of salary after raising
     */
	public double RaiseSalary() {
		// This does not modify the baseSalary
		return getBaseSalary()*(1.18);
	}
}