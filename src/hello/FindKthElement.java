/**
 * 
 */
package hello;

import java.util.Arrays;

/**
 * @author kxhb130
 *
 */
public class FindKthElement {

	static int sortAndFindK(int[] a, int k) {
		Arrays.sort(a);
		return a[k-1];
	}
	
	static int unSortAndFindK(int[] a, int k) {
		return a[k-1];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a ={12, 3, 5, 7, 19};
		System.out.println(unSortAndFindK(a, 4));
		System.out.println(sortAndFindK(a, 4));
	}

}
