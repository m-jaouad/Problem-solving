package leetCode;

public class MaxArea11 {
	// trivial solution
	// time complexity : O(n^2) and space complexity : O(1)
	public static int maxArea(int[] height) {

		int maxArea = 0 ;
		int tempMaxArea;
		for(int i = 0 ; i < height.length ; i++){
			for (int j = i +1 ; j < height.length ; j++ ){
				tempMaxArea = (j-i) * Math.min(height[i], height[j]) ;
				if(tempMaxArea > maxArea){
					maxArea = tempMaxArea ;
				}
			}
		}

		return maxArea ;
	}

	//efficient solution
	// time complexity : O(n)  using two pointers
	// space complexity : O(1)
	// this solution is faster than 97% of java submitted code on leetcode
	public static int maxAreaV1(int[] height) {

		int maxArea = 0 ;
		int tempMaxArea;

		int i = 0 ;
		int j = height.length - 1 ;

		while (i < j ){
			tempMaxArea  = (j-i) * Math.min(height[i], height[j]) ;
			if (maxArea < tempMaxArea){
				maxArea = tempMaxArea ;
			}
			if (height[i] > height[j]){
				j-- ;
			}else {
				i++ ;
			}
		}

		return maxArea ;
	}


	public static void main(String[] args) {
		int[] height =  new int[]{1,8,6,2,5,4,8,3,7} ;
		System.out.println(maxAreaV1(height));
	}


}
