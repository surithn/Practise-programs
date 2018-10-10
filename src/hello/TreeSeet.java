package hello;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class TreeSeet implements Comparable<TreeSeet> {
	
	public int id;
	public String name;
	/**
	 * @param id
	 * @param name
	 */
	public TreeSeet(int id, String name) {
		this.id = id;
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TreeSeet)) {
			return false;
		}
		TreeSeet other = (TreeSeet) obj;
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] s) {
		TreeSeet t1 = new TreeSeet(134, "Surith");
		TreeSeet t2 = new TreeSeet(22, "nivas");
		TreeSeet t3 = new TreeSeet(232, "a");
		TreeSet<TreeSeet> list = new TreeSet<TreeSeet>();
		TreeSet<Integer> listInt = new TreeSet<Integer>();
		list.add(t3);
		list.add(t2);
		list.add(t1);
		list.forEach(System.out::println);
		System.out.println(list.first().toString());
		System.out.println(list.last().toString());
		// IntStream.range(0, 9).forEach(action -> listInt.add(action));
		listInt.add(7);
		listInt.add(3);
		listInt.add(11);
		listInt.add(1);
		System.out.println(listInt.toString());
	}
	@Override
	public int compareTo(TreeSeet o) {
		if(id > o.id)
			return 1;
		else if (id < o.id)
			return -1;
		else 
			return 0;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TreeSeet [id=" + id + ", name=" + name + "]";
	}
	
	
}
