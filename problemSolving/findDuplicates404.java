package problemSolving;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author M. JAOUAD
 *
 * <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array/">link to the problem</a>
 */
public class findDuplicates404 {
	/**
	 * time complexity : O(n)
	 * space complexity : O(n)
	 * n : length of the array nums
	 * @param nums array of integers
	 * @return list of duplicates in the provided array
	 */
	public List<Integer> findDuplicates(int[] nums) {

		Set<Integer> seens = new HashSet<>() ;
		List<Integer > duplicates = new ArrayList<>() ;

		for (Integer num : nums){
			if (seens.contains(num)) duplicates.add(num) ;
			else seens.add(num) ;
		}

		return duplicates ;
 	}
}
