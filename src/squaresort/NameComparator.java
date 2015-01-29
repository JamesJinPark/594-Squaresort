package squaresort;

import java.util.Comparator;
import java.lang.String;

/**
 * @author James Park
 * CIT 594
 * HW2 - Squaresort
 *
 */
public class NameComparator implements Comparator<Person>{
	
	// Compares two Person objects by their surnames. If surnames are the same,
	// compares using given names.
	@Override
	public int compare(Person o1, Person o2) {
		
		String name1 = o1.surname;
		String name2 = o2.surname;
		int compare = name1.compareTo(name2);
		if (compare == 0){
			String name3 = o1.givenName;
			String name4 = o2.givenName;
			compare = name3.compareTo(name4);
		}
		return compare; 
	}

}
