package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kxhb130 find odd numbers between the given number frame
 */
public class FindOddNumbers {

	static int[] findOdd(int l, int r) {
		List<Integer> list = new ArrayList<>();
		for (int i = l; i <= r; i++) {
			if (i % 2 != 0)
				list.add(i);
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOdd(1, 7)));
	}

}
