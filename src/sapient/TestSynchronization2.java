/**
 * 
 */
package sapient;

import java.util.Calendar;

/**
 * @author kxhb130
 *
 */
public class TestSynchronization2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSynchronization2 te = new TestSynchronization2();
		Thread t1 = new Thread() {
			public void run() {
				te.getA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				te.getB();
			}
		};
		t1.start();
		t2.start();
	}

	public void getA() {
		synchronized (this) {
			System.out.println("start getA " + Calendar.getInstance().getTime().toString());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end getA " + Calendar.getInstance().getTime().toString());
	}

	public void getB() {
		synchronized (this) {
			System.out.println("start getB " + Calendar.getInstance().getTime().toString());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end getB " + Calendar.getInstance().getTime().toString());
	}

}
