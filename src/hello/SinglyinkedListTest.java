package hello;

/**
 * Implement singly linked list
 * 
 * @author kxhb130
 *
 */
public class SinglyinkedListTest {
	int data;
	SinglyinkedListTest next;

	SinglyinkedListTest(int data) {
		this.data = data;
		this.next = null;
	}

	/**
	 * Insert node at end of given list
	 * 
	 * @param head
	 * @param data
	 * @return
	 */
	public static SinglyinkedListTest insertAtTail(SinglyinkedListTest head, int data) {
		if (head == null)
			return new SinglyinkedListTest(data);
		if (head.next != null)
			insertAtTail(head.next, data);
		else 
			head.next = new SinglyinkedListTest(data);
		return head;	
	}

	/**
	 * insert element in front of list
	 * 
	 * @param head
	 * @param data
	 * @return
	 */
	public static SinglyinkedListTest insertAtBeginning(SinglyinkedListTest head, int data) {
		SinglyinkedListTest node = new SinglyinkedListTest(data);
		if (head == null)
			return node;
		node.next = head;
		return node;
	}

	/**
	 * insert element at nth position of linked list
	 * 
	 * @param head
	 * @param data
	 * @param position
	 * @return
	 * @throws Exception
	 */
	public static SinglyinkedListTest insertAtNth(SinglyinkedListTest head, int data, int position) {
		int pointer = 0;
		SinglyinkedListTest temp = head;
		SinglyinkedListTest node = new SinglyinkedListTest(data);
		if (head == null && position > 0)
			throw new IllegalArgumentException("List is Empty to insert data at position");
		if (head == null && position == 0)
			return node;
		
		while (temp != null && pointer < position) {
			if (pointer == position-1) {
				if (temp.next != null) {
					node.next = temp.next;
				} 
				temp.next = node;
				break;
			}
			temp = temp.next;
			pointer++;
		}
		return head;
	}

	public static SinglyinkedListTest deleteNode(SinglyinkedListTest head, int data) throws Exception {
		if (head == null)
			return head;
		if (head.data == data)
			return head.next;
		
		SinglyinkedListTest temp = head;
		while (temp != null) {
			if (temp.next != null && temp.next.data == data) {
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
		}
		return head;
	}

	public static SinglyinkedListTest deleteNodeAtNth(SinglyinkedListTest head, int position) throws Exception {
		int pointer = 0;
		if (head == null & position > 0)
			throw new IllegalArgumentException("invalid input: list is empty");
		if (position == 0)
			return head.next;
		SinglyinkedListTest temp = head;
		while (temp != null && pointer < position) {
			if (pointer == position-1) {
				if (temp.next != null) {
					temp.next = temp.next.next;
				}
				break;
			}
			temp = temp.next;
			pointer++;
		}
		return head;
	}

	public static void printOrdered(SinglyinkedListTest head) {
		System.out.println(head.data);
		if (head.next != null)
			printOrdered(head.next);
	}

	public static void printReverseOrder(SinglyinkedListTest head) {
		if (head.next != null)
			printReverseOrder(head.next);
		System.out.println(head.data);
	}

	/**
	 * reverse given linked list
	 * 
	 * @param head
	 * @return
	 */
	public static SinglyinkedListTest reverse(SinglyinkedListTest head) {
		SinglyinkedListTest cur = head;
		SinglyinkedListTest next = null;
		SinglyinkedListTest pre = null;
		
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	/**
	 * merge two sorted linked list into one
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static SinglyinkedListTest mergeSorted(SinglyinkedListTest head1, SinglyinkedListTest head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		SinglyinkedListTest node;
		
		if (head1.data < head2.data) {
			node = head1;
			node.next = mergeSorted(head1.next, head2);
		} else {
			node = head2;
			node.next = mergeSorted(head1, head2.next);
		}
		return node;
	}

	/**
	 * Delete duplicate-value nodes from a sorted linked list. The initial
	 * linked list is: 1 -> 2 -> 2 -> 3 -> 4 -> NULL
	 * 
	 * The final linked list is: 1 -> 2 -> 3 -> 4 -> NULL
	 * 
	 * @param head
	 * @return
	 */
	static SinglyinkedListTest deleteDuplicateNodes(SinglyinkedListTest head) {
		if (head == null)
			return head;
		SinglyinkedListTest next = head.next;
		while (next != null && next.data == head.data) {
			next = next.next;
		}
		head.next = deleteDuplicateNodes(next);
		return head;
	}

	/**
	 * detect cycle
	 * 
	 * The old "tortoise and the hare" problem. Essentially, the "fast" pointer
	 * moves 2x the speed as the "slow" pointer. If there is a cycle, they will
	 * meet.
	 * 
	 * @param head
	 * @return
	 */
	static boolean hasCycle(SinglyinkedListTest head) {
		if (head == null)
			return false;
		SinglyinkedListTest slow = head;
		SinglyinkedListTest fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	public static void main(String[] s) throws Exception {
		SinglyinkedListTest head = null;
		head = insertAtBeginning(head, 7);
		// printOrdered(head);
		// System.out.println("=============");
		head = insertAtTail(head, 8);
		head = insertAtTail(head, 10);
		// printOrdered(head);
		// System.out.println("=============");
		head = insertAtNth(head, 9, 2);
		head = insertAtTail(head, 11);
		head = insertAtTail(head, 12);
		// printOrdered(head);
//		System.out.println("=============");
		head = deleteNode(head, 12);
		head = deleteNodeAtNth(head, 2);
		head = reverse(head);
		head = reverse(head);
//		printOrdered(head);
//		System.out.println("=============");
		head = insertAtTail(head, 12);
		head = insertAtTail(head, 12);
		head = insertAtTail(head, 13);
		printOrdered(head);
		System.out.println("=============");
		head = deleteDuplicateNodes(head);
		printOrdered(head);
//		printReverseOrder(head);
//		System.out.println("=============");
//		head = reverse(head);
//		printReverseOrder(head);
//		System.out.println("=============");
//		head = reverse(head);
//		SinglyinkedListTest head2 = null;
//		head2 = insertAtBeginning(head2, 13);
//		head2 = insertAtTail(head2, 15);
//		head = insertAtTail(head, 14);
//		head = mergeSorted(head, head2);
//		head = insertAtTail(head, 15);
//		head = insertAtTail(head, 15);
//		// printOrdered(head);
//		head = deleteDuplicateNodes(head);
//		printOrdered(head);
//		
//		// create cycle
//		SinglyinkedListTest temp = head;
//		while(temp != null) {
//			temp = temp.next;
//		}
//		temp = head;
//		printOrdered(head);
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @return the next
	 */
	public SinglyinkedListTest getNext() {
		return next;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(SinglyinkedListTest next) {
		this.next = next;
	}
}
