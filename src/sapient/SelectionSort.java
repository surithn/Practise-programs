/**
 * 
 */
package sapient;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class SelectionSort {

	static int pointer;
	static int innerCount = 0;
	static int outerCount = 0;

	public static int[] sort(int[] a) {
		IntStream.range(0, a.length-1).forEach(i -> {
			pointer = i;
			IntStream.range(i, a.length).forEach(j -> {
				if (a[pointer] > a[j])
					pointer = j;
			});
			if (pointer != i) {
				int temp = a[pointer];
				a[pointer] = a[i];
				a[i] = temp;
			}
		});
		return a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 6, 3, 7, 4, 8 };
		System.out.println(Arrays.toString(sort(a)));
		System.out.println(outerCount + " & " + innerCount);
	}

}
