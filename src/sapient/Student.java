package sapient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class A {
}

class B extends A {
}

class C extends B {
}

public class Student {

	Student() {
		
	}
	public static void main(String args[]) {
		float f = \u0038;
		System.out.println(f);

		Student s = new Student();
		String str = "Student";
		//System.out.println(str instanceof Student);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(Collections.binarySearch(list, 4));

		boolean bool = true;
		if (bool = false) {
			System.out.println("a");
		} else if (bool) {
			System.out.println("b");
		} else if (!bool) {
			System.out.println("c");
		} else {
			System.out.println("d");
		}

		try {
			int x = 10 / 0;
		} catch (Exception e) {
			System.out.println(args[0]);
			System.out.println(e);
		}
	}
}
