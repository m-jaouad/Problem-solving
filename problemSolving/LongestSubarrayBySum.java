package problemSolving;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/">link to the problem description </a>
 */
public class LongestSubarrayBySum {
	/**
	 * brure force solution for the problem
	 * time complexity : O(n)
	 * @param arr
	 * @param target
	 * @return
	 */
	public static  int[] findLongestSubarrayBySum(int[] arr, int target){
		int[] boundries = new int[]{0, 0} ;

		for (int i = 0 ; i < arr.length ; i++){
			int sum = arr[i] ;
			for(int j = i+1; j < arr.length ;  j++){
				sum += arr[j] ;
				if(sum == target && (boundries[1] - boundries[0] < j-i) ){
					boundries[0] = i ;
					boundries[1] = j ;

				}
			}
		}
		return boundries ;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 7, 5} ;
		int[] arr1 = new int[] {1, 2, 3, 4, 5, 0, 0, 6 , 6, 7, 8, 9, 10} ;


		int[] longestSubarrayBySum = findLongestSubarrayBySum(arr1, 15);

		System.out.println(longestSubarrayBySum[0] + "+" + longestSubarrayBySum[1]);
	}
}
