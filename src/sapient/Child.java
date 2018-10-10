/**
 * 
 */
package sapient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 * @author kxhb130
 *
 */
class Parent {
	static {
		System.out.println("static Parent");
	}

	Parent() {
		System.out.println("cons Parent");
	}

	static void test() {
		System.out.println("parent test");
	}
	
	Parent display(int i) {
		System.out.println("Parent");
		return null;
	}
}

public class Child extends Parent {
	static {
		System.out.println("static child");
	}

	Child() {
		System.out.println("cons child");
	}

	static void test() {
		System.out.println("child test");
	}
	
	Child display(int i) {
		System.out.println("child");
		return null;
	}

	public static void main(String s[]) {
		Child p = new Child();
		p.test();
		p.display(5);
		List<Integer> list = new Vector<>();
		list.add(null);
		System.out.println(list);
	}
}
