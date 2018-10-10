/**
 * 
 */
package sapient;

import java.util.Calendar;

/**
 * @author kxhb130
 *
 */
public class TestSynchronization4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSynchronization4 te = new TestSynchronization4();
		Thread t1 = new Thread() {
			public void run() {
				te.getA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				te.getA();
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				te.getA();
			}
		};
		t1.start();
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
	}

	public void getA() {
		System.out.println("start " +Thread.currentThread().getName()+ Calendar.getInstance().getTime().toString());
		synchronized (this) {
			System.out.println("inside " +Thread.currentThread().getName()+ Calendar.getInstance().getTime().toString());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end " +Thread.currentThread().getName()+ Calendar.getInstance().getTime().toString());
	}
}
