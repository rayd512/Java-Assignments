public class HwEngineer extends Employee implements SalaryRaisable{
	public HwEngineer(String name, double baseSalary) {
		super(name, baseSalary);
	}
	public double RaiseSalary() {
		return getBaseSalary()*(1.18);
	}
}