/**
 * 
 */
package delayQueueRnd;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class DelayQueueProducerConsumer implements Runnable {

	BlockingQueue<DelayObject> poda;
	long delayInMillis;
	
	/**
	 * @param poda
	 * @param delayInMillis
	 */
	public DelayQueueProducerConsumer(BlockingQueue<DelayObject> poda, long delayInMillis) {
		this.poda = poda;
		this.delayInMillis = delayInMillis;
	}

	@Override
	public void run() {
		IntStream.range(0, 3).forEach(action -> {
			DelayObject obj1 = new DelayObject(UUID.randomUUID().toString()
					, this.delayInMillis);
			try {
				System.out.println("produced at => "+obj1.toString());
				this.poda.put(obj1);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		});
		
		try {
			DelayObject imm = new DelayObject("am immidieatly consumed"
					, 0);
			System.out.println("produced at => "+imm.toString());
			this.poda.put(imm);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		IntStream.range(0, 4).forEach(action -> {
			try {
				DelayObject obj = this.poda.take();
				System.out.println("consumed at => "+obj.toString()+"  time"+new Timestamp(System.currentTimeMillis()).toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	
}
