package sapient;

public class ThreadDemo2 extends Thread {
	
	public static void main(String s[]) {
		try {
			ThreadDemo2 A = new ThreadDemo2();
			A.start();
			A.run();
			A.join();
			A.wait();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
//	public void start() {
//		System.out.println("inside stare");
//	}
	public void run() {
		System.out.println("run");
		for(int i=0; i<5; i++){
			System.out.println(i);
		}
	}
}
