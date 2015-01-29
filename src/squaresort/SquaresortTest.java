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
public class SquaresortTest {

	Comparator<Person> compName = new NameComparator();
	Comparator<Person> compPay = new PayGradeComparator();
	Comparator<Person> compId = new EmployeeIdComparator();
	
	@Test
	public void testLinearSortIntArray() {
		int[] array = {7, 2, 8, 5, 4};
		Squaresort.linearSort(array);
		assertTrue(array[0] == 2);
		assertTrue(array[1] == 4);
		assertTrue(array[2] == 5);
		assertTrue(array[3] == 7);
		assertTrue(array[4] == 8);
	}

	@Test
	public void testLinearSortPersonArrayComparatorOfPerson() {
		Person person1 = new Person("Bruce", "A", 24);
		Person person2 = new Person("Clark", "B", 15);
		Person person3 = new Person("Peter", "A", 20);
		Person person4 = new Person("Steve", "D", 10);
		
		Person[] people = {person1, person2, person3, person4};
		
		Squaresort.linearSort(people, compName);
		assertTrue(people[0].equals(person1));
		assertTrue(people[1].equals(person3));
		assertTrue(people[2].equals(person2));
		assertTrue(people[3].equals(person4));
		
		Squaresort.linearSort(people, compPay);
		assertTrue(people[0].equals(person4));
		assertTrue(people[1].equals(person2));
		assertTrue(people[2].equals(person3));
		assertTrue(people[3].equals(person1));
		
		Squaresort.linearSort(people, compId);	
		assertTrue(people[0].equals(person1));
		assertTrue(people[1].equals(person2));
		assertTrue(people[2].equals(person3));
		assertTrue(people[3].equals(person4));
	}

	@Test
	public void testSquaresort() {
		Person person1 = new Person("Bruce", "A", 9);
		Person person2 = new Person("Clark", "B", 8);
		Person person3 = new Person("Peter", "C", 7);
		Person person4 = new Person("Steve", "D", 6);
		Person person5 = new Person("Wanda", "E", 5);
		Person person6 = new Person("Tony", "F", 4);
		Person person7 = new Person("Logan", "G", 3);
		Person person8 = new Person("Barry", "H", 2);
		Person person9 = new Person("Reed", "I", 1);
		
		Person[][] people = {{person1, person3, person2}, {person4, person6, person5}, {person9, person8, person7}};
				
		Squaresort.squaresort(people, compName);
		assertTrue(people[0][0].equals(person1));
		assertTrue(people[0][1].equals(person2));
		assertTrue(people[0][2].equals(person3));
		assertTrue(people[1][0].equals(person4));
		assertTrue(people[1][1].equals(person5));
		assertTrue(people[1][2].equals(person6));
		assertTrue(people[2][0].equals(person7));
		assertTrue(people[2][1].equals(person8));
		assertTrue(people[2][2].equals(person9));
		

		Squaresort.squaresort(people, compPay);
		assertTrue(people[0][0].equals(person9));
		assertTrue(people[0][1].equals(person8));
		assertTrue(people[0][2].equals(person7));
		assertTrue(people[1][0].equals(person6));
		assertTrue(people[1][1].equals(person5));
		assertTrue(people[1][2].equals(person4));
		assertTrue(people[2][0].equals(person3));
		assertTrue(people[2][1].equals(person2));
		assertTrue(people[2][2].equals(person1));
		

		Squaresort.squaresort(people, compId);
		assertTrue(people[0][0].equals(person1));
		assertTrue(people[0][1].equals(person2));
		assertTrue(people[0][2].equals(person3));
		assertTrue(people[1][0].equals(person4));
		assertTrue(people[1][1].equals(person5));
		assertTrue(people[1][2].equals(person6));
		assertTrue(people[2][0].equals(person7));
		assertTrue(people[2][1].equals(person8));
		assertTrue(people[2][2].equals(person9));
	}
}
