/**
 * 
 */
package hello;

import java.util.HashMap;
import java.util.Map;

/**
 * Find frequency of each word in a string
 * 
 * @author kxhb130
 *
 */
public class FreqOfEachWordTest {

	static int findFreq(String str, String word) {
		Map<String, Integer> map = new HashMap<>();
		String[] strs = str.split(" ");
		for (String s : strs) {
			if (map.containsKey(s))
				map.put(s, map.get(s) + 1);
			else
				map.put(s, 1);
		}
		return map.get(word);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findFreq("Apple Mango Orange Mango Guava Guava Mango", "Mango"));
	}

}
