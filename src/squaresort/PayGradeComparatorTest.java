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
public class PayGradeComparatorTest {

	@Test
	public void testCompare() {
		Person person1 = new Person("Harry", "Potter", 10);
		Person person2 = new Person("Ron", "Weasley", 10);
		Comparator<Person> compPay = new PayGradeComparator();
		assertTrue(compPay.compare(person1, person2) == 0);
		assertFalse(compPay.compare(person1, person2) > 0);
	}
}
