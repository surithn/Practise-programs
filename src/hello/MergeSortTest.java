/**
 * 
 */
package hello;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 *         Divide sort and merge them
 */
public class MergeSortTest {
	static int[] divider(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high-low)/2;
			divider(arr, low, mid);
			divider(arr, mid+1, high);
			merger(arr, low, mid, high);
		}
		return arr;
	}

	private static void merger(int[] arr, int low, int mid, int high) {
		int size1 = mid-low+1;
		int size2 = high-mid;
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		IntStream.range(0, size1).forEach(i -> arr1[i] = arr[low+i]);
		IntStream.range(0, size2).forEach(i -> arr2[i] = arr[mid+i+1]);
		
		int i=0, j=0, k=low;
		
		while (i<size1 && j<size2) {
			if (arr1[i] <= arr2[j]) {
				arr[k] = arr1[i];
				i++;
			} else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while (i<size1) {
			arr[k] = arr1[i];
			i++;
			k++;
		}
		
		while (j<size2) {
			arr[k] = arr2[j];
			j++;
			k++;
		}
	}

	public static void main(String[] ar) {
		int[] arr = { 1, 4, 2, 6, 3, 7, 9, 8 };
		System.out.println(Arrays.toString(divider(arr, 0, arr.length - 1)));
	}
}
