package hello;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConvertListToIntTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		// will throw NullPointerException since null.intValue() is null
		try {
			list.stream().mapToInt(Integer::intValue).toArray();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		// handle null values
		int[] i = list.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(i));
		
		System.out.println(list.stream().mapToInt(Integer::intValue).max().getAsInt());
		System.out.println(Arrays.stream(i).max().getAsInt());
	}

}
