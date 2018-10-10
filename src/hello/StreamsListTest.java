package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Person {
	int age;
	String name;

	Person(int age, int name) {
		this.age = age;
		this.name = String.valueOf(name);
	}

	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [age=" + age + ", " + (name != null ? "name=" + name : "") + "]";
	}
}

public class StreamsListTest {

	static int max(List<Integer> list) {
		return list.stream().mapToInt(v -> v).max().getAsInt();
	}

	static void maxPerson(List<Person> list) {
//		System.out.println(list.stream().max(Comparator.comparing(Person::getAge)).get().toString());
//		System.out.println(list.stream().min(Comparator.comparing(Person::getAge)).get().toString());
		List<String> str = list.stream().filter(fil -> fil.getAge()>5).map(Person::getName).collect(Collectors.toList());
		str.stream().forEach(act -> System.out.println(act));
	}

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
		List<Person> list = new ArrayList<>();
		IntStream.range(0, 10).forEach(action -> {
			list.add(new Person(action, action));
		});
		System.out.println(max(listOfIntegers));
		maxPerson(list);
	}

}
