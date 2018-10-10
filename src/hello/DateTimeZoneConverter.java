/**
 * 
 */
package hello;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author kxhb130
 *
 */
public class DateTimeZoneConverter {
	private static final String DATE_FORMAT = "dd-M-yyyy HH:mm z";

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		ZonedDateTime zdt = ZonedDateTime.ofInstant(ZonedDateTime.now().toInstant(), ZoneId.of("UTC"));
		System.out.println(zdt.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
		ZonedDateTime london = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("Europe/London"));
		System.out.println(london.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
		System.out.println(Timestamp.valueOf(zdt.toLocalDateTime()).getNanos());
		System.out.println(ZonedDateTime.now(ZoneId.of("UTC")).toInstant().toEpochMilli());
		final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String str = zdt.format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss"));
		System.out.println(dateFormat.parse(str));
		System.out.println(str);
		
		
		ZonedDateTime zdt1 = ZonedDateTime.now(ZoneOffset.UTC);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

		DateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

		String dateStr = zdt1.format(formatter);

		Date utcDate = null;

		utcDate = format.parse(dateStr);
		System.out.println(utcDate.getTime());
		
		Date retur = new Date(1525407858000l);
		System.out.println(format.format(retur)+ "UTC");
	}

}
