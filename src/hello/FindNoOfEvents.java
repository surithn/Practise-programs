/**
 * 
 */
package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class FindNoOfEvents {

	public static int[] getMinStartTime(List<int[]> list, int preEnd) {
		int min = list.stream().filter(pre -> (pre[0] > preEnd)).mapToInt(mapper -> mapper[0]).min().orElse(0);
		int sec = list.stream().filter(pre -> pre[0] == min).mapToInt(two -> two[1]).min().orElse(0);
		int[] res = { min, sec };
		return res;
	}

	public static int findIfICanAttend(List<int[]> list) {
		list.removeIf(pre -> (pre[1] <= pre[0] || pre[0] > 24 || pre[1] > 24));
		Set<Integer> set = new HashSet<>();
		do {
			int[] mins = getMinStartTime(list, set.stream().mapToInt(Integer::intValue).max().orElse(0));
			if (mins[0] == 0 || mins[1] == 0)
				break;
			System.out.println(Arrays.toString(mins));
			set.add(mins[1]);
			list.removeIf(fil -> fil[0] == mins[0]);
		} while (list.size() > 0);
		return set.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nos = in.nextInt();
		List<int[]> list = new ArrayList<>();

		if (nos < 1 || nos > 1000) {
			in.close();
			return;
		}

		IntStream.range(0, nos).forEach(evt -> {
			int[] arr = new int[2];
			arr[0] = in.nextInt();
			arr[1] = in.nextInt();
			list.add(arr);
		});
		in.close();
		IntStream.range(0, 1001).forEach(action -> {
			int[] arr = {action, action+1};
			list.add(arr);
		});
		System.out.println(findIfICanAttend(list));

	}

}
