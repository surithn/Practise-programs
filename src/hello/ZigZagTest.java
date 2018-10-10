/**
 * 
 */
package hello;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 P.......A........H.......N
 ..A..P....L....S....I...I....G
 ....Y.........I........R
 And then read line by line: PAHNAPLSIIGYIR
 Write the code that will take a string and make this conversion given a number of rows:
 
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 **Example 2 : **
 ABCD, 2 can be written as
 
 A....C
 ...B....D
 and hence the answer would be ACBD.
 
 * @author kxhb130
 * 
 * formula:  2*n-2
 *
 */
public class ZigZagTest {

	public static void zigzag(String str, int n) {
		if (str == null || str.isEmpty() || str.length() <=2 || n <=2)
			System.out.println(str);
		
		int k=2*n-2;
		for (int i=0; i<n; i++) {
			int cur = i;
			for (int j=0; j<str.length(); j++) {
				if (cur < str.length())
					System.out.print(str.charAt(cur));
				cur += k;
				if (i>0 && i< n-1 && (cur-2*i) < str.length()) {
					System.out.print(str.charAt(cur));
				}
			}
		}
	}

	public static void main(String[] args) {
		zigzag("PAYPALISHIRING", 3);
	}

}
