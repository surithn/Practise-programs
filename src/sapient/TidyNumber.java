package sapient;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * @author kxhb130 Given a number, the task is to check if it is tidy or not. A
 *         tidy number is a number whose digits are in non-decreasing order.
 */
public class TidyNumber {
	static boolean res = true;
	static boolean checkIfTidy(int[] a) {
		for(int i=0; i<a.length-1; i++) {
			if (!(a[i] < a[i+1] && res))
				res = false;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,4,5};
		System.out.println(checkIfTidy(a));
		
	}

}
