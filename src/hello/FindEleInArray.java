/**
 * 
 */
package hello;

import java.util.Arrays;

/**
 * @author kxhb130
 * method to check if given element is present in array
 *
 */
public class FindEleInArray {

	static int checkUsingRecursive=0;
	static int checkUsingSplitIteration=1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,4,5,8,13,24,36,47,58,69,78,80, 81,82,83,84,85,86,97,98,99,100,102,103,104};
		System.out.println(checkUsingStream(arr, 8));
		System.out.println(checkUsingSplitIteration(arr, 58)+ " "+ checkUsingSplitIteration);
		System.out.println(checkUsingRecursive(arr, 58) + " "+ checkUsingRecursive);
	}

	private static boolean checkUsingStream(int[] arr, int i) {
		return Arrays.stream(arr).anyMatch(pre -> pre==i);
	}

	private static boolean checkUsingSplitIteration(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int mid = arr.length/2;
		if (k == arr[mid])
			return true;
		else {
			for (int i= (k>arr[mid])?mid:0; i < ((k>arr[mid])?arr.length:mid); i++) {
				checkUsingSplitIteration++;
				if (arr[i]==k)
					return true;
			}
		}
		return false;
	}
	
	private static boolean checkUsingRecursive(int[] arr, int k) {
		checkUsingRecursive++;
		if (arr == null || arr.length == 0) {
			return false;
		}
		
		int mid = arr.length/2;
		if (k == arr[mid])
			return true;
		else if (arr.length == 2 && k==arr[mid+1])
			return true;
		else if (k>arr[mid])
			return checkUsingRecursive(Arrays.copyOfRange(arr, mid, arr.length), k);
		else if (k<arr[mid])
			return checkUsingRecursive(Arrays.copyOfRange(arr, 0, mid), k);
		else
			return false;
	}
}
