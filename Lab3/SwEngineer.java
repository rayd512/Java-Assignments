public class SwEngineer extends Employee {
	private String projName;
	public SwEngineer(String name, double baseSalary, String projName) {
		super(name, baseSalary);
		this.projName = projName;
	}

	public String getProjName() {
		return this.projName;
	}
}
