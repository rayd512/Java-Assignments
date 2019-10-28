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
		this.baseSalary *= 1.24;
		return getBaseSalary()*(1+0.24);
	}
	@Override
	public String PrintInfo() {
		return "Name: " + getName() + ", Final Salary: " + getBaseSalary() + ", Project Deadline: " + getProjDeadline();
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == this)
	      return true;
	    if (!(obj instanceof ProjManager)) {
	        return false;
	    }
	    ProjManager projmanager = (ProjManager) obj;
	    return getName().equals(projmanager.getName()) &&
	    		getProjName().equals(projmanager.getProjName()) &&
	    		getBaseSalary() == (projmanager.getBaseSalary()) &&
	    		this.projDeadline.equals(getProjDeadline());
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		Double base = this.getBaseSalary();
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getProjName() == null) ? 0 : getProjName().hashCode());
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result + ((this.projDeadline == null) ? 0 : this.projDeadline.hashCode());
		return result;
	}

}