/**
 * 
 */
package hello;

import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class PrintPatternTest {

	static void pyramid(int n) {
		IntStream.range(1, n).forEach(i -> {
			IntStream.range(0, i).forEach(System.out::print);
			System.out.println();
		});
	}
	
	static void invertedPyramid(int n) {
		IntStream.range(1, n+1).forEach(i -> {
			IntStream.range(0, n-i).forEach(System.out::print);
			System.out.println();
		});
	}
	
	// formula: k=n*2-2
	static void triangle(int n) {
		int k=2*n-2;
		for (int i=0; i<n; i++) {
			for (int j=0; j<k; j++)
				System.out.print(" ");
			k -= 1;
			for (int j=0; j<i; j++)
				System.out.print("* ");
			System.out.println();
		}
	}
	
	static void pascalTriangle(int n) {
		int k = 2*n-2;
		int b=1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<k; j++) 
				System.out.print(" ");
			k -= 1;
			
			for (int j=0; j<=i; j++) {
				if (j==0 || i==0)
					b=1;
				else
					b = (b*(i-j+1))/j;
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		pyramid(5);
		System.out.println();
		invertedPyramid(5);
		System.out.println();
		triangle(5);
		System.out.println();
		pascalTriangle(5);
	}

}
