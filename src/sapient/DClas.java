/**
 * 
 */
package sapient;

/**
 * @author kxhb130
 *
 */
interface Kinterface {
	void test();
}

class BCla implements Kinterface {
	public void test() {
		System.out.println("test BCla");
	}
}

class CClas implements Kinterface {
	public void test() {
		System.out.println("test CClas");
	}

	public void check() {
		System.out.println("check CClas");
	}
}

public class DClas extends BCla {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kinterface a = new DClas();
		BCla b = new DClas();
		Kinterface c = new DClas();
		a.test();
		b.test();
		c.test();
		((CClas) c).check();
	}

}
