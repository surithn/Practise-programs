/**
 * 
 */
package sapient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kxhb130
 *
 */
public class MultithreadingTestDao {

	private static Map<Integer, MultithreadingTestModel> table = new ConcurrentHashMap<>();

	public static MultithreadingTestModel save(MultithreadingTestModel mt) throws Exception {
		if (!mt.getName().isEmpty()) {
			table.put(mt.getId(), mt);
			return getById(mt.getId());
		}
		throw new Exception("Save not successful");
	}

	public static MultithreadingTestModel getById(int id) {
		return table.get(id);
	}
	
	public static int getTableSize() {
		return table.size();
	}
}
