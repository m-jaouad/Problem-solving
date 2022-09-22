package problemSolving;

/**
 * given an array of benefice of a company over n years
 * find the best cumulate benefice from year i to year j
 * this problem can be viewed as find the Largest Sum Contiguous Subarray of an array
 */
public class BenificeCumeleMaximal {
	/**
	 * naive iterative solution
	 * time complexity : O(n^2)
	 * space complexity : O(1 )
	 * @param benefices
	 * @return
	 */
	public static int beneficeMaxCumele(int[] benefices){
		int maxBenefice = Integer.MIN_VALUE ;

		for(int i = 0 ; i < benefices.length ; i++){
			int maxTemp = 0 ;
			for (int j = i ; j < benefices.length ; j++){
				maxTemp += benefices[j] ;
				if(maxTemp > maxBenefice){
					maxBenefice = maxTemp ;
				}
			}
		}
		return  maxBenefice ;
	}

	public static void main(String[] args) {
		int[] benefices = new int[] {-5, 1, 3, -1, 10, -2, 0, -222,  18} ;
		int be = beneficeMaxCumele(benefices);

		System.out.println(be);

	}
}
