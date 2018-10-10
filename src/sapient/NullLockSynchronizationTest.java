/**
 * 
 */
package sapient;

/**
 * @author kxhb130 Is it possible to take a lock on null reference? What is the
 *         output of the Program? When we cannot take a lock on null reference,
 *         what will happen if we make a reference null after acquiring a lock
 *         on object it is referring to?
 * 
 */
public class NullLockSynchronizationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NullLockSynchronizationTest te = new NullLockSynchronizationTest();
		synchronized (te) {
			te = null;
			// System.out.println("still lock exists" + te.toString());
		}
		synchronized (te) {	// <- should throw err here
			System.out.println("still obj exists");
		}
	}

}
