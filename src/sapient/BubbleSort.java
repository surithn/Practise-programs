package sapient;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * complexity - 2^n
 * @author kxhb130
 *
 */
public class BubbleSort {
	static int k;
	static int innerCount = 0;
	static int outerCount = 0;

	static int[] sort(int[] a) {
		IntStream.range(0, a.length).forEach(i -> {
			IntStream.range(i, a.length-1).forEach(j -> {
				if (a[i] > a[j])
					swap(i, j, a);
			});
		}) ;
		return a;
	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 6, 3, 7, 4, 8 };
		System.out.println(Arrays.toString(sort(a)));
		// System.out.println(outerCount + " & " + innerCount);
	}

}
