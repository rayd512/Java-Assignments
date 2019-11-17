/**
 * Assignment 4 Part 2: Unit Testing <br />
 * The calculator to run the test cases
 */
// TODO: Assignment 4 Part 2 -- Create the Calculator here
public class Calculator {
    /**
     * @param num1	{@code double} A double
     * @param num2	{@code double} A double
     * @return      {@code Double} The result of adding
     */
	public Double add(double num1, double num2) {
		return Double.valueOf(num1 + num2);
	}
	
    /**
     * @param num1	{@code double} A double
     * @param num2	{@code double} A double
     * @return      {@code Double} The result of subtracting
     */
	public Double subtract(double num1, double num2) {
		return Double.valueOf(num1 - num2);
	}
	
    /**
     * @param num1	{@code double} A double
     * @param num2	{@code double} A double
     * @return      {@code Double} The result of multiplying
     */
	public Double multiply(double num1, double num2) {
		return Double.valueOf(num1 * num2);
	}
	
    /**
     * @param num1	{@code double} A double
     * @param num2	{@code double} A double
     * @return      {@code Double} The result of dividing
     */
	public Double divide(double num1, double num2) {
		return Double.valueOf(num1 / num2);
	}
	
    /**
     * @param a	    {@code double} A double
     * @param b  	{@code double} A double
     * @param c  	{@code double} A double
     * @return      {@code Double[]} An array with the roots
     */
	public Double[] getRoots(double a, double b, double c) {
		// Calculate the roots
		Double x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
		Double x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
		// Calculate the discriminant
		double discriminant = b*b-4*a*c;
		
		// Bases on discriminant return the proper value
		if (discriminant > 0) {
			Double arr[] = {x1, x2};
			return arr;
		}
		else if (discriminant < 0) {
			Double arr[] = {Double.NaN, Double.NaN};
			return arr;
		}
		else {
			Double arr[] = {x1};
			return arr;
		}
	}
	
    /**
     * @param num   {@code double} The number to be square rooted
     * @return      {@code Double} The sqrt of the num
     */
	public Double root(double num) {
		double num_sqrt = Math.sqrt(num);
		return Double.valueOf(num_sqrt);	
	}
}
