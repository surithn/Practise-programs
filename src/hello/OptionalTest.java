package hello;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		Optional<String> str = Optional.of("surith");
		Optional<String> str1 = Optional.of("surith");
		System.out.println(str.equals(str1));
		System.out.println(str.isPresent());
		str.ifPresent(cons -> print(cons));
	}

	private static void print(String str) {
		System.out.println(str);
	}
}
