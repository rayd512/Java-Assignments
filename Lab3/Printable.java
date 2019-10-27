/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code Printable} interface
 */
public interface Printable {
    /**
     * @return      {@code String} The printable information in the string type.
     */
    String PrintInfo();
    // TODO: Lab 3 Part 1 -- compose classes according to the UML diagram
}

// public class Person {
// 	private String name;

// 	public Person(String name) {
// 		this.name = name;
// 	}

// 	public String getName() {
// 		return this.name;
// 	}
// }

// public class Employee extends Person {
// 	private double salary;

// 	public Employee(String name, double baseSalary) {
// 		super (name);
// 		this.salary = salary;
// 	}

// 	public double getBaseSalary() {
// 		return this.salary;
// 	}

// }

// public class Customer extends Person implements Printable {
// 	private double projPrice;
// 	public Customer (String name, double projPrice) {
// 		super(name);
// 		this.projPrice = projPrice;
// 	}
// 	public void printInfo() {
// 		System.out.println("Name: " + this.name + ", Project Price: " + projPrice);
// 	}
// }

// public class SwEngineer extends Employee {
// 	private String projName;
// 	public SwEngineer(String name, double baseSalary, String projName) {
// 		super(name, baseSalary);
// 		this.projName = projName;
// 	}

// 	public String getProjName() {
// 		return this.projName;
// 	}
// }

// public class HwEngineer extends Employee implements SalaryRaisable{
// 	public HwEngineer(String name, double baseSalary) {
// 		super(name, baseSalary);
// 	}
// }

// public interface SalaryRaisable {
// 	double raiseSalary();
// }

// public class ProjManager extends SwEngineer implements Printable, SalaryRaisable {
// 	private Date projDeadline;
// 	public ProjManager(String name, double baseSalary, String projName, Date projDeadline) {
// 		super(name, baseSalary, projName);
// 		this.projDeadline = projDeadline;
// 	}
// 	public Date getProjDeadline() {
// 		return this.projDeadline;
// 	}
// 	public double raiseSalary(double rate) {
// 		return baseSalary*(1+rate);
// 	}
// 	public void printInfo() {
// 		System.out.println("Name: " + this.name + ", Final Salary: " + this.baseSalary + ", Project Deadline: " + this.projDeadline);
// 	}
// }