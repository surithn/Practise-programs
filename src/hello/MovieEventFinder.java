/**
 * 
 */
package hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Source: ASG Tech Find if Tom can watch all movies
 * 
 * 
 * @author kxhb130
 *
 */
public class MovieEventFinder {
	static boolean result = true;
	public static boolean canWatchAll(List<Movie> movies) {
		movies.sort((m1, m2) -> {
			int r = m1.getEndDate().compareTo(m2.getEndDate());
			if (r==0)
				return m1.getStartDate().compareTo(m2.getStartDate());
			return r;
		});
		for(int i=0; i<(movies.size()-1); i++) {
			if (movies.get(i).getEndDate().compareTo(movies.get(i+1).getStartDate()) > 0 )
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yy h:mm:ss");
		List<Movie> list = new ArrayList<>();
		list.add(new Movie(sd.parse("25/08/2018 9:30:00"), sd.parse("25/08/2018 13:00:00")));
		list.add(new Movie(sd.parse("25/08/2018 13:30:00"), sd.parse("25/08/2018 15:00:00")));
		list.add(new Movie(sd.parse("25/08/2018 6:30:00"), sd.parse("25/08/2018 9:00:00")));
		System.out.println(canWatchAll(list));
	}

}

class Movie {
	private Date startDate;
	private Date endDate;

	/**
	 * @param startDate
	 * @param endDate
	 */
	public Movie(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	public String toString() {
		return this.startDate + " -> " + this.endDate;
	}
}
