/**
 * 
 */
package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Ryan runs a fruits delivery service. He has tie-ups with multiple
 * resellers/distributors to help them deliver their fruits to their end users.
 * There is a resellers' conference happening in the next week where multiple
 * resellers will organize their own events on a pre-decided day. Each event can
 * vary in time for which it is going on. Ryan sees this as a very good
 * opportunity to add more business to his delivery service. However, the
 * problem is that the event timings can overlap. Due to this Ryan needs to
 * decide how many maximum events he can attend. Each event has a start time and
 * the end time. If the start time of an event is same as the end time of
 * another event then Ryan will not be able to attend both the events (imagine
 * some time taken to commute between the events).
 * 
 * 
 * Input : Locked stub code in the editor reads the following input from stdin
 * and passes event details for each E events as an array argument to the
 * function: The 1st line of input contains an integer E denoting the number
 * events. Next E lines, one for each event contains three spaced integers
 * denoting start time ST and end time ET.
 * 
 * 
 * Output: You need to print an integer X, denoting maximum events Ryan can
 * attend.
 * 
 * 
 * Sample Input: 
 * 3
 * 5 7 
 * 2 4 
 * 5 6 
 * 
 * Sample output: 2
 * 
 * @author kxhb130
 *
 */
public class KickdrumFindEvent {

	static String pre;
	static int maxEvents = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int nos = in.nextInt();
		List<String> list = new ArrayList<>();

		if (nos < 1 || nos > 1000) {
			in.close();
			return;
		}
		System.out.println("enter events");
		IntStream.range(0, nos + 1).forEach(evt -> {
			String str;
			if (in.hasNextLine() && (str = in.nextLine()) != null && !str.isEmpty() && str.split(" ").length == 2
					&& Integer.parseInt(str.split(" ")[0]) >= 0 && Integer.parseInt(str.split(" ")[0]) <= 24
					&& Integer.parseInt(str.split(" ")[1]) >= 0 && Integer.parseInt(str.split(" ")[1]) <= 24)
				list.add(str);
		});

		in.close();
		System.out.println(findMaximumEvents(list));
	}

	private static int findMaximumEvents(List<String> list) {
		list.sort((str1, str2) -> {
			int result = Integer.compare(Integer.parseInt(str1.split(" ")[1]), Integer.parseInt(str2.split(" ")[1]));
			if (result == 0)
				result = Integer.compare(Integer.parseInt(str1.split(" ")[0]), Integer.parseInt(str2.split(" ")[0]));
			return result;
		});
		
		pre = list.get(0);
		for (int i=1; i<list.size(); i++) {
			String temp =  list.get(i);
			if (Integer.parseInt(pre.split(" ")[1]) < Integer.parseInt(temp.split(" ")[0])) {
				pre = temp;
				maxEvents++;
			}
		}
		return maxEvents;
	}

}
