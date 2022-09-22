package problemSolving;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays">link to the problem decription on leetcode </a>
 */
public class FindMedianSortedArrays {

	/**
	 * time complexity : O(n)
	 * space complexity : O(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] mergedArr = new int[nums1.length + nums2.length] ;

		int i = 0 ;
		int j = 0 ;
		int k = 0 ;
		while ( i < nums1.length && j < nums2.length){
			if (nums1[i] < nums2[j] ){
				mergedArr[k] = nums1[i];
				i++ ;
			}else {
				mergedArr[k] = nums2[j];
				j++ ;
			}
			k++ ;
		}

		while (i < nums1.length){
			mergedArr[k] = nums1[i] ;
			i++ ;
			k++ ;
		}

		while(j < nums2.length){
			mergedArr[k] = nums2[j];
			j++ ;
			k++ ;
		}

		if(mergedArr.length % 2 == 1) return mergedArr[mergedArr.length/2 ] ;
		else return (mergedArr[mergedArr.length/2 -1] + mergedArr[mergedArr.length/2 ]) / 2.0 ;

	}

	/**
	 * time complexity : O((m+n)/2) with  m and n the lengths of the arrays
	 * space complexity = O(1)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
		int i = 0 ;
		int j = 0 ;
		int k = 0 ;

		int totalLength = nums1.length + nums2.length ;

		List<Integer> list = new ArrayList<>(2) ;

		while(i< nums1.length && j < nums2.length && k <= totalLength / 2){
			if(nums1[i] < nums2[j]){
				if(k ==  totalLength/2 -1 || k  == totalLength / 2 ) {
					System.out.println("k :" + k);
					System.out.println("i :" + i);
					list.add(nums1[i]) ;
				}
				i++ ;
			}else {
				if(k ==  totalLength/2 -1 || k  == totalLength / 2 ) {
					System.out.println("k :" + k);
					System.out.println("j :" + j);
					list.add(nums2[j]) ;
				}
				j++ ;
			}

			k++ ;
		}

		while(i < nums1.length && k <= totalLength / 2){
			if(k ==  totalLength/2 -1 || k  == totalLength / 2 ) {
				list.add(nums1[i]) ;
			}
			i++ ;
			k++ ;
		}

		while(j < nums2.length && k <= totalLength / 2){
			if(k ==  totalLength/2 -1 || k  == totalLength / 2 ) {
				list.add(nums2[j]) ;

			}
			j++ ;
			k++ ;
		}
		System.out.println(list);
		if (list.size() == 1) return list.get(0) ;
		if (totalLength % 2 == 1) return list.get(1) ;
		else return (list.get(0) + list.get(1) )/2.0 ;

	}

		public static void main(String[] args) {
		int[] nums1 = new int[] {5, 6, 7} ;
		int[] nums2 = new int[] {1, 3, 6}  ;

		double median = findMedianSortedArraysV2(nums1, nums2) ;

		System.out.println(median);

	}
}
