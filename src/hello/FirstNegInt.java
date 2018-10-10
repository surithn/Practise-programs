package hello;

import java.util.stream.IntStream;

/**
 * @author kxhb130 First negative integer in every window of size k
 * @see Given an array and a positive integer k, find the first negative integer
 *      for each and every window(contiguous subarray) of size k. If a window
 *      does not contain a negative interger, then print 0 for that window.
 * 
 */
public class FirstNegInt {

	public static void main(String[] args) {
		int arr[] = {-8, 2, 3, -6, 10};
		int window = 2;
		 firstNegInt(arr, window);
		int[] test2 = {12, -1, -7, 8, -15, 30, 16, 28};
		firstNegInt(test2, 3);
	}

	private static void firstNegInt(int[] arr, int window) {
		IntStream.range(0, arr.length-window).forEach(action -> {
			int boo = 0;
			for(int i=action; i<=action+window; i++) {
				if(arr[i] < 0) {
					boo = arr[i];
					break;
				}
			}
			System.out.println(boo);
		});
	}

}
