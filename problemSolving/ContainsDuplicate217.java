package problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {
	/**
	 * time complexity : O(n)
	 * memory : O(1)
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {

		Set<Integer> seen  = new HashSet<>() ;

		for (Integer num : nums){
			if (seen.contains(num) ) return  true ;
			else  seen.add(num) ;
		}
		return  false ;
	}

	/**
	 * time complexity for this solution is : O(nlog(n))
	 * because this the best complexity for a sorting algorithm (Dual-Pivot Quicksort for this sort implementation )
	 *
	 * memory: O(1) - not counting the memory used by sort
	 * @param nums
	 * @return
	 */

	public boolean containsDuplicate2(int[] nums) {
		 Arrays.sort(nums);
		 for (int i = 0 ; i < nums.length - 1; i++){
			 if(nums[i] == nums[i+1]) return  true ;

		 }
		 return false ;

	}

	/**
	 * time complexity : O(n^2)
	 * space complexity : O(1)
	 * @param nums
	 * @return
	 */


	public boolean containsDuplicate3(int[] nums) {
		for(int i = 0 ; i < nums.length ; i++){
			for(int j = i+1 ; j < nums.length ; j++){
				if (nums[i] == nums[j]) return true ;
			}
		}


		return false ;
	}


}
