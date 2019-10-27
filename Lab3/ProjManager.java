import java.util.Date;
public class ProjManager extends SwEngineer implements Printable, SalaryRaisable {
	private Date projDeadline;
	public ProjManager(String name, double baseSalary, String projName, Date projDeadline) {
		super(name, baseSalary, projName);
		this.projDeadline = projDeadline;
	}
	public Date getProjDeadline() {
		return this.projDeadline;
	}
	@Override
	public double RaiseSalary() {
		return getBaseSalary()*(1+0.24);
	}
	@Override
	public String PrintInfo() {
		return "Name: " + getName() + ", Final Salary: " + RaiseSalary() + ", Project Deadline: " + getProjDeadline();
	}
}