package hello;

@FunctionalInterface
public interface FunkyInterface {
	void print(String s);
	
	default void log() {
		System.out.println("default log");
	};
	
	static void slog() {
		System.out.println("static log");
	}
}
