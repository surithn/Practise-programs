package sapient;

interface Default1 {
	void print();
	default void newAdded() {
		System.out.println("Default1 -> newAdded");
	}
}

interface Default2 {
	void print();
	default void newAdded() {
		System.out.println("Default2 -> newAdded");
	}
	
}

public class DefaultMethodMulInheritence implements Default1, Default2 {

	public static void main(String[] args) {
		DefaultMethodMulInheritence df = new DefaultMethodMulInheritence();
		df.print();
		df.newAdded();
	}

	@Override
	public void print() {
		System.out.println("Print");
	}

	@Override
	public void newAdded() {
		Default1.super.newAdded();
		Default2.super.newAdded();
	}

}
