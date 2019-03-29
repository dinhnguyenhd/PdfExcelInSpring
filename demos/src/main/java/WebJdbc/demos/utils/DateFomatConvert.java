package WebJdbc.demos.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFomatConvert {
	public static String convertDate(String old) throws ParseException {
		SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = newDateFormat.parse(old);
		newDateFormat.applyPattern("dd-MM-yyyy");
		String myDateString = newDateFormat.format(myDate);
		return myDateString;
	}
	public static void main(String[] args) throws ParseException {
		
		String  out = new DateFomatConvert().convertDate("15-03-2019");
		System.out.println(out);
	}

}
