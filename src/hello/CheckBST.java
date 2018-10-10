/**
 * 
 */
package hello;

import java.util.ArrayList;
import java.util.List;

/**
 * 2 ways
 * 1. inorder - put it in list and check if its sorted
 * 2. have min and max, reduce it on recursion and check
 * 
 * @author kxhb130
 *
 */
class Node {
	int data;
	Noode left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class CheckBST {

	// Root of the Binary Tree
	static Noode root;
	
	static Noode arrToBst;

	/**
	 * but wrong output sometimes
	 * 
	 * @param root
	 * @return
	 */
	static boolean method1(Noode root) {
		if (root == null)
			return true;

		if (root.left != null && root.left.data > root.data)
			return false;
		if (root.right != null && root.right.data < root.data)
			return false;
		if (!method1(root.left) || !method1(root.right))
			return false;
		return true;
	}

	static List<Integer> list = new ArrayList<>();

	static void method2(Noode root) {
		if (root == null)
			return;
		if (root.left != null)
			method2(root.left);
		list.add(root.data);
		if (root.right != null)
			method2(root.right);
	}

	static boolean method3(Noode root, int min, int max) {
		if (root == null)
			return true;
		if (root.data < min || root.data > max)
			return false;
		return method3(root.left, min, root.data-1)
				&& method3(root.right, root.data+1, max);
		
	}
	
	public static Noode convertSortedArrayToBST(int[] arr, int min, int max) {
		if (max < min)
			return null;
		
		int mid = (min+max)/2;
		Noode left = convertSortedArrayToBST(arr, min, mid-1);
		Noode noode = new Noode(arr[mid]);
		noode.left = left;
		Noode right = convertSortedArrayToBST(arr, mid+1, max);
		noode.right = right;
		return noode;
	}
	
	public static void printBST(Noode noode) {
		if (noode.left != null)
			printBST(noode.left);
		System.out.print(noode.data);
		if (noode.right != null)
			printBST(noode.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		root = new Noode(3);
		root.left = new Noode(7);
		root.right = new Noode(4);
		root.left.left = new Noode(1);
		root.right.right = new Noode(5);
		root.right.right.right = new Noode(16);
		root.right.right.right.left = new Noode(15);
		root.right.right.right.right = new Noode(17);
//		System.out.println(method1(root));
////		method2(root);
////		System.out.println(list);
////		boolean boo = true;
////		for (int i = 0; i < list.size() - 1; i++) {
////			if (list.get(i) > list.get(i + 1)) {
////				boo = false;
////				break;
////			}
////		}
////		System.out.println(boo);
////		String arg= "sur";
////		System.out.println(arg.matches("^su.*"));
//		System.out.println(method3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		int[] arr = {1,2,3,4,5};
		Noode noode = convertSortedArrayToBST(arr, 0, arr.length-1);
		printBST(noode);
		System.out.println();
		System.out.println(method3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
 	}

}
