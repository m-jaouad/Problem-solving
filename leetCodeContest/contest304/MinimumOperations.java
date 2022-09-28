package leetCodeContest.contest304;

import java.util.Arrays;

/**
 * first problem of the leetcode contest 304
 */
public class MinimumOperations {

	public int minimumOperations(int[] nums) {

		Arrays.sort(nums);
		int nbrOperations = 0;

		int i = 0 ;

		while(i < nums.length){
			int num = nums[i];
			if(num != 0){
				for (int j = i ; j < nums.length ; j++){
					nums[j] -= num;
				}
				nbrOperations++ ;
			}
			i++ ;
		}


		return nbrOperations;
	}

	private static void printArray(int[] nums){
		StringBuilder s = new StringBuilder("{ ");
		for (int i = 0 ; i < nums.length -1 ; i++){
			s.append(nums[i]).append(", ");
		}

		s.append(nums[nums.length - 1]).append(" }");
		System.out.println(s);
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,2,2,2,3,3};

		int min = new MinimumOperations().minimumOperations(nums);
		System.out.println(min);

		printArray(nums);
	}
}
