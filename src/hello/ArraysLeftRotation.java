package hello;

import java.util.Arrays;

/**
 * A left rotation operation on an array shifts each of the array's elements
 * unit to the left. For example, if left rotations are performed on array ,
 * then the array would become .
 * 
 * Given an array of integers and a number, , perform left rotations on the
 * array. Return the updated array to be printed as a single line of
 * space-separated integers.
 * 
 * Function Description
 * 
 * Complete the function rotLeft in the editor below. It should return the
 * resulting array of integers.
 * 
 * rotLeft has the following parameter(s):
 * 
 * An array of integers . An integer , the number of rotations.
 * 
 * The first line contains two space-separated integers and , the size of and
 * the number of left rotations you must perform. The second line contains
 * space-separated integers .
 *
 */
public class ArraysLeftRotation {

	static int[] rotLeft(int[] a, int d) {
		for (int i = 0; i < d; i++) {
			int first = a[0];
			for (int j = 0; j < a.length - 1; j++) {
				a[j] = a[j + 1];
			}
			a[a.length - 1] = first;
		}
		return a;
	}

	/**
	 * A Juggling Algorithm - Instead of moving one by one, divide the array in
	 * different sets where number of sets is equal to GCD of n and d and move
	 * the elements within sets.
	 * 
	 * @param a
	 * @param d
	 * @return
	 */
	static int[] rotLeftEfficient(int[] a, int d) {
		int j, k, temp;
		for (int i = 0; i < gcd(d, a.length); i++) {
			j = i;
			temp = a[i];
			while (true) {
				k = j + d;
				if (k >= a.length)
					k = k - a.length;
				if (k == i)
					break;
				a[j] = a[k];
				j = k;
			}
			a[j] = temp;
		}
		return a;
	}

	// follow euclidean algorithm to subtract smaller from largest
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		// System.out.println(Arrays.toString(rotLeft(a, 2)));
		System.out.println(Arrays.toString(rotLeftEfficient(a, 2)));
	}

}
