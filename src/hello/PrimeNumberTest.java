/**
 * 
 */
package hello;

import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class PrimeNumberTest {

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntStream.range(1, 20).forEach(action -> {
			System.out.println(Math.sqrt(action));
//			if (isPrime(action))
//				System.out.println(action);
		});
	}

}
