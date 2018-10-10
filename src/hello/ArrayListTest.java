package hello;

import java.util.Arrays;

public class ArrayListTest<T> {

	Object[] data;
	int size;
	final int SIZE_FACTOR = 10;

	public ArrayListTest() {
		super();
		data = new Object[SIZE_FACTOR];
		this.size = 0;
	}

	public void add(Object data) throws Exception {
		if (data == null)
			throw new Exception("Null cannot be inserted");

		if (this.size > this.data.length - 1)
			reSizeArray();

		this.data[size] = data;
		size++;
	}

	private void reSizeArray() {
		int len = (this.SIZE_FACTOR / 2) + this.data.length;
		Object[] temp = new Object[len];
		for (int i = 0; i < this.data.length; i++) {
			temp[i] = this.data[i];
		}
		this.data = null;
		this.data = temp;
	}

	public Object get(int index) {
		if (index >= this.size || index < 0)
			return null;
		return this.data[index];
	}

	public void remove(int index) throws Exception {
		if (index >= this.size || index < 0)
			throw new Exception("ArrayIndexOutOfBoundException");

		for (int i = index; i < this.data.length - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.stream(this.data)
				.filter(pre -> pre != null).toArray(Object[]::new));
	}

	public static void main(String[] args) throws Exception {
		ArrayListTest<Integer> arr = new ArrayListTest<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		System.out.println(arr.get(3));
		arr.remove(3);
		System.out.println(arr);
	}

}
