package hello;

import java.util.ArrayList;
import java.util.List;

public class HashMapTest<K,V> {
	
	private List<Entry<K,V>> array;
	
	protected class Entry<K,V> {
		
		public Entry(K key2, V value2) {
			this.key = key2;
			this.value = value2;
		}
		
		private Entry<K,V> next;
		private K key;
		private V value;
		
		public V getValue() { return value; };
		public K getKey() { return key; };
		
	}
	
	HashMapTest() {
		array = new ArrayList<>();
	}
	
	public void put(K key, V value) {
		Entry<K,V> entry = new Entry(key, value);
		array.add(entry);
	}
	
	public void put(K key, V value, int index) {
		Entry<K,V> entry = new Entry(key, value);
		if (array.get(index) != null) {
			array.get(index).next = entry;
		}
	}
	
	public boolean isExists(K key) {
		return array.stream().anyMatch(pre -> {
			boolean top = (pre.key == key);
			if (pre.next != null && !top) {
				top = isNodeExists(pre, key);
			}
			return top;
		});
	}
	
	private boolean isNodeExists(HashMapTest<K, V>.Entry<K, V> data, K key) {
		if (data.key == key)
			return true;
		if (data.next != null)
			return isNodeExists(data.next, key);
		else
			return false;
	}
	
	public Entry<K,V> getIndex(int i) {
		return array.get(i);
	}

	public static void main(String str[]) {
		HashMapTest<Integer, String> map = new HashMapTest<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		System.out.println(map.getIndex(2).getValue());
		System.out.println(map.isExists(1));
		map.put(4, "four", 2);
		System.out.println(map.getIndex(2).next.getValue());
	}
}
