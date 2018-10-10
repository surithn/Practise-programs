/**
 * 
 */
package hello;

/**
 * @author kxhb130
 *
 */
public class PalindromeWord {

	static boolean isPalindrome(String str) {
		int mid = str.length()/2;
		boolean result = true;
		for (int i=0; i<mid; i++) {
			if (str.charAt(i) != str.charAt(str.length()-1-i)) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome("madams"));
	}

}
