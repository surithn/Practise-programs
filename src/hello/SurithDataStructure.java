package hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author kxhb130 Design a data structure that supports insert, delete, search
 *         and getRandom in constant Θ(1) time
 * 
 *         insert(x): Inserts an item x to the data structure if not already
 *         present.
 * 
 *         remove(x): Removes an item x from the data structure if present.
 *         
 *         search(x): Searches an item x in the data structure.
 * 
 *         getRandom(): Returns a random element from current set of elements
 *
 */
public class SurithDataStructure<T> {

	List<T> arr;
	Map<T, Integer> hash;
	
	SurithDataStructure() {
		arr = new ArrayList<>();
		hash = new HashMap<>(); 
	}
	
	// add / insert
	public void add(T data) {
		if (hash.get(data) != null) 
			return;
		arr.add(data);
		hash.put(data, arr.size()-1);
	}
	
	// remove - insertion order will be lost but time maintained
	public void remove(T data) {
		Integer index = hash.get(data);
		if (index == null) 
			return;
		hash.remove(data);
		Collections.swap(arr, index, arr.size()-1);
		arr.remove(arr.size()-1);
	}
	
	// search
	public boolean search(T data) {
		return hash.containsKey(data);
	}
	
	// getRandom data
	public T getRandom() {
		Random ran = new Random();
		return arr.get(ran.nextInt(arr.size()));
	}
	
	public static void main(String[] args) {
		SurithDataStructure<Integer> ds = new SurithDataStructure<>();
		ds.add(32);
		ds.add(22);
		ds.add(12);
		ds.add(42);
		ds.add(52);
		ds.add(72);
		System.out.println(ds.search(12));
		System.out.println(ds.toString());
		ds.remove(22);
		System.out.println(ds.toString());
		System.out.println(ds.getRandom());
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SurithDataStructure [" + (arr != null ? "arr=" + arr : "") + "]";
	}

}
