/**
 * 
 */
package hello;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kxhb130
 *
 */
public class SynchronizedTest {

	public void nonSyncMethod() throws InterruptedException {
		System.out.println("nonSyncMethod=> start" + Calendar.getInstance().getTime());
		Thread.sleep(5000);
		System.out.println("nonSyncMethod=> end" + Calendar.getInstance().getTime());
	}

	public synchronized void methodLevel() throws InterruptedException {
		System.out.println("methodLevel=> start" + Calendar.getInstance().getTime());
		Thread.sleep(15000);
		System.out.println("methodLevel=> end" + Calendar.getInstance().getTime());
	}

	public void blockLevel() throws InterruptedException {
		System.out.println("blockLevel => start" + Calendar.getInstance().getTime());
		synchronized (this) {
			Thread.sleep(5000);
		}
		System.out.println("blockLevel => end" + Calendar.getInstance().getTime());
	}

	public synchronized void method2Level() throws InterruptedException {
		System.out.println("method2Level => start" + Calendar.getInstance().getTime());
		Thread.sleep(10000);
		System.out.println("method2Level => end" + Calendar.getInstance().getTime());
	}

	public static void classLevel(String name) throws InterruptedException {
		System.out.println("classLevel => start => " + name + " " + Calendar.getInstance().getTime());
		synchronized (SynchronizedTest.class) {
			System.out.println("classLevel => inside block => " + name + " " + Calendar.getInstance().getTime());
			Thread.sleep(20000);
		}
		System.out.println("classLevel => end => " + name + " " + Calendar.getInstance().getTime());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedTest singleObj = new SynchronizedTest();

		ExecutorService exe = Executors.newFixedThreadPool(3);
		Runnable one = () -> {
			try {
				singleObj.methodLevel();
			} catch (InterruptedException e) {
				System.out.println("methodLevel=> error" + e.getMessage());
			}
		};
		Runnable two = () -> {
			try {
				singleObj.blockLevel();
			} catch (InterruptedException e) {
				System.out.println("blockLevel=> error" + e.getMessage());
			}
		};
		Runnable three = () -> {
			try {
				singleObj.method2Level();
			} catch (InterruptedException e) {
				System.out.println("method2Level=> error" + e.getMessage());
			}
		};
		Runnable four = () -> {
			try {
				singleObj.nonSyncMethod();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		};
		Runnable five = () -> {
			try {
				SynchronizedTest.classLevel(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				System.out.println("classLevel=> error" + e.getMessage());
			}
		};
		Runnable six = () -> {
			try {
				SynchronizedTest.classLevel(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				System.out.println("classLevel six=> error" + e.getMessage());
			}
		};
		exe.submit(three);
		// exe.submit(one);
		// exe.submit(six);
		exe.submit(four);
		exe.submit(five);
		// exe.submit(two);
		exe.shutdown();
		System.out.println("process completed");
	}

}
