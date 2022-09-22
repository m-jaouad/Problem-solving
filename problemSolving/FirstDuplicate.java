package problemSolving;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Solution to the problem FistDupblicate
 * <a href="https:"> link to the problem statement</a>
 *
 */
public class FirstDuplicate {

	/**
	 * brute force solution for the problem , that takes O(n2 ) in term of time complexity
	 * @param arr
	 * @return
	 */
	public static int firstDuplicateNumber(int[] arr){
		int index = arr.length;
		int target = -1 ;
		int k = arr.length - 1;
		for(int i = 0 ; i < k ; ++i){
			for (int j = i + 1 ; j < k ; ++j){
				if (arr[i] == arr[j]){
					if(index > j){
						index = j ;
						target = arr[j] ;
						k = j + 1 ;
						break;
					}
				}
			}
		}

		return target ;
	}

	/**
	 * this solution of the problem takes advantages of the fact that with hashSet the lookup
	 * operation takes O(1) time complexity to return the result
	 *
	 * time complexity for that solution is : O(n)
	 * space complexity : O(n)
	 * @param arr
	 * @return
	 */
	public static int firstDuplicateNumber2(int[] arr ){
		int minIndex = arr.length;
		Set<Integer> set = new HashSet<>() ;

		for (int j : arr) {
			if (set.contains(j)) {
				return j;
			}
			set.add(j);
		}
		 return -1 ;
	}

	/**
	 * the best optimal solution for that problem
	 * time complexity : O(n)
	 * space complexity : O(1)
	 * @param arr
	 * @return
	 */
	public static int firstDuplicateNumber3(int[] arr){
		for (int i = 0 ; i < arr.length ; i++){
			if(arr[Math.abs(arr[i]) - 1] < 0) {
				return Math.abs(arr[i] );
			}
			arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i])- 1] ;
		}
		return -1 ;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 2, 1, 2, 3, 3} ;
		int[] arr2 = new int[]{2, 1, 3, 5, 3, 2} ;
		int[] arr3 = new int[]{1, 2, 3, 4, 5, 6} ;

		System.out.println(firstDuplicateNumber3(arr1));
		System.out.println("------------");
		System.out.println(firstDuplicateNumber3(arr2));
		System.out.println("------------");

		System.out.println(firstDuplicateNumber3(arr3));
	}
}
