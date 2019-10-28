public class SwEngineer extends Employee {
	private String projName;
	public SwEngineer(String name, double baseSalary, String projName) {
		super(name, baseSalary);
		this.projName = projName;
	}

	public String getProjName() {
		return this.projName;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == this)
	      return true;
	    if (!(obj instanceof SwEngineer)) {
	        return false;
	    }
	    SwEngineer swengineer = (SwEngineer) obj;
	    return getName().equals(swengineer.getName()) &&
	    		getProjName().equals(swengineer.getProjName()) &&
	    		getBaseSalary() == (swengineer.getBaseSalary());
	}

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
