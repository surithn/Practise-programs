package hello;

/**
 * @author kxhb130
 *
 *         points to remember: left is smaller right is larger than root
 */
public class BinarySearchTreeImplTest {

	BinarySearchTreeImplTest left, right;
	int data;

	public BinarySearchTreeImplTest(int dt) {
		this.data = dt;
	}

	public void insert(int dt) {
		if (dt <= this.data) {
			if (left == null)
				left = new BinarySearchTreeImplTest(dt);
			else
				left.insert(dt);
		} else {
			if (right == null)
				right = new BinarySearchTreeImplTest(dt);
			else
				right.insert(dt);
		}
	}

	public boolean contains(int dt) {
		if (dt == data) {
			return true;
		} else if (dt < data) {
			if (left == null)
				return false;
			else
				return left.contains(dt);
		} else {
			if (right == null)
				return false;
			else
				return right.contains(dt);
		}
	}

	// traversal: left - root - right
	public void println() {
		if (left != null)
			left.println();

		System.out.println(data);

		if (right != null)
			right.println();
	}
	
	/**
	 * left - root - right
	 * @param bo
	 */
	public void inOrder(BinarySearchTreeImplTest bo) {
		if (bo.left != null) 
			inOrder(bo.left);
		System.out.println(bo.data);
		if (bo.right != null)
			inOrder(bo.right);
	}
	
	/**
	 * root - left - right
	 * @param bo
	 */
	public static void preOrder(BinarySearchTreeImplTest bo) {
		System.out.println(bo.data);
		if (bo.left != null) 
			preOrder(bo.left);
		if (bo.right != null)
			preOrder(bo.right);
	}
	
	/**
	 * left - right - root
	 * @param bo
	 */
	static void postOrder(BinarySearchTreeImplTest bo) {
		if (bo.left != null)
			postOrder(bo.left);
		if (bo.right != null)
			postOrder(bo.right);
		System.out.println(bo.data);
	}
	
	public static void main(String[] args) {
		BinarySearchTreeImplTest bo = new BinarySearchTreeImplTest(10);
		bo.insert(5);
		bo.insert(15);
		bo.insert(7);
		bo.insert(21);
		bo.insert(14);
		// bo.println();
		// System.out.println(bo.contains(14));
		// bo.inOrder(bo);
		//preOrder(bo);
		postOrder(bo);
	}

}
