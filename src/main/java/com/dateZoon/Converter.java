package com.dateZoon;

//import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;
public class Converter {
	
	
	

public static Calendar convertLocalDateToCalender(LocalDate ld) {
	
	Calendar calendar=Calendar.getInstance();
	LocalDate localDate=ld;
	
    calendar.set(ld.getYear(),ld.getMonthValue(),ld.getDayOfMonth());
    
    return calendar;
	
	
}


public static LocalDate convertCalenderToLocalDate(Calendar ca) {
	
	LocalDate localDate=LocalDate.of(ca.get(Calendar.YEAR),ca.get(Calendar.MONTH),ca.get(Calendar.DAY_OF_MONTH));
	
	return localDate;
	
}



public static Date convertLocalDateToDate(LocalDate ld) {
	
	return java.util.Date.from(ld.atStartOfDay()
		      .atZone(ZoneId.systemDefault())
		      .toInstant());
	
}



public static LocalDate convertDateToLocalDate(Date dt) {
	
	return dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}


public static LocalDateTime convertDateToLocalDateTime(Date dt) {

	return dt.toInstant()
	    .atZone(ZoneId.systemDefault())
	    .toLocalDateTime();
}



public static Date convertLocalDateTimeToDate(LocalDateTime ldt) {

	return java.util.Date
		      .from(ldt.atZone(ZoneId.systemDefault())
		      .toInstant());
}




public static Calendar convertOffsetDateTimeToCalender( OffsetDateTime o) {
	
	Calendar cal=Calendar.getInstance();
	cal.set(o.getYear(),o.getMonth().getValue(),o.getDayOfMonth());
	
	return cal;
	
}



public static OffsetDateTime convertCalendertoOffsetDateTime(Calendar cal) {
	
	cal.get(Calendar.YEAR);
	cal.get(Calendar.MONTH);
	cal.get(Calendar.DAY_OF_MONTH);
	cal.get(Calendar.ZONE_OFFSET);

	 OffsetDateTime dateTime = OffsetDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 3, 35, 44, 20, ZoneOffset.of("+02:00"));
	
	
	return dateTime;
}



public static OffsetDateTime convertDateToOffsetDateTime(Date date) {
	
	
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
	
			OffsetDateTime dateTime = OffsetDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH), 3, 35, 44, 20, ZoneOffset.of("+02:00"));
			
	return dateTime;
	
	
	
}


public static Date convertOffsetDateTimeToDate(OffsetDateTime off) {
	
	
	return Date.from(off.toInstant());
	
	
}




}
