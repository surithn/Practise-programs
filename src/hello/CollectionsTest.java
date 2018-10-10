/**
 * 
 */
package hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class CollectionsTest {

	private int id;
	private String name;
	private int age;

	/**
	 * @param id
	 * @param name
	 * @param age
	 */
	public CollectionsTest(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<CollectionsTest> list = new ArrayList<>();
		IntStream.range(5, 10).forEach(data -> list.add(new CollectionsTest(data, String.valueOf(data), data)));
		IntStream.range(0, 5).forEach(data -> list.add(new CollectionsTest(data, String.valueOf(data), data)));
		
//		list.stream().sorted(Comparator.comparing(CollectionsTest::getName))
//			.map(map -> map.getName().toUpperCase()).forEach(System.out::println);
		
//		list.stream().sorted(Comparator.comparingInt(CollectionsTest::getAge))
//			.forEach(System.out::println);
		
		
		System.out.println(list.stream().map(map -> map.getAge()).collect(Collectors.toList())
			.stream().reduce(0, (x,y) -> x+y).intValue());
		
		Map<CollectionsTest, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(list.stream().map(CollectionsTest::getName)
		.reduce("+", (x,y) -> x+"-"+y));
		
		System.out.println(list.stream().map(CollectionsTest::getAge).max(Comparator.comparingInt(Integer::intValue)).get());
		Map<CollectionsTest, Long> mas =  map.entrySet().stream().sorted(Map.Entry.comparingByValue())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, nes) -> old, LinkedHashMap::new));
		System.out.println(mas);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CollectionsTest [id=" + id + ", " + (name != null ? "name=" + name + ", " : "") + "age=" + age + "]";
	}
}
