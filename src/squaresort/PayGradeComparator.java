package squaresort;

import java.util.Comparator;

/**
 * @author James Park
 * CIT 594
 * HW2 - Squaresort
 *
 */
public class PayGradeComparator implements Comparator<Person> {
	
	//compares paygrade
	@Override
	public int compare(Person o1, Person o2) {
		return o1.payGrade - o2.payGrade;
	}
}
