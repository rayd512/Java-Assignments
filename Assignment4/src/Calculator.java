import java.lang.Math;
/**
 * Assignment 4 Part 2: Unit Testing <br />
 * The calculator to run the test cases
 */
// TODO: Assignment 4 Part 2 -- Create the Calculator here
public class Calculator {
	public Double add(double num1, double num2) {
		return Double.valueOf(num1 + num2);
	}
	public Double subtract(double num1, double num2) {
		return Double.valueOf(num1 - num2);
	}
	public Double multiply(double num1, double num2) {
		return Double.valueOf(num1 * num2);
	}
	public Double divide(double num1, double num2) {
		return Double.valueOf(num1 / num2);
	}
	public Double[] getRoots(double a, double b, double c) {
		double x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
		double x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
		if (x1 == x2) {
			Double[] arr = {Double.valueOf(x1)};
			return arr;
		} else {
			Double[] arr = {Double.valueOf(x1), Double.valueOf(x2)};
			return arr;
		}
	}
	public Double root(double num) {
		double num_sqrt = Math.sqrt(num);
		return Double.valueOf(num_sqrt);	
	}
}
