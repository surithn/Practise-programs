/**
 * 
 */
package hello;

/**
 * Count ways to reach the nth stair using step 1, 2 or 3
 * 
 * A child is running up a staircase with n steps and can hop either 1 step, 2
 * steps, or 3 steps at a time. Implement a method to count how many possible
 * ways the child can run up the stairs.
 * 
 * @author kxhb130
 *
 */
public class ProbabilityFindSteps {

	static int findWays(int n) {
		if (n==0 || n==1)
			return 1;
		if (n==2)
			return 2;
		
		return findWays(n-1)+findWays(n-2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findWays(3));
	}

}
