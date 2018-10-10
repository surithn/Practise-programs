/**
 * 
 */
package sapient;

import java.util.Calendar;

/**
 * @author kxhb130
 *
 */
public class TestSynchronization1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSynchronization1 te = new TestSynchronization1();
		Runnable ru = () -> te.getA();
		Thread t1 = new Thread(ru);
		Thread t2 = new Thread() {
			public void run() {
				te.getB();
			}
		};
		t1.start();
		t2.start();
	}

	public synchronized void getA() {
		System.out.println("start getA " + Calendar.getInstance().getTime().toString());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end getA " + Calendar.getInstance().getTime().toString());
	}

	public void getB() {
		System.out.println("start getB " + Calendar.getInstance().getTime().toString());
		try {
			synchronized(this) {Thread.sleep(5000);}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end getB " + Calendar.getInstance().getTime().toString());
	}
}
