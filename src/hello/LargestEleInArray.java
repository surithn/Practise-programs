/**
 * 
 */
package hello;

import java.util.Arrays;

/**
 * @author kxhb130 Java Program to find largest element in an array
 */
public class LargestEleInArray {

	static int largest(int[] arr) {
		return Arrays.stream(arr).max().getAsInt();
	}

	static int smallest(int[] arr) {
		return Arrays.stream(arr).min().getAsInt();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 20, 10, 20, 4, 100 };
		System.out.println(largest(arr));
		System.out.println(smallest(arr));
	}

}
