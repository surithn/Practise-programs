/**
 * 
 */
package hello;

/**
 * @author kxhb130
 *
 */
public class StringReversalTest {

	static String recursive(String str) {
		if (str == null || str.length() == 0)
			return "";
		
		return str.charAt(str.length()-1) + recursive(str.substring(0, str.length()-1));
	}

	static String useLib(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	static String iterative(String str) {
		char[] data = str.toCharArray();
		int len = data.length;
		for (int i=0; i<data.length/2; i++) {
			char temp = data[i];
			data[i] = data[len-1-i];
			data[len-1-i] = temp;
		}
		return String.valueOf(data);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(recursive("htirus") + useLib("savin ") + iterative("ssodnahom "));
	}

}
