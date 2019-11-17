/**
 * Assignment 5: Interfaces <br />
 * Part 1: The {@code Coffee} class
 */
public class Coffee implements Comparable<Coffee> {
    private int strength;       // The strength of the coffee
    
    // Constructor
    public Coffee(int strength) {
    	this.strength = strength;
    }
    
    // Getter method strength
    public int getStrength() {
    	return this.strength;
    }
    // Override the compareTo method
    @Override
    public int compareTo(Coffee other) {
    	// Compare strength of one object to another
    	return Integer.compare(this.strength, other.getStrength());
    }
}
