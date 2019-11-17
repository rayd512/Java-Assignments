import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
/**
 * Assignment 5: Interfaces <br />
 * Part 3: The {@code PersonTest} class
 */
public class PersonTest {
	
    @Test public void runTest() {
        
        Set<Person> persons = new TreeSet<Person>(new PersonComparator());
        persons.add(new Person(32));
        persons.add(new Person(17));
        persons.add(new Person(13));
        persons.add(new Person(35));
        persons.add(new Person(27));

        // Array of the correct sorted order
        int[] order = {13, 17, 27, 32, 35};
        // Iterator i
        int i = 0;
        // Iterator for persons
        Iterator<Person> iter = persons.iterator();
        
        // Loop through everything in persons
        while (iter.hasNext()) {
        	// Get the person
        	Person person = iter.next();
        	// Print the person
            System.out.println(person);
            // Check if the person is correct according to the order
            assertEquals(person.getAge(), order[i]);
            // Increase the iterator
            i++;
        }
    }
}
