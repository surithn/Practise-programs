/**
 * 
 */
package stringReversal;

/**
 * @author kxhb130
 *
 */
public class StringReversal {

	static String recursive(String str) {
		if (str.length() == 0)
			return "";
		return str.charAt(str.length()-1) + recursive(str.substring(0, str.length()-1));
	}
	
	static String looping(String str) {
		if (str.length() == 0)
			return "";
		char[] ch = str.toCharArray();
		int len = str.length();
		for(int i=0; i<len/2; i++) {
			char temp = ch[i];
			ch[i] = ch[len-1-i];
			ch[len-1-i] = temp;
		}
		return String.valueOf(ch);
	}
	
	static String stringBuilder(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "HTIRUS";
		System.out.println(recursive(str));
		System.out.println(recursive(String.valueOf(12345)));
		System.out.println(looping(str));
		System.out.println(stringBuilder(str));
	}

}
