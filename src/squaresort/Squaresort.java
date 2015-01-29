package squaresort;

import java.util.Comparator;

/**
 * @author James Park
 * CIT 594 
 * HW2 - Squaresort
 *
 */
public class Squaresort {

	/**
	 * Simply sorts array numbers in place, using selection sort 
	 * @param nums
	 */
	public static void linearSort(int[] nums){
		
		int outer, inner, min = 0; 
		for (outer = 0; outer < nums.length - 1; outer++){
			min = outer;
			for (inner = outer + 1; inner < nums.length; inner++){
				if(nums[inner]< nums[min]){
					min = inner;
				}
				for(int i = 0; i < inner + 1; i++){ // loop invariant
					if (outer <= i && i <= inner) // loop invariant
						assert nums[min] <= nums[i]; // loop invariant
				}
			}		
		int temp = nums[outer];
		nums[outer] = nums[min];
		nums[min] = temp;
		assert outer < nums.length; //loop invariant 
		}
		assert outer == nums.length - 1;// exit condition
	}
	
	/**
	 * Simply sorts array of person objects in place, using selection sort, 
	 * according to a given Comparator
	 * @param people
	 * @param comp
	 */
	public static void linearSort(Person[] people, Comparator<Person> comp){
	
		int outer, inner, min = 0; 
		for (outer = 0; outer < people.length - 1; outer++){
			min = outer;
			for (inner = outer + 1; inner < people.length; inner++){
				if (comp.compare(people[inner], people[min]) < 0){
					min = inner;
				}
				for(int i = 0; i < inner + 1; i++){ // loop invariant
					if (outer <= i && i <= inner) // loop invariant
						assert comp.compare(people[min], people[i]) <= 0; // loop invariant
				}
			}		
		Person temp = people[outer];
		people[outer] = people[min];
		people[min] = temp;
		assert outer < people.length; //loop invariant 
		}
		assert outer == people.length - 1;// exit condition
	}

	/**
	 * Sorts a 2D array, or m x n array, such that, for row numbers i < j < m and 
	 * all column numbers k < l < n
	 * array[i][k] <= array[j][k] and array[i][k] <= array[i][l]
	 * @param people
	 * @param comp
	 */
	public static void squaresort(Person[][] people, Comparator<Person> comp){
		Person[] temp = new Person[people.length];  
		
		//Sorts columns
		int j;
		for(j = 0; j < people[0].length; j++){
			int i;
			for(i = 0; i < people.length; i++){
				temp[i] = people[i][j];
				assert i < people.length;// loop invariant
			}
			assert i == people.length; // exit condition
			linearSort(temp, comp);
			int n;
			for(n = 0; n < people.length; n++){
				people[n][j] = temp[n];
				assert n < people.length; // loop invariant
			}
			assert n == people.length; // exit condition
		
		assert j < people[0].length; //loop invariant
		}
		assert j == people[0].length; //exit condition
		
		//Sorts rows
		int i;
		for(i = 0; i < people.length; i++){
			int k;
			for(k = 0; k < people[0].length; k++){
				linearSort(people[i], comp);
				assert k < people[0].length; //loop invariant
			}
			assert k == people[0].length; //exit condition
		assert i < people.length; // loop invariant
		}
		assert i == people.length; // exit condition
	}
	
	/**
	 * does timings using a m x n array that is 3 x 3 and is 
	 * purposely set up to take up the maximum number of operations to sort
	 */
	static void doTimings() {
		Person person1 = new Person("James", "A", 9);
		Person person2 = new Person("Sarah", "B", 8);
		Person person3 = new Person("Hahyun", "C", 7);
		Person person4 = new Person("Jae", "D", 6);
		Person person5 = new Person("Jimmy", "E", 5);
		Person person6 = new Person("Spark", "F", 4);
		Person person7 = new Person("Olga", "G", 3);
		Person person8 = new Person("JP", "H", 2);
		Person person9 = new Person("Spacebar", "I", 1);
		
		Person[][] people = {{person1, person3, person2}, {person4, person6, person5}, {person9, person8, person7}};
		Comparator<Person> compPay = new PayGradeComparator();
		
		System.gc();
		long startTime1 = System.nanoTime();
		squaresort(people, compPay);
		long elapsedTime = System.nanoTime() - startTime1;
				
		System.out.printf("Squaresort: %d\n", elapsedTime);
	}
	
	public static void main(String [] args){
		doTimings();
	}
}
