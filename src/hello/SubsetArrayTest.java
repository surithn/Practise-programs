package hello;

public class SubsetArrayTest {

	static boolean res = true;

	static void subset(String a) {
		for (int i=0; i<a.length(); i++) {
			for (int j=1; j<=a.length()-i; j++) {
				System.out.print(a.substring(i, i+j) + " ");
			}
		}
	}

	public static void main(String[] args) {
		String a = "acb";
		subset(a);
	}

}
