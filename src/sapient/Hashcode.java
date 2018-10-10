/**
 * 
 */
package sapient;

import java.util.Optional;

/**
 * @author kxhb130
 *
 */
public class Hashcode {

	public static long hashcode(String a) {
		char[] ch = a.toCharArray();
		long sb = 0;
		for (char c: ch) {
			sb += ((int)c * 31);
		}
		return sb;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hashcode("surith"));
	}

}
