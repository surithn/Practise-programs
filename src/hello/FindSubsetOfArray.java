/**
 * 
 */
package hello;

import java.util.TreeSet;

/**
 * @author kxhb130
 *
 */
public class FindSubsetOfArray {
	static TreeSet<String> set = new TreeSet<>();
    static void subset(char[] arr) {
    		int n = arr.length;
    		
    		for (int i=0; i< (1<<n); i++) {
    			String str = "";
    			for (int j=0; j<n; j++) {
    				if ((i & (1<<j)) > 0)
    					str += arr[j];
    			}
    			str.trim();
    			if (str.length() >=1 && str != "")
    				set.add(str);
    		}
    }
    
    
    static void subsetsss(String string) {
    		int len = string.length();
    		for (int i=0; i<len; i++) {
    			for (int j=1; j<=len-i; j++) {
    				System.out.print(string.substring(i, i+j));
    			}
    			System.out.println();
    		}
    }
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		String x = "acb";
		 subset(x.toCharArray());
		 System.out.println(set);
		// subsetsss(x);
		// System.out.println(set);
	}

}
