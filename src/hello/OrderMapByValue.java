package hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderMapByValue {

	static void sortByValue(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		Map<String, Integer> map1 = list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(map1);
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("three", 3);
		map.put("four", 4);
		map.put("one", 1);
		map.put("five", 5);
		map.put("two", 2);
		System.out.println(map);
		sortByValue(map);

		System.out.println(map.entrySet().stream().sorted(
				(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> o1.getValue().compareTo(o2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, news) -> old, LinkedHashMap::new)));

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() > o2.getValue())
					return 1;
				else if (o1.getValue() == o2.getValue())
					return 0;
				else
					return -1;
			}
		});
		list.forEach(System.out::println);
	}

}
