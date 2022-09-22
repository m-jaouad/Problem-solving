package problemSolving;

import java.util.HashMap;
import java.util.Map;

/**
 * given an array of integers of length n , contains elements in the range of [0, n-1]
 * sort that array
 */
public class LinearSort {
	/**
	 * counting sort kind of using hashing technique
	 * @param nums
	 */
	public static void sort(int[] nums){
		// store the elements of the array in Hashmap
		// key : number in the array
		// value : occurrence of that element
		Map<Integer, Integer> map = new HashMap<>( ) ;
		for (int num : nums) {
			if (map.containsKey(num)) map.put(num, map.get(num) + 1);
			else map.put(num, 1);
		}

		System.out.println(map);
		int i = 0 ;
		int j = 0 ;
		while ( i < nums.length && j < nums.length ){
			if (map.containsKey(i)) {
				int a = map.get(i) ;
				int k = 0 ;
				while(k < a){
					nums[j] = i ;
					j++ ;
					k++ ;
				}
			}
			i++ ;
		}

		printArray(nums);
	}

	private static void printArray(int[] nums){
		StringBuilder s = new StringBuilder("{ ");
		for (int i = 0 ; i < nums.length -1 ; i++){
			s.append(nums[i]).append(", ");
		}

		s.append(nums[nums.length - 1]).append(" }");
		System.out.println(s);
	}

	/**
	 * counting sort implementation
	 * @param nums array of posotivess integers  in range [0-k]
	 * @param k
	 */
	public static  void countingSort(int[] nums, int k){
		int[] indexOcc = new int[k+1] ;
		printArray(indexOcc);
		for (int num : nums) {
			indexOcc[num] += 1;
		}
		printArray(indexOcc);
		for(int i = 1 ; i < nums.length  ; i++ ){
			indexOcc[i] += indexOcc[i-1];
		}
		for(int i = nums.length -1; i > 0 ; i-- ){
			indexOcc[i] = indexOcc[i-1];
		}
		indexOcc[0] = 0 ;

		printArray(indexOcc);
		int[] sortedArr = new int[nums.length] ;
		for (int i = 0  ; i < nums.length ; i++){
			sortedArr[indexOcc[nums[i]]] = nums[i] ;
			indexOcc[nums[i]] += 1 ;
		}

		printArray(sortedArr);
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0, 4, 5, 4,2, 0} ;

		countingSort(nums, 5);
	}

}
