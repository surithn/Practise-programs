package stringReversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionReversal {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(13);
		list.add(23);
		list.add(33);
		list.add(43);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		int size = list.size();
		for (int i = 0; i < size/2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(size-1-i));
			list.set(size-1-i, temp);
		}
		System.out.println(list);
	}

}
