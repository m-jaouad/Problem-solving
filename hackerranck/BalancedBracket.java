package hackerranck;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-balanced-brackets/">link to the problem </a>
 */

public class BalancedBracket {
	/**
	 * the problem  can be solved using a stacky
	 * time complexity : O( n)
	 * space complexity is constant
	 * @param s
	 * @return
	 */
	public static String isBalanced(String s) {

		Map<Character , Character> brackets = new HashMap<>() ;
		brackets.put( '}' ,'{' ) ;
		brackets.put( ']', '[' ) ;
		brackets.put( ')' , '(' ) ;

		Stack<Character> stack = new Stack<>() ;

		for (int i = 0 ; i < s.length() ; i++){
			char c = s.charAt(i) ;
			if (c == '[' || c == '(' ||  c == '{'){
				stack.push(c) ;
			}else if(stack.empty()){
				return "NO" ;
			} else if (brackets.get(c) == stack.peek()){
				stack.pop() ;
			}else {
				return "NO" ;
			}
		}
		if (!stack.empty()) return "NO" ;
		return "YES" ;
	}

	public static void main(String[] args) {


		System.out.println (isBalanced("") ) ;

	}



}

