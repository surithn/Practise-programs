/**
 * 
 */
package hello;

import java.util.Stack;

/**
 * Reverse a stack using recursion
 * 
 * Write a program to reverse a stack using recursion. You are not allowed to
 * use loop constructs like while, for..etc, and you can only use the following
 * ADT functions on Stack S: isEmpty(S) push(S) pop(S)
 * 
 * @author kxhb130
 *
 */
public class TestStack {

	static Stack<Integer> st = new Stack<>();

	static void reverse() {
		if (st.size() > 0) {
			Integer ch = st.pop();
			reverse();
			insert(ch);
		}
	}

	static void insert(int i) {
		if (st.isEmpty())
			st.push(i);
		else {
			int ch = st.pop();
			insert(i);
			st.push(ch);
		}
	}

	public static void main(String str[]) {
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st.toString());
		reverse();
		System.out.println(st.toString());
	}
}
