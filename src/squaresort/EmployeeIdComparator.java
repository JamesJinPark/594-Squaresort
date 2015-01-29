package squaresort;

import java.util.Comparator;

/**
 * @author James Park
 * CIT 594
 * HW2 - Squaresort
 *
 */
public class EmployeeIdComparator implements Comparator<Person>{

	//compares employee ids
	@Override
	public int compare(Person o1, Person o2) {
		return o1.employeeId - o2.employeeId;
	}

}
