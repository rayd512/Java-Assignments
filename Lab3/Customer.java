/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code Customer} interface
 */
public class Customer extends Person implements Printable {
	// holds the price of the project
	private double projPrice;
	// Contructor
	public Customer (String name, double projPrice) {
		// Call the super class
		super(name);
		// Set the projPrice
		this.projPrice = projPrice;
	}

    /**
     * @return      {@code String} The printable information in the string type.
     */
	@Override
	public String PrintInfo() {
		// Print the required informations
		return "Name: " + getName() + ", Project Price: " + projPrice;
	}
}