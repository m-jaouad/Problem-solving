package problemSolving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BiggestIntegerPossible {

	private static int maFact(String[] strings){

		List<Character> characters = new ArrayList<>() ;

		for (String string : strings) {
			int j = 0;
			while (j < string.length()) {
				characters.add(string.charAt(j));
				j++;
			}
		}

		characters.sort(Comparator.reverseOrder());

		StringBuilder sortedNum = new StringBuilder();
		for(Character c : characters){
			sortedNum.append(c);
		}

		return Integer.parseInt(sortedNum.toString()) ;
	}

	public static void main(String[] args) {
		String[] strings = new String[] {"10", "7", "76", "415"} ;

		System.out.println(maFact(strings));
	}
}
