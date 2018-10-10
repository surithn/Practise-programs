/**
 * 
 */
package delayQueueRnd;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kxhb130
 *
 */
public class DelayQueueExecutor {

	static final private BlockingQueue<DelayObject> queue = new DelayQueue<>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exe = Executors.newSingleThreadExecutor();
		DelayQueueProducerConsumer one = new DelayQueueProducerConsumer(queue, 20000);
		exe.submit(one);
	}

}
