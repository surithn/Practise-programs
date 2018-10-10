package hello;

import java.util.Arrays;

public class BinarySearch {

	public static void insertionSort(int[] a) {
		for (int i=0; i<a.length; i++) {
			for (int j = i; j<a.length-1; j++) {
				if (a[j] < a[i])
					swap(a, i, j);
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		a[i] = a[i]+a[j];
		a[j] = a[i]-a[j];
		a[i] = a[i]-a[j];
	}

	public static boolean find(int[] a, int value, int low, int high) {
		if (a == null) 
			return false;
		
		int mid = low + (high - low)/2;
		if (high < low) 
			return false;
		
		if (a[mid] == value)
			return true;
		
		return a[mid] > value? find(a, value, low, mid):find(a, value, mid+1, high);
	}

	public static void main(String[] args) {
		int[] a = { 10, 70, 30, 80, 60, 50, 40, 20 };
		insertionSort(a);
		System.out.println(Arrays.toString(a));
		 System.out.println(find(a, 70, 0, a.length - 1));
	}

}
