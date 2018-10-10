/**
 * 
 */
package delayQueueRnd;

import java.sql.Timestamp;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author kxhb130
 *
 */
public class DelayObject implements Delayed {

	private String data;
	private long delayInMillis;

	public DelayObject(String data, long delayInMillis) {
		this.data = data;
		this.delayInMillis = System.currentTimeMillis()+delayInMillis;
	}
	
	@Override
	public int compareTo(Delayed o) {
		Long diff = this.delayInMillis - ((DelayObject) o).getDelayInMillis();
		return diff.intValue();
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = this.delayInMillis - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String getData() {
		return data;
	}

	public long getDelayInMillis() {
		return delayInMillis;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "data: "+this.data+" startTime: "+new Timestamp(System.currentTimeMillis()).toString();
	}

}
