package com.dateZoon;

import static org.junit.Assert.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import javax.print.attribute.DateTimeSyntax;

import org.junit.Test;

public class ConverterTest {

	@Test
	public void testConvertLocalDateToCalender() {

		String dateString = "2019-03-15";// local date format
		LocalDate localDate = LocalDate.parse(dateString);
		Calendar calender = Converter.convertLocalDateToCalender(localDate);

		Calendar calender1 = Calendar.getInstance();
		calender1.set(2019, calender.MARCH + 1, 15);

		assertEquals(calender.get(Calendar.YEAR), calender1.get(Calendar.YEAR));
		assertEquals(calender.get(Calendar.MONTH), calender1.get(Calendar.MONTH));
		assertEquals(calender.get(Calendar.DAY_OF_MONTH), calender1.get(Calendar.DAY_OF_MONTH));

	}

	@Test
	public void testConvertCalenderToLocalDate() {

		Calendar calender = Calendar.getInstance();
		calender.set(2019, calender.MARCH, 16);// yr,month,day
		LocalDate localDate = Converter.convertCalenderToLocalDate(calender);

		assertEquals(LocalDate.of(2019, Calendar.MARCH, 16), localDate);

	}

	@Test
	public void testConvertlocalDateToDate() throws ParseException {
		String dateString = "2019-01-15";// local date format
		LocalDate localDate = LocalDate.parse(dateString);

		Date date1 = Converter.convertLocalDateToDate(localDate);

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String dateInString = "15-Jan-2019";

		assertEquals(formatter.parse(dateInString), date1);

	}

	@Test
	public void testConvertDateToLocalDate() throws ParseException {

		String s = "Thu, Jan 25 2019 23:37:50";// date er format
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date2 = formatter.parse(s);
		LocalDate ld = Converter.convertDateToLocalDate(date2);

		String s1 = "2019-01-25";
		LocalDate ld1 = LocalDate.parse(s1);
		assertEquals(ld1, ld);

		System.out.println("expected:" + ld1);
	}

	@Test
	public void testConvertDateToLocalDateTime() throws ParseException {

		String s = "Thu, Jan 25 2019 23:37:50";// date er format
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date2 = formatter.parse(s);
		LocalDateTime localDateTime = Converter.convertDateToLocalDateTime(date2);

		String s1 = "2019-01-25T23:37:50";
		LocalDateTime localDateTime2 = LocalDateTime.parse(s1);

		assertEquals(localDateTime, localDateTime2);

	}

	@Test
	public void testConvertLocalDateTimeToDate() throws ParseException {

		String s = "2019-01-25 23:37:50";// localdatetime er format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(s, formatter);

		Date date = Converter.convertLocalDateTimeToDate(dateTime);

		String str = "Fri Jan 25 23:37:50 BDT 2019";
		SimpleDateFormat formatter1 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date date2 = formatter1.parse(str);

		assertEquals(date2, date);

	}


	@Test
	public void testConvertOffsetDateTimeToCalender() {

		OffsetDateTime dateTime = OffsetDateTime.of(2019, 2, 16, 3, 35, 44, 20, ZoneOffset.of("+02:00"));

		Calendar cal = Converter.convertOffsetDateTimeToCalender(dateTime);

		Calendar calender = Calendar.getInstance();
		calender.set(2019, calender.FEBRUARY + 1, 16);

		assertEquals(calender.get(Calendar.YEAR), cal.get(Calendar.YEAR));
		assertEquals(calender.get(Calendar.MONTH), cal.get(Calendar.MONTH));
		assertEquals(calender.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.DAY_OF_MONTH));

	}

	@Test
	public void testConvertCalenderToOffsetDateTime() {

		Calendar cal = Calendar.getInstance();
		cal.set(2019, cal.MARCH, 16);
		OffsetDateTime offsetDateTime = Converter.convertCalendertoOffsetDateTime(cal);

		OffsetDateTime dateTime = OffsetDateTime.of(2019, 2, 16, 3, 35, 44, 20, ZoneOffset.of("+02:00"));

		assertEquals(dateTime, offsetDateTime);

	}
	
	
	@Test
	public void testConvertDateToOffsetDateTime() throws ParseException {
		
		String s = "Thu, Jan 25 2019 23:37:50";// date er format
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date2 = formatter.parse(s);
		OffsetDateTime offset = Converter.convertDateToOffsetDateTime(date2);
		
		//System.out.println(offset);
		
		OffsetDateTime dateTime = OffsetDateTime.of(2019, 2, 16, 3, 35, 44, 20, ZoneOffset.of("+02:00"));
		
		assertEquals(offset,dateTime);
		
	}

	@Test
	public void testConvertOffsetDateTimeToDate() throws ParseException {
	
		OffsetDateTime off = OffsetDateTime.of(2019, 01, 25, 3, 35, 44, 20, ZoneOffset.of("+02:00"));
		Date date = Converter.convertOffsetDateTimeToDate(off);
		
		
		
		String s = "Fri, Jan 25 2019 07:35:44";// date er format
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date2 = formatter.parse(s);

		assertEquals(date2,date);
	}


}
