/**
 * 
 */
package hello;

/**
 * @author kxhb130
 *
 */
public class FindLongestPalindromeTest {

	static boolean isPalindrome(String s) {
		int len = s.length() / 2;
		boolean result = true;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				result = false;
				break;
			}
		}
		return result;
	}

	static int longestPal(String str) {
		int n = str.length();
		int maxlength = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				String sub = str.substring(i, j + 1);
				if (sub.length() > maxlength && isPalindrome(sub))
					maxlength = sub.length();
			}
		}
		return maxlength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestPal("forgeeksskeegrof"));
	}

}
