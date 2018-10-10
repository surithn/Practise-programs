/**
 * 
 */
package sapient;

/**
 * @author kxhb130
 *
 */
public class ThreadDemo1 extends Thread implements Runnable {

//	public void run() {
//		System.out.println("hi");
//	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Thread tj = new ThreadDemo1();
			tj.start();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
