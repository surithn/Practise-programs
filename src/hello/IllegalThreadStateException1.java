/**
 * 
 */
package hello;

/**
 * @author kxhb130
 *
 */
public class IllegalThreadStateException1 {
	public static void main(String[] s) {
		Runnable r = () -> System.out.println("hello surith");
		Thread t = new Thread(r);
		try {
			t.start();
			System.out.println("first start over");
			t.start();
			System.out.println("second start over");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
