/**
 * 
 */
package sapient;

/**
 * @author kxhb130
 *
 */
public class ThreadExceptionHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread ne = new Thread() {
			public void run() {
				throw new RuntimeException("kaala");
			}
		};
		ne.setName("varlam-va");
		ne.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName() + " " + e.getMessage());
			}
		});
		ne.start();
	}

}
