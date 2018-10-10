/**
 * 
 */
package hello;

/**
 * @author kxhb130
 * 
 *         It works on divide and conquer technique. Time complexity is O(N log
 *         N).
 *
 *         Merge sort is a divide and conquer algorithm in which need of Random
 *         access to elements is less. So Merge Sort can be used for sorting
 *         Linked list.
 * 
 * 
 *         How Merge Sort works Merge Sort works by breaking the linked list(or
 *         Array) into 2 equal parts say Left half and Right half. Again break 2
 *         list that we got in Step 1 in two equal parts each. Repeat above
 *         steps until only 1 element remains in Linked list (or Array) because
 *         list with only 1 element is always sorted. So in each step we are
 *         breaking the list in Left half and Right half. When complete list is
 *         divided and contains only Single element in Left and Right half each,
 *         Start comparing and sorting each Left and Right half, So that portion
 *         of Linked list will be sorted. Repeat Step 5 for all the remaining
 *         Left and Right half and complete linked list will be sorted.
 */
public class MergeSortLinkedList {

	public static SinglyinkedListTest divideAndMerge(SinglyinkedListTest startNode) {
		if (startNode == null || startNode.getNext() == null) 
			return startNode;
		
		SinglyinkedListTest mid = findMiddleNode(startNode);
		SinglyinkedListTest second = mid.getNext();
		mid.next = null;
		
		SinglyinkedListTest leftArray = divideAndMerge(startNode);
		SinglyinkedListTest rightArray = divideAndMerge(second);
		return merger(leftArray, rightArray);
	}
	
	private static SinglyinkedListTest merger(SinglyinkedListTest leftArray, SinglyinkedListTest rightArray) {
		if (leftArray == null)
			return rightArray;
		if (rightArray == null)
			return leftArray;
		SinglyinkedListTest res;
		if (leftArray.data < rightArray.data) {
			res = new SinglyinkedListTest(leftArray.data);
			res.next = merger(leftArray.getNext(), rightArray);
		} else {
			res = new SinglyinkedListTest(rightArray.data);
			res.next = merger(leftArray, rightArray.getNext());
		}
		return res;
	}

	/**
	 * @param startNode
	 * @return middle node
	 */
	private static SinglyinkedListTest findMiddleNode(SinglyinkedListTest node) {
		if (node == null)
			return node;
		
		// tortoise and hair contest - 1x and 2x 
		SinglyinkedListTest tortoise = node;
		SinglyinkedListTest hair = node;
		
		// by the time tortoise reached half, hair would have reached end
		while (hair != null && hair.getNext()!= null && hair.getNext().getNext() != null) {
			tortoise = tortoise.getNext();
			hair = hair.getNext().getNext();
		}
		return tortoise;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SinglyinkedListTest bo = new SinglyinkedListTest(10);
		bo = SinglyinkedListTest.insertAtBeginning(bo, 40);
		bo = SinglyinkedListTest.insertAtBeginning(bo, 30);
		bo = SinglyinkedListTest.insertAtBeginning(bo, 50);
		bo = SinglyinkedListTest.insertAtBeginning(bo, 70);
		SinglyinkedListTest.printOrdered(bo);
		System.out.println();
		SinglyinkedListTest.printOrdered(divideAndMerge(bo));
	}

}
