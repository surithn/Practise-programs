package hello;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseJavaCollectionObjTest {
	static <T> void reverse(List<T> list) {
		int len = list.size()/2;
		IntStream.range(0, len).forEach(action -> {
			Collections.swap(list, action, list.size()-1-action);
//			Object temp = list.get(action);
//			list.set(action, list.get(list.size()-1-action));
//			list.set(list.size()-1-action, (T) temp);
		});
		
	}

	public static void main(String[] args) {
		List<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(4);
		list1.add(3);
		System.out.println(list1);
		reverse(list1);
		System.out.println(list1);
		reverse(list1);
		System.out.println(list1);
	}

}
