/**
 * 
 */
package hello;

import java.util.stream.IntStream;

/**
 * Trie derived from word Re'trie'val, is a search data structure - tree like ds
 * 
 * complexities of the search, delete and insert operations were given by O(k)
 * k-search key value
 * 
 * Best used in "Auto complete" functionality
 * 
 * @author kxhb130
 *
 */
public class TrieDSExplained {

	public static TrieNode root;

	public static void insertTrie(String[] words) {
		for (String word : words) {
			TrieNode temp = root;
			for (char ch : word.toCharArray()) {
				if (temp.children[ch - 'a'] == null) {
					temp.children[ch - 'a'] = new TrieNode();
				}
				temp = temp.children[ch - 'a'];
			}
			temp.isEnd = true;
		}
	}

	public static boolean search(String word) {
		TrieNode temp = root;

		for (char ch : word.toCharArray()) {
			if (temp.children[ch - 'a'] == null)
				return false;
			temp = temp.children[ch - 'a'];
		}
		return (temp != null && temp.isEnd);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = { "one", "two", "three", "four", "five", "six" };
		root = new TrieNode();
		insertTrie(words);
		System.out.println(search("two"));
	}

}

class TrieNode {
	public static final int ALPHABET_SIZE = 26;
	public TrieNode[] children;
	public boolean isEnd;

	public TrieNode() {
		isEnd = false;
		children = new TrieNode[ALPHABET_SIZE];
		IntStream.range(0, ALPHABET_SIZE).forEach(i -> children[i] = null);
	}
}
