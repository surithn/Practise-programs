/**
 * 
 */
package sapient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class MultithreadingTest implements Callable<MultithreadingTestModel> {

	private int id;

	/**
	 * @param id
	 */
	public MultithreadingTest(int id) {
		this.id = id;
	}

	@Override
	public MultithreadingTestModel call() throws Exception {
		Thread.sleep(1000 * id);
		return MultithreadingTestDao.getById(id);
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		IntStream.range(1, 10).forEach(action -> {
			try {
				MultithreadingTestDao.save(new MultithreadingTestModel(action, "name-" + action, action));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		System.out.println("Table count -> " + MultithreadingTestDao.getTableSize());
		List<Callable<MultithreadingTestModel>> list = new ArrayList<>();
		IntStream.range(1, 6).forEach(action -> {
			list.add(new MultithreadingTest(action));
		});
		ExecutorService exe = Executors.newFixedThreadPool(6);
		System.out.println("going to invoke all " + Calendar.getInstance().getTime().toString());
		List<Future<MultithreadingTestModel>> result = exe.invokeAll(list);
		result.parallelStream().forEach(action -> {
			try {
				System.out.println(action.get().toString());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});

		exe.shutdown();
		System.out.println("shutdown executed " + Calendar.getInstance().getTime().toString());
	}
}
