package sapient;

public class Test18 {
public static void main(String s[]){
	int x=2;
	final long j=2;
	switch(x) {
	case 1:
		System.out.println("1");
		break;
	case 10:
		System.out.println("10");
		break;
	case (int) j:
		System.out.println("2");
		break;
	case 5:
		System.out.println("5");
		break;	
	}
}
}
