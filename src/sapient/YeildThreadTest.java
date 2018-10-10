package sapient;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kxhb130 juz used to free up or relinquish CPU to Thread scheduler for
 *         other threads to utilize but only for some time.
 *
 */
public class YeildThreadTest {

	public String str;

	public static void main(String[] args) {
		YeildThreadTest y = new YeildThreadTest();
		Runnable r1 = () -> {
			int i = 0;
			synchronized (y) {
				while (i < 10) {
					System.out.println(Thread.currentThread().getName() + "=> before yield"
							+ Calendar.getInstance().getTime().toString());
					if (i == 7) {
						System.out.println(Thread.currentThread().getName() + "=> i=75 yield"
								+ Calendar.getInstance().getTime().toString());
						Thread.yield();
					}

					System.out.println(Thread.currentThread().getName() + "=> after yield"
							+ Calendar.getInstance().getTime().toString());
					i++;
				}
			}
		};
		Runnable r2 = () -> {
			System.out.println(
					Thread.currentThread().getName() + "=> before yield" + Calendar.getInstance().getTime().toString());
			Thread.yield();
			System.out.println(
					Thread.currentThread().getName() + "=> after yield" + Calendar.getInstance().getTime().toString());
		};
		ExecutorService exe = Executors.newFixedThreadPool(2);
		exe.submit(r1);
		exe.submit(r2);
		exe.shutdown();
	}

}
