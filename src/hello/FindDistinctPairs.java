/**
 * 
 */
package hello;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kxhb130
 *
 */
public class FindDistinctPairs {

	private static final int MAX = 100000; // Max size of Hashmap

	static int moreTime(int arr[], int n) {
		Set<Integer> set = new HashSet<>();
		for (int i=0; i<arr.length; i++) {
			int first = arr[i];
			for (int j=i+1; j<arr.length; j++) {
				int second = arr[j];
				if ((first+second==n) && !set.contains(first) && !set.contains(second))
					set.add(first);
			}
		}
		return set.size();
	}

	/**
	 * works good but only for array with small integers as it will throw
	 * arrayindexoutofbound exception
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	static int lessTimeButForSmallNumbers(int arr[], int n) {
		boolean[] boo = new boolean[MAX];
		Set<Integer> set = new HashSet<>();
		for (int i=0; i<arr.length; i++) {
			int temp = n-arr[i];
			if (temp > 0 && boo[temp] && !set.contains(temp) && !set.contains(arr[i]))
				set.add(arr[i]);
				
			boo[arr[i]] = true;
		}
		return set.size();
	}

	static int efficientTime(int arr[], int n) {
		Set<Integer> tar = new HashSet<>();
		Set<Integer> result = new HashSet<>();
		for (int i=0; i<arr.length; i++) {
			int target = n-arr[i];
			if (!tar.contains(target))
				tar.add(arr[i]);
			else {
				if (!result.contains(target) && !result.contains(arr[i]))
					result.add(arr[i]);
			}
		}
		return result.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = { 7, 6, 12, 3, 9, 3, 5, 1, 7, 6, 12, 3, 9, 3, 5, 1, 7, 6, 12, 3, 9, 3, 5, 1, 7, 6, 12, 3, 9, 3, 5, 1,
				7, 6, 12, 3, 9, 3, 5, 1, 7, 6, 12, 3, 9, 3, 5, 1, 7, 6, 112, 13, 19, 13, 15, 11, 17, 16, 112, 13, 19,
				13, 15, 11 };
		System.out.println(moreTime(A, 12));
		System.out.println(lessTimeButForSmallNumbers(A, 12));
		System.out.println(efficientTime(A, 12));
	}

}
