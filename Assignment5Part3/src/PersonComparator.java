import java.util.Comparator;


public class PersonComparator implements Comparator<Person> {
	// Override the compare method
	@Override
	public int compare(Person p1, Person p2) {
		// Simply compare the ages of both persons
		return Integer.compare(p1.getAge(), p2.getAge());
	}	

}