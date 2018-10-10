package hello;

/**
 * @author kxhb130 Find a local minima in an array Given an array arr[0 .. n-1]
 *         of distinct integers, the task is to find a local minima in it. We
 *         say that an element arr[x] is a local minimum if it is less than or
 *         equal to both its neighbors.
 * 
 *         For corner elements, we need to consider only one neighbor for
 *         comparison. There can be more than one local minima in an array, we
 *         need to find any one of them.
 */
public class LocalMinimaTest {

	public static void main(String[] args) {
		int[] test1 = { 9, 6, 3, 14, 5, 7, 4 };
		int[] test2 = { 23, 8, 15, 2, 3 };
		int[] test3 = { 3, 2, 1 };
		int[] test4 = { 1, 2, 3 };
		findLocalMinima(test1);
		findLocalMinima(test2);
		findLocalMinima(test3);
		findLocalMinima(test4);

		System.out.println(efficientSolution(test1, 0, test1.length - 1, test1.length));
		System.out.println(efficientSolution(test2, 0, test2.length - 1, test2.length));
		System.out.println(efficientSolution(test3, 0, test3.length - 1, test3.length));
	}

	/**
	 * @param input
	 *            A simple solution is to do a linear scan of array and as soon
	 *            as we find a local minima, we return it. The worst case time
	 *            complexity of this method would be O(n).
	 */
	private static void findLocalMinima(int[] input) {
		if (input == null)
			return;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			if (i == 0 && input[0] < input[1]) {
				sb.append(input[i]);
			} else if (i == input.length - 1 && input[i] < input[i - 1]) {
				sb.append(input[i]);
			} else if (i != 0 && i != input.length - 1 && input[i] < input[i - 1] && input[i] < input[i + 1]) {
				sb.append(input[i]);
			}
		}
		System.out.println(sb.toString());
	}

	/**
	 * @param arr
	 * @param low
	 * @param high
	 * @param len
	 * @return An efficient solution is based on Binary Search. We compare
	 *         middle element with its neighbors. If middle element is not
	 *         greater than any of its neighbors, then we return it. If the
	 *         middle element is greater than its left neighbor, then there is
	 *         always a local minima in left half (Why? take few examples). If
	 *         the middle element is greater than its right neighbor, then there
	 *         is always a local minima in right half (due to same reason as
	 *         left half).
	 */
	private static int efficientSolution(int[] arr, int low, int high, int len) {

		return 0;
	}

}
