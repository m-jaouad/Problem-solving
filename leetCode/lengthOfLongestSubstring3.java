package leetCode;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring3 {

	// solution using hashMap , because the time complexity  of searching in a map which constant
	// time complexity : O (n^2)
	// space complexity : O(n)
	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLenght = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.size() > maxLenght) {
					maxLenght = map.size();
				}
				Map<Character, Integer> tmap = new HashMap<>() ;
				for (int j = map.get(s.charAt(i)) + 1 ; j <= i ; j++ ){
					tmap.put(s.charAt(j), j);
				}
				map = tmap ;
			} else {
				map.put(s.charAt(i), i);
			}

		}

		System.out.println(map);

		return Math.max(maxLenght, map.size()) ;
	}

	public static void main(String[] args) {
		String s = "aab" ;
		int l = lengthOfLongestSubstring(s) ;
		System.out.println("lenght " + l);
	}
}
