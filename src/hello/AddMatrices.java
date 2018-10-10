/**
 * 
 */
package hello;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class AddMatrices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] ar1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] ar2 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] ar3 = new int[2][3];
		IntStream.range(0, 2).forEach(row -> {
			IntStream.range(0, 3).forEach(col -> {
				ar3[row][col] = ar1[row][col] + ar2[row][col];
				System.out.print(ar3[row][col]);
			});
			System.out.println();
		});
	}

}
