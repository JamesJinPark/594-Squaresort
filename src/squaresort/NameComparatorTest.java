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
public class NameComparatorTest {

	@Test
	public void testCompare() {
		Person person1 = new Person("Alex", "A", 15);
		Person person2 = new Person("Zack", "A", 10);
		Person person3 = new Person("Bertha", "F", 10);
		Person person4 = new Person("Mike", "Z", 10);
		Person person5 = new Person("Helen", "E", 10);
		Comparator<Person> compName = new NameComparator();
		assertTrue(compName.compare(person1, person2) < 0);
		assertFalse(compName.compare(person1, person2) == 0);
		assertTrue(compName.compare(person3, person4) < 0);
		assertFalse(compName.compare(person3, person2) == 0);
		assertTrue(compName.compare(person5, person1) > 0);
		assertFalse(compName.compare(person3, person2) == 0);
	
	}

}
