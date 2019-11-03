import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for solving square roots
 */
public class SquareRootTests {
	
	private Calculator calc;
	
    // TODO: Assignment 4 Part 2 -- Checkpoint4

    @Before public void setUp() throws Exception {
    	calc = new Calculator();
    }

    @After public void tearDown() throws Exception {
    }

    @Test public void testRandomPositiveSquareRoot() {
        // You cannot use the Math.sqrt() function in the test!
    	double a = (Math.random()) * 200000000;
    	double squared = a*a;
    	assertEquals(calc.root(squared), Double.valueOf(a));
    }

    @Test public void testRandomNegitiveSquareRoot() {
        // The result should be a complex number i.e. Double.isNaN()
    	double a = (Math.random()) * 20000000;
    	assertTrue(calc.root(-a).isNaN());
    }

    @Test public void testSquareRootofZero() {
        // You cannot use the Math.sqrt() function in the test!
    	assertEquals(calc.root(0), Double.valueOf(0));
    }

    @Test public void testSquareRootofOne() {
        // You cannot use the Math.sqrt() function in the test!
    	assertEquals(calc.root(1), Double.valueOf(1));
    }

}
