import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Assignment 5: Interfaces <br />
 * Part 1: The {@code CoffeeTest} class
 */
public class CoffeeTest {
     @Test public void testComparable() {
        // TODO: Assignment 5 Part 1 -- rewrite this using JUnit
        List<Coffee> coffees = new ArrayList<Coffee>();
        coffees.add(new Coffee(10));
        coffees.add(new Coffee(2));
        coffees.add(new Coffee(10));
        coffees.add(new Coffee(20));
        coffees.add(new Coffee(5));
        Collections.sort(coffees);

        // Check if the sorting worked correctly which also 
        // verifies if the compareTo method in coffee works correctly
        assertEquals(coffees.get(0).getStrength(), 2);
        assertEquals(coffees.get(1).getStrength(), 5);
        assertEquals(coffees.get(2).getStrength(), 10);
        assertEquals(coffees.get(3).getStrength(), 10);
        assertEquals(coffees.get(4).getStrength(), 20);
        
        // Instantiate variables 
        Coffee strong = new Coffee(30);
        Coffee weak = new Coffee(1);
        
        // Further test compareTo method
        assertTrue(strong.compareTo(weak) > 0);
        assertTrue(weak.compareTo(strong) < 0);
        assertTrue(weak.compareTo(weak) == 0);
        
        // Print out the ordered coffees
        System.out.println("Coffees in order of strength:");
        for (Coffee type : coffees) {
            System.out.println(type);
        }
    }
}
