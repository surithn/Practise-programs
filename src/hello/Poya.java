package hello;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiFunction;

public class Poya implements Cloneable{
	public String s2;
	int a;
	int b;
	
	Poya(int q, String r) {
		System.out.println(q + r);
	}
	
	
	@Override
	public Poya clone() throws CloneNotSupportedException {
		System.out.println("am inside clone()");
		return (Poya) super.clone();
	}
	
	public void swap() {
		Stack stack = new Stack();
		stack.push(a);
		
		this.a = this.b;
		this.b = (Integer) stack.pop();
		
	}
	
	public static void main(String[] s) throws CloneNotSupportedException {
		System.out.println(Arrays.toString(s));
		String[] s1 = {"surith"};
		// main(s1);
		
		BiFunction<Integer, String, Poya> po = Poya::new;
		Poya poya = po.apply(1234, "vaya");
		System.out.println(poya.hashCode());
		Poya po2 = (Poya) poya.clone();
		
		
		
			}
}
