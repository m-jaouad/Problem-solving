package problemSolving;

import com.sun.source.doctree.SeeTree;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum15 {

	/**
	 * naive approach : brute force solution
	 * time complexity : O(n^3)
	 * space compelxity = o(n) because of the returened list containing the numbers
	 * @param nums
	 * @return
	 */

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<>() ;
		for(int i = 0 ; i <nums.length ; i++){
			for(int j = i+1 ; j < nums.length ; j++){
				for(int k = j+1 ; k < nums.length ; k++){
					if(nums[i] + nums[j] + nums[k] == 0){
						int[] sorted = sort3Nums(nums[i],nums[j],nums[k] ) ;
						result.add(new ArrayList<>(List.of( sorted[0], sorted[1], sorted[2]))) ;
					}
				}
			}
		}

		return new ArrayList<>(result);
 	}


	/**
	 * checks if two arrays are  equals : i.e contains the same elements
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public boolean isArrEquals(int[] nums1, int[] nums2){

		if(nums1.length != nums2.length) return false ;

		Map<Integer, Integer> map1 = new HashMap<>() ;
		Map<Integer, Integer> map2 = new HashMap<>() ;

		for(Integer num : nums1){
			if (map1.containsKey(num)) map1.put(num, map1.get(num) + 1) ;
			else map1.put(num, 1) ;
		}

		for(Integer num : nums2){
			if (map2.containsKey(num)) map2.put(num, map2.get(num) + 1) ;
			else map2.put(num, 1) ;
		}

		for (Integer num : map1.keySet()){
			if (!Objects.equals(map1.get(num), map2.get(num))) return false ;

		}
		return true ;
	}




	private int[] sort3Nums(int a, int b , int c){
		if(b < a) {
			int temp = a ;
			a =  b;
			b = temp ;
		}

		if( c < b) {
			if(c > a){
				return new int[]{a, c, b} ;
			}else {
				return new int[]{c, a, b} ;
			}
		}

		return new int[]{a, b, c} ;
	}

	/**
	 * solution based hashing
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum2(int[] nums) {
		// convert the arrays of numbers to HashMap , this operation takes O(n) in terms of time complexity
		// this map contains as key the number , and as value the number of occurrences
		Map<Integer, Integer>  map  = new HashMap<>() ;

		for(Integer num : nums){
			if(map.containsKey(num)) map.put(num , map.get(num) + 1);
			else map.put(num , 1) ;
		}


		Set<List<Integer>> setOfLists = new HashSet<>() ;

		Arrays.sort(nums);

		for(int i = 0 ; i < nums.length - 2 ; i++){

			for (int j = i+1 ; j < nums.length -1 ; j++   ){
				int target = -nums[i] - nums[j];
				if(target == nums[i] && target == nums[j]) {
					if(map.get(target) >= 3 ){
						setOfLists.add(List.of(0, 0, 0)) ;
					}
					continue;
				}

				if(nums[j] == target){

					if (map.get(target) >= 2) {
						List<Integer>  list = new ArrayList<>(List.of(target, nums[i], nums[j]));
						Collections.sort(list) ;
						setOfLists.add(list);
					}
					continue;
				}

				if(map.containsKey(target) ){
					if(target == nums[i] || nums[j] == target){
						if (map.get(target) < 2) continue;
					}
					List<Integer>  list = new ArrayList<>(List.of(target, nums[i], nums[j]));
					Collections.sort(list) ;
					setOfLists.add(list);
					continue;
				}

			}
		}

		return  new ArrayList<>(setOfLists) ;

	}

	public static void main(String[] args) {

		int[] nums = new int[] {3,0,-2,-1,1,2} ;

		System.out.println(	new ThreeSum15().threeSum2(nums))  ;
	}
}
