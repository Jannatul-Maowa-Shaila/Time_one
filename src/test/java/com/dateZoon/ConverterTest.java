package com.dateZoon;

import static org.junit.Assert.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.print.attribute.DateTimeSyntax;

import org.junit.Test;

public class ConverterTest {
	
	
	@Test
	public void testConvertLocalDateToCalender() {
		
		String dateString = "2019-01-15";//local date format
		LocalDate localDate = LocalDate.parse(dateString);
		Calendar calender=Converter.convertLocalDateToCalender(localDate);
		
		System.out.println(localDate);
		
		
		
	}

	@Test
	public void testConvertCalenderToLocalDate() {
		
		Calendar calender =Calendar.getInstance();
		calender.set(2019,calender.MARCH, 16);;
		LocalDate localDate=Converter.convertCalenderToLocalDate(calender);
		
		assertEquals(LocalDate.of(2019, Calendar.MARCH, 16), localDate);
		
	}

	@Test
	public  void testConvertlocalDateToDate() throws ParseException {
		String dateString = "2019-01-15";//local date format
		LocalDate localDate = LocalDate.parse(dateString);
		Date date1=Converter.convertLocalDateToDate(localDate);
		

		String s ="Tue Jan 15 00:00:00 BDT 2019";
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		
		assertEquals(formatter.parse(s), date1);
		
		
		
	
		
//		System.out.println("expected:"+date2);
//		System.out.println("Actual:"+date1);
	}

	@Test
	public void testConvertDateToLocalDate() throws ParseException {
		
		
		String s = "Thu, Jan 25 2019 23:37:50";//date er format
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date2 = formatter.parse(s);
		LocalDate ld = Converter.convertDateToLocalDate(date2);
		
		
		
		String s1 = "2019-01-25";
		LocalDate ld1 = LocalDate.parse(s1);
		assertEquals(ld1, ld);
		
//	
//	System.out.println("Actual:"+ld);
//		System.out.println("expected:"+ld1);
	}

	@Test
	public void testConvertDateToLocalDateTime() throws ParseException {

		String s = "Thu, Jan 25 2019 23:37:50";//date er format
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date2 = formatter.parse(s);
		LocalDateTime localDateTime=Converter.convertDateToLocalDateTime(date2);
		
		String s1="2019-01-25T23:37:50";
		LocalDateTime localDateTime2=LocalDateTime.parse(s1);
		
		assertEquals(localDateTime, localDateTime2);
		
		
	    System.out.println("Expected:"+localDateTime2);
		System.out.println("actual:"+localDateTime);
		
		
		
		
	}

	@Test
	public void testConvertLocalDateTimeToDate() throws ParseException {
		
	   String s = "2019-01-25 23:37:50";//localdatetime er format
	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	   LocalDateTime dateTime = LocalDateTime.parse(s, formatter);
	   
	   Date date=Converter.convertLocalDateTimeToDate(dateTime);
	   
	   
	   String str="Fri Jan 25 23:37:50 BDT 2019";
	   SimpleDateFormat formatter1 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
	   Date date2 = formatter1.parse(str);
	   
	   
	   assertEquals(date2, date);
//	   System.out.println(date);
//	   System.out.println("expected:"+date2);
		


	
		
	}

	@Test
	public void testConvertCalenderToLocalDateTime() {
		
		
		
		
		
		
	}

	@Test
	public void testConvertLocalDateTimeToCalender() {
		
	}

}
