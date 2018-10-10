/**
 * 
 */
package hello;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the Number Occurring Odd Number of Times Given an array of positive
 * integers. All numbers occur even number of times except one number which
 * occurs odd number of times. Find the number in O(n) time & constant space.
 * 
 * @author kxhb130
 *
 *
 *         Input : arr = {1, 2, 3, 2, 3, 1, 3} Output : 3
 */
public class FindOddOccurance {

	static Map<Integer, Integer> map = new HashMap<>();

	static void getOddOccurance(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
		}

		System.out.println(
				map.entrySet().stream().max((Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> {
					if (o1.getValue() > o2.getValue() && o1.getValue() % 2 != 0)
						return 1;
					else if (o1.getValue() == o2.getValue())
						return 0;
					return -1;
				}).get().getKey());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		getOddOccurance(arr);
	}

}
