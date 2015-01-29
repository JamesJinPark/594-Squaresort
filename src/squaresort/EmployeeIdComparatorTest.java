package squaresort;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

/**
 * @author James Park
 * CIT 594
 * HW2 - Squaresort
 *
 */
public class EmployeeIdComparatorTest {

	@Test
	public void testCompare() {
		Person person1 = new Person("Jamie", "Cullum", 15);
		Person person2 = new Person("Jason", "Mraz", 10);
		Comparator<Person> compId = new EmployeeIdComparator();
		assertTrue(compId.compare(person1, person2) < 0);
		assertFalse(compId.compare(person1, person2) == 0);
	}

}
