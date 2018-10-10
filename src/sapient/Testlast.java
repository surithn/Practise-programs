package sapient;

import java.io.IOException;

public class Testlast {

	public static void main(String s[]) {
		Testlast t = new Testlast();
		int i = t.check1();
		System.out.println(i);
	}

	int check1() {
		try {
			System.out.println("try");
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch");
			return 2;
		} finally {
			System.exit(0);
			System.out.println("finally");
			return 3;
		}
	}

	int check2() {
		try {
			System.out.println("try ");
			System.exit(0);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch");
			return 2;
		} finally {
			System.out.println("finally");
			return 3;
		}
	}

	int check3() {
		try {
			throw new IOException();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch");
			return 1;
		} finally {
			System.out.println("finally");
			return 2;
		}
	}

	int check() {
		try {
			System.out.println("try");
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch");
			return 2;
		} finally {
			System.out.println("finally");
			return 3;
		}
	}
}
