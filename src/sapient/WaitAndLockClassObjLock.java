/**
 * 
 */
package sapient;

import java.util.Calendar;

/**
 * @author kxhb130 For synchronizing and communicaion between threads, we use
 *         wait() and notify() method inside synchronized method/block. Threads
 *         acquire lock on common object and then calls wait() and notify() on
 *         same object for their communication. How to communicate between
 *         Threads which acquire class level lock. wait() and notify() are not
 *         static and is instance method, so how to use for communication
 *         between Threads which acquire class level lock?
 *
 *         The reason to call wait() is that the thread does not want to execute
 *         a block of code until a particular state to be achieved. It wants to
 *         wait until a particular state to be achieved. The reason to call
 *         notify() or notifyAll() method is that the thread will signal others
 *         that "a particular state has been achieved". The state is a
 *         communication channel between threads and it must be shared mutable
 *         state.
 * 
 *         For example, one thread read data from a buffer and one thread write
 *         data into buffer. The reading data thread needs to wait until the
 *         writing data thread completly write a block data into the buffer. The
 *         wirting data thread needs to wait until the reading data thread
 *         completly read the data from the buffer. If wait(), notify(), and
 *         notifyAll() methods can be called by a ordinary method , the reading
 *         thread calls wait() and the thread is being added to waiting queue .
 *         At just the same moment, the writing thread calls notify() to signal
 *         the condition changes. The reading thread misses the change and waits
 *         forever. Hence, they must be called inside a synchronized method or
 *         block which is mutually exclusive.
 * 
 */
public class WaitAndLockClassObjLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WaitAndLockClassObjLock obj = new WaitAndLockClassObjLock();

		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " one start");
				obj.getA();
				System.out.println(Thread.currentThread().getName() + " one end");
			}
		}.start();

		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " two start");
				obj.getB();
				System.out.println(Thread.currentThread().getName() + " two end");
			}
		}.start();

		// new Thread() {
		// public void run() {
		// System.out.println(Thread.currentThread().getName() + " three
		// start");
		// WaitAndLockClassObjLock.getStatic();
		// System.out.println(Thread.currentThread().getName() + " three end");
		// }
		// }.start();
		//
		// new Thread() {
		// public void run() {
		// System.out.println(Thread.currentThread().getName() + " four start");
		// WaitAndLockClassObjLock.getStatic();
		// System.out.println(Thread.currentThread().getName() + " four end");
		// }
		// }.start();
	}

	public synchronized void getA() {
		System.out.println(Thread.currentThread().getName() + " inside obj getA");
		try {
			Thread.sleep(5000);
			System.out.println("getA sleep ends " + Calendar.getInstance().getTime().toString());
			wait();
			System.out.println("getA wait ends " + Calendar.getInstance().getTime().toString());
			Thread.sleep(5000);
			System.out.println("getA sleep-1 ends " + Calendar.getInstance().getTime().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public synchronized void getB() {
		System.out.println(Thread.currentThread().getName() + " inside obj getB");
		try {
			Thread.sleep(5000);
			System.out.println("getB sleep ends " + Calendar.getInstance().getTime().toString());
			notify();
			System.out.println("getB notify ends " + Calendar.getInstance().getTime().toString());
//			synchronized (this) {
//				System.out.println("getB second sync start " + Calendar.getInstance().getTime().toString());
//			}
//			System.out.println("getB second sync end " + Calendar.getInstance().getTime().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static synchronized void getStatic() {
		System.out.println(Thread.currentThread().getName() + " inside static");
	}
}
