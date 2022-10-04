package problemSolving;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">link to the problem </a>
 */
public class longestPalindrome5 {
	/**
	 * trivial brute force for the problem
	 * time complexity = O(n3)
	 * constant space comlexity( O(1))
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		String longuestPalindrome = String.valueOf(s.charAt(0));
		for (int i = 0 ; i < s.length() ; i++ ){
			for (int j = i+1 ; j < s.length() ; j++){
				// implment the logic for checking if the substring is palindrome
				String subString = s.substring(i , j+1) ;
				int  first = 0 ;
				int end = subString.length() -1 ;

				boolean isPalindrome = true ;
				while(first < end ){
					if (subString.charAt(first) != subString.charAt(end)) {
						isPalindrome = false ;
						break;
					}

					first++ ;
					end-- ;
				}

				if (isPalindrome && subString.length() > longuestPalindrome.length()){
					longuestPalindrome = subString ;
				}
			}
		}

		return  longuestPalindrome ;
	}


	public static void main(String[] args) {
		String s = "cbbd" ;

		System.out.println(longestPalindrome(s));


	}
}
