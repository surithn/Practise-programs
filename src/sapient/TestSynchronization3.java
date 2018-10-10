/**
 * 
 */
package sapient;

import java.util.Calendar;

/**
 * @author kxhb130
 *
 */
public class TestSynchronization3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSynchronization3 te = new TestSynchronization3();
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
		Thread t3 = new Thread() {
			public void run() {
				te.getC();
			}
		};
		t1.start();
		t2.start();
		t3.start();
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
		System.out.println("start getB " + Calendar.getInstance().getTime().toString());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end getB " + Calendar.getInstance().getTime().toString());
	}

	public void getC() {
		synchronized (this) {
			System.out.println("start getC " + Calendar.getInstance().getTime().toString());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end getC " + Calendar.getInstance().getTime().toString());
	}

}
