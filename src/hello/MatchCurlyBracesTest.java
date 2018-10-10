/**
 * 
 */
package hello;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author kxhb130 Write a program to check parenthesis are matching.
 *
 */
public class MatchCurlyBracesTest {

	private static char startPattern = '{';
	private static char endPattern = '}';

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		if (in.hasNextLine()) {
			System.out.println(checkIfBracesAlign(in.nextLine().toCharArray()));
		}
	}

	private static boolean checkIfBracesAlign(char[] charArray) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < charArray.length; i++) {
			if (s.isEmpty())
				s.push(charArray[i]);
			else if (s.peek() != null && s.peek().equals(startPattern) && charArray[i] == endPattern) {
				s.pop();
			} else if (charArray[i] == endPattern || charArray[i] == startPattern) {
				s.push(charArray[i]);
			}
		}
		return s.isEmpty();
	}

}
