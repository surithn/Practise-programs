/**
 * 
 */
package hello;

/**
 * Lowest Common Ancestor in a Binary Tree
 * 
 * @author kxhb130
 *
 */
public class LCAOfBT {

	// This function returns pointer to LCA of two given
	// values n1 and n2. This function assumes that n1 and
	// n2 are present in Binary Tree
	static Noode lca(Noode root, int n1, int n2) {

		if (root == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.data == n1 || root.data == n2)
			return root;

		Noode left_lca = lca(root.left, n1, n2);
		Noode right_lca = lca(root.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null)
			return root;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
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
