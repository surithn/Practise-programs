package sapient;

import java.util.Arrays;

/**
 * @author kxhb130 dei go reverse and compare and swap
 *
 */
public class InsertionSort {

	static int innerCount = 0;
	static int outerCount = 0;

	static int[] sort(int[] a) {
		for (int i=1; i<a.length-1; i++) {
			for (int j=i; j>0; j--) {
				if (a[j] < a[j-1])
					swap(j, j-1, a);
			}
		}
		return a;
	}

	private static void swap(int i, int j, int[] a) {
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 6, 3, 7, 4, 8 };
		System.out.println(Arrays.toString(sort(a)));
		System.out.println(outerCount + " & " + innerCount);
	}

}
