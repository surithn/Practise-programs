/**
 * 
 */
package hello;

/**
 * @author kxhb130
 *
 */
public class FibanocciSeriesTest {

	static int n1, n3 = 0;
	static int n2 = 1;
	static StringBuilder sb = new StringBuilder();

	static void recursive(int count) {
		n3 = n1+n2;
		sb.append(",");
		sb.append(n3);
		n1= n2;
		n2 = n3;
		if (count > 0)
			recursive(--count);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sb.append(n1);
		sb.append(",");
		sb.append(n2);
		recursive(4);
		System.out.println(sb.toString());
	}

}
