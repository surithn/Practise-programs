/**
 * 
 */
package hello;

/**
 * @author kxhb130
 *
 */
public class FindGCDorHCF {

	/**
	 * An efficient solution is to use <strong>Euclidean<strong> algorithm which
	 * is the main algorithm used for this purpose. The idea is, GCD of two
	 * numbers doesn’t change if smaller number is subtracted from a bigger
	 * number.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		if (a == b)
			return a;
		if (a < b)
			return gcd(a, b - a);
		return gcd(a - b, b);
	}

	static int gcd1(int a, int b) {
		if (b == 0)
			return a;
		return gcd1(b, a % b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(gcd1(32, 5));
		System.out.println(gcd1(3239734, 5245235));
	}

}
