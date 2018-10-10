package sapient;

import java.util.TreeSet;

public class TreeSeeeet {

	public static void main(String[] args) {
		TreeSet<Integer> s1 = new TreeSet<Integer>();
		TreeSet<Integer> subset1 = new TreeSet<Integer>();
		for(int i = 604; i<617;i++) {
			if(i%2==0)	s1.add(i);
			System.out.println(s1.toString());
			System.out.println(subset1.toString());
			subset1 = (TreeSet<Integer>)s1.subSet(604, 613);
			System.out.println(s1.toString());
			System.out.println(subset1.toString());
			s1.add(629);
			System.out.println(s1.toString());
			System.out.println(subset1.toString());
			subset1.add(629);
			System.out.println(s1.toString());
			System.out.println(s1+"  "+subset1);
		}
		
	}

}
