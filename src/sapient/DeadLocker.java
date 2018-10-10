/**
 * 
 */
package sapient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kxhb130
 *
 */
public class DeadLocker {
	String first = "Surith";
	String last = "Nivas";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeadLocker dl = new DeadLocker();
		Runnable r1 = () -> {
			synchronized (dl.first) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (dl.last) {
					System.out.println(dl.first + dl.last + " -> " + Thread.currentThread().getName());
				}
			}
		};
		Runnable r2 = () -> {
			synchronized (dl.last) {
				synchronized (dl.first) {
					System.out.println(dl.first + dl.last + " -> " + Thread.currentThread().getName());
				}
			}
		};
		System.out.println("gotta start..");
		ExecutorService exe = Executors.newFixedThreadPool(2);
		exe.submit(r1);
		exe.submit(r2);
		System.out.println("brace urself");
	}

}
