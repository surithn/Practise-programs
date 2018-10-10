package hello;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a number, print all possible combinations of strings that can be used
 * to dial the given number in a phone with following specifications.
 * 
 * In the given phone, we can dial, 2 using A or B or C, 3 using D or E or F,
 * ………………. 8 using T or U or V, 9 using W or X or Y or Z, 1 using only 1 0 using
 * 0.
 * 
 * @author kxhb130
 *
 *
 *         For example if 23, is the given phone number, the program should
 *         print AD, AE, AF, BD, BE, BF, CD, CE, CF
 */
public class PrintPossibleCombintions {

	static Map<String, String> map = new HashMap<>();

	public static void buildMap() {
		int start = 64;
		map.put("0", "0");
		map.put("1", "1");
		for (int i = 1; i < 10; i++) {
			String s = String.valueOf((char) (++start));
			s = s + String.valueOf((char) (++start));
			if (start < 90) {
				s = s + String.valueOf((char) (++start));
			}
			map.put(String.valueOf(i + 1), s);
		}
	}

	static void printCombinations(String phone, int i, Map<String, String> map, StringBuilder sb) {
		if (i == phone.length()) {
			System.out.print(sb+" ");
			return;
		}
		
		String num = map.get(String.valueOf(phone.charAt(i)));
		for(int j=0; j<num.length(); j++) {
			sb.append(num.charAt(j));
			printCombinations(phone, i+1, map, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}

	public static void main(String[] args) {
		buildMap();
		printCombinations("23", 0, map, new StringBuilder());
	}

}
