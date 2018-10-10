/**
 * 
 */
package sapient;

/**
 * @author kxhb130
 *
 */
public class MultithreadingTestModel {

	private int id;
	private String name;
	private int age;
	
	/**
	 * @param id
	 * @param name
	 * @param age
	 */
	public MultithreadingTestModel(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MultithreadingTestModel [id=" + id + ", " + (name != null ? "name=" + name + ", " : "") + "age=" + age
				+ "]";
	}
}
