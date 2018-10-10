/**
 * 
 */
package hello;

/**
 * @author kxhb130 Write a program to search a number in a sorted array having 1
 *         maxima
 *
 */
public class FindEleSortedArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] in = {1,3,5,7,8,10};
		findOneMaxima(in);
	}

	private static void findOneMaxima(int[] in) {
		for (int i=0; i<in.length-1; i++) {
			if (in[i+1]-in[i] == 1)
				System.out.println("pair is "+ in[i] +"," +in[i+1]);
		}
	}

}
