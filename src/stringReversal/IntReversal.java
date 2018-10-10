/**
 * 
 */
package stringReversal;

/**
 * @author kxhb130
 *
 */
public class IntReversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 1234567809;
		System.out.println(reverse(num));
	}

	private static Long reverse(int num) {
		long result = 0;
		while(num > 0) {
			int mod = num%10;
			result = (result*10) + mod;
			num = num/10;
		}
		return result;
	}

}
