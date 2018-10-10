/**
 * 
 */
package sapient;

/**
 * @author kxhb130
 *
 */
public class JoinThread extends Thread {

	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + "-> inside run 1");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Thread.currentThread().getName() + "-> exits run 2");
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread dl = new JoinThread();
		dl.start();
		synchronized (dl) {
			System.out.println(Thread.currentThread().getName() + "-> inside main 1");
			try {
				Thread.sleep(10000);
				dl.join();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Thread.currentThread().getName() + "-> exits main 2");
			Thread daemon = new Thread() {
				@Override
				public void run() {
					while (true) {
						System.out.println("true");
					}
				}
			};
			System.out.println("create daemon thread start");
			daemon.setName("daemon");
			daemon.setDaemon(true);
			daemon.start();
			System.out.println("main thread ends");
		}

	}

}
