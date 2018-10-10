/**
 * 
 */
package hello;

/**
 * Lowest Common Ancestor in a Binary Search Tree.
 * 
 * @author kxhb130
 *
 */

class Noode {
	Noode left;
	Noode right;
	int data;
	public Noode(int data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "Noode [data=" + data + "]";
	}
	
	
}

public class LCAOfBST {

	static Noode lca(Noode root, int n1, int n2) {
		if (root == null)
			return null;
		
		// if both are smaller than root then lca lies in left tree
		if (root.data > n1 && root.data > n2) 
			return lca(root.left, n1, n2);
		
		// if both are bigger than root then lca lies in right tree
		if (root.data < n1 && root.data < n2)
			return lca(root.right, n1, n2);
		
		// if above conditions did not match, it means left has n1 & right has n2. hence lca
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Noode root = new Noode(20);
		root.left = new Noode(8);
		root.right = new Noode(22);
		root.left.left = new Noode(4);
		root.left.right = new Noode(12);
		root.left.right.left = new Noode(10);
		root.left.right.right = new Noode(14);
		
		// LCA of 10 and 14 is
		System.out.println(lca(root, 10, 14));
		
		// LCA of 14 and 8 is
		System.out.println(lca(root, 14, 8));
		
		// LCA of 10 and 22 is
		System.out.println(lca(root, 10, 22));
		
	}

}
