/**
 * 
 */
package sapient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author kxhb130
 *
 */
public class SerializeTest implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final SerializeTest ser = new SerializeTest("surith", "nivas", "Mohandoss");
	public String first;
	public String middle;
	public transient String last;

	/**
	 * @param first
	 * @param middle
	 */
	private SerializeTest(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("/Users/kxhb130/SerializeTest.ser");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(ser);
		os.close();
		System.out.println("written -> " + ser.hashCode());
		deserializer();
	}

	static void deserializer() throws ClassNotFoundException, IOException {
		FileInputStream fos = new FileInputStream("/Users/kxhb130/SerializeTest.ser");
		ObjectInputStream os = new ObjectInputStream(fos);
		SerializeTest ser1 = (SerializeTest) os.readObject();
		os.close();
		System.out.println(ser1.toString());
		System.out.println("read -> " + ser1.hashCode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SerializeTest [" + (first != null ? "first=" + first + ", " : "")
				+ (middle != null ? "middle=" + middle + ", " : "") + (last != null ? "last=" + last : "") + "]";
	}
	
	public Object readResolve() {
		System.out.println("insider -> " + last);
		return ser;
	}

}
