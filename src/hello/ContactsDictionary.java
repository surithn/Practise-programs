/**
 * 
 */
package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kxhb130 Difficulty - Hard
 *
 *         We're going to make our own Contacts application! The application
 *         must perform two types of operations:
 * 
 *         add name, where is a string denoting a contact name. This must store
 *         as a new contact in the application. find partial, where is a string
 *         denoting a partial name to search the application for. It must count
 *         the number of contacts starting with and print the count on a new
 *         line. Given sequential add and find operations, perform each
 *         operation in order.
 */
class Dictionary {
	Map<Character, Dictionary> map = new HashMap<>();
	int size = 0;

	void add(char ch) {
		map.putIfAbsent(ch, new Dictionary());
	}

	Dictionary getNode(char ch) {
		return map.get(ch);
	}
}

public class ContactsDictionary {
	static Dictionary dic = new Dictionary();
	static void add(String contact) {
		Dictionary curr = dic;
		for (char ch: contact.toCharArray()){
			curr.add(ch);	
			curr = curr.getNode(ch);
			curr.size++;
		}
	}
	
	static int searchCount(String contact) {
		Dictionary curr = dic;
		for (char ch: contact.toCharArray()){
			curr = curr.getNode(ch);
			if (curr == null)
				return 0;
		}
		return curr.size;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < Integer.MAX_VALUE; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            
            String contact = opContact[1];
            
            if (op.equalsIgnoreCase("add")) {
                add(contact);
            }
            if (op.equalsIgnoreCase("find")) {
                System.out.println(searchCount(contact));
            }
        }
        scanner.close();
	}

}
