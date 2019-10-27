public class Customer extends Person implements Printable {
	private double projPrice;
	public Customer (String name, double projPrice) {
		super(name);
		this.projPrice = projPrice;
	}
	@Override
	public String PrintInfo() {
		return "Name: " + getName() + ", Project Price: " + projPrice;
	}
}