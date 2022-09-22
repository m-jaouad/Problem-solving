package problemSolving;

import java.util.*;
import java.util.stream.Collectors;

public class SumOfTwo {
	/**
	 *  time complexity is o(n)
	 *
	 * @param arr1 array of integers
	 * @param arr2 array of integers
	 * @param target
	 * @return
	 */
	public boolean isSumOfTwo(int[] arr1, int[] arr2, int target) {
		// storing the elements of arr1 into a hashset to benefit from the lookup performance which is
		// takes O(1) in term of time complexity
		Set<Integer> set = new HashSet<>();
		for (Integer num : arr1) {
			set.add(num);
		}

		for(Integer num : arr2){
			int complement = target - num ;
			if(set.contains(complement))
				return true ;
		}

		return false ;
	}

	public static void main(String[] args) {

	}
}
