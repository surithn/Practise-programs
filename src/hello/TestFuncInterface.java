/**
 * 
 */
package hello;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kxhb130
 *
 */
public class TestFuncInterface implements FunkyInterface {

	@Override
	public void print(String s) {
		System.out.println(TestFuncInterface.class.getName()+ " print overriden");
	}

	public static void main(String[] s) {
		TestFuncInterface td = new TestFuncInterface();
		td.print("");
		td.log();
		FunkyInterface funcky = (s1) -> System.out.println(s1);
		funcky.print("poda panni");
		funcky.log();
		FunkyInterface.slog();
		Runnable r = () -> {
			System.out.println("am from run method");
		};
		ExecutorService e = Executors.newSingleThreadExecutor();
		e.submit(r);
		e.shutdown();
		r.run();
	}
}
