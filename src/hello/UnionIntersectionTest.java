package hello;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnionIntersectionTest {

	static boolean res = true;

	static int[] intersection(int[] a, int[] b) {
		Map<Integer, Integer> set = new HashMap<>();
		Arrays.stream(a).forEach(action -> set.put(action, 1));
		Arrays.stream(b).forEach(action -> {
			if (set.containsKey(action))
				set.put(action, set.get(action) + 1);
		});
		return set.entrySet().stream().filter(pre -> pre.getValue() > 1).mapToInt(Map.Entry::getKey).toArray();
	}

	static int[] union(int[] a, int[] b) {
		Set<Integer> set = new HashSet<>();
		Arrays.stream(a).forEach(action -> set.add(action));
		Arrays.stream(b).forEach(action -> set.add(action));
		return set.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7 };
		int[] b = { 2, 4, 5, 8 };
		System.out.println(Arrays.toString(union(a, b)));
		System.out.println(Arrays.toString(intersection(a, b)));
	}

}
