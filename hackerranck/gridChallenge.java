package hackerranck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class gridChallenge {

	/*
	 * Complete the 'gridChallenge' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING_ARRAY grid as parameter.
	 */

	public static String gridChallenge(List<String> grid) {

		// first step is  rearranging  the row in ascending order alphabetically
		// time complexity :
		// one for to iterate over the row of the grid i.e : O(n)
		// for sorting the row time complexity is : O(nlog(n))
		// so time complexity for this operation is : O(n^2log(n))
		for (int i = 0 ; i < grid.size() ;  i++){
			// row string to an array of char
			char[] charArr = grid.get(i).toCharArray() ;
			// sort the char array
			Arrays.sort(charArr) ;

		    grid.set(i,  new String(charArr))    ;
		}


		/// check if the column are sorted alphabetically after the rearrangement

		System.out.println(grid);
		for (int i = 0 ; i < grid.get(0).length()  ;  i++){
			for (int j = 0 ; j < grid.size() - 1  ; j++){
				if (grid.get(j).charAt(i) >  grid.get(j+1).charAt(i)){
					return "NO" ;
				}
			}

		}

		return  "YES" ;
	}

	public static void main(String[] args) {
		List<String> grid = new ArrayList<>() ;
		grid.add("kc") ;
		grid.add("iu") ;


		 String result = gridChallenge(grid) ;


		System.out.println(result);

	}


	public String  randomSolution(){
		boolean isYes = new Random().nextBoolean() ;

		if (isYes) return "YES" ;
		else return "NO" ;
	}
}


