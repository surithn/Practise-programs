package hello;

/**
 * Source: ASG Tech Find minimum packages to fill luggages.
 * 
 * large package can hold 5 packets
 * small package can hold 1 packet
 * 
 * for given no of packets and large,small count find minimal large and small req
 * for eg, if packets = 16 and large = 2, small = 10 then
 * answer = 8 (2*5 = 10 & 6*1 = 6)
 * 
 * 
 * @author kxhb130
 *
 */
public class FindMinimalPackages {

	public static int minimalcount(int total, int large, int small) {
		int count = 0;
		for (int i=large; i>0; i--) {
			if (total >= 5) {
				total -= 5;
				count++;
			} else {
				break;
			}
		}
		
		if (total > small)
			return -1;
		
		return (count + (total));
	}
	
	public static void main(String[] args) {
		System.out.println(minimalcount(16, 2, 10));
	}

}
