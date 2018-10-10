/**
 * 
 */
package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * have a map to store single object to prevent n number of creation when req, to reduce memory
 * @author kxhb130
 *
 */
public class FlyWeightExplained {

	private String color;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlyWeightExplained one = new FlyWeightExplained();
		Map<String, FlyWeightExplained> map = new HashMap<>();
		map.put("one", one);
		
		IntStream.range(0, 20).parallel().forEach(action -> {
			System.out.print(map.get("one").color = String.valueOf(action) + " ");
		});
		System.out.println();
		
		IntStream.range(21, 40).parallel().forEach(action -> {
			System.out.print(map.get("one").color = String.valueOf(action) + " ");
		});
		
	}
}
