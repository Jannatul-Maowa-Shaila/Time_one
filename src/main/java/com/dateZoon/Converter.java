package com.dateZoon;

//import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;



import java.util.*;
public class Converter {
	
	
	Date day;
	Month month;
	Year year;
	Timer t;
	
	
	
	
	
	
public Date getDay() {
		return day;
	}


	public void setDay(Date day) {
		this.day = day;
	}


	public Month getMonth() {
		return month;
	}


	public void setMonth(Month month) {
		this.month = month;
	}


	public Year getYear() {
		return year;
	}


	public void setYear(Year year) {
		this.year = year;
	}


	public Timer getT() {
		return t;
	}


	public void setT(Timer t) {
		this.t = t;
	}


public static Calendar convertLocalDateToCalender(LocalDate ld) {
	return null;
	
	
	
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



public static LocalDateTime convertCalenderToLocalDateTime(Calendar calender) {
	return null;
    
	
}


public static Calendar convertLocalDateTimeToCalender(LocalDateTime ldt) {
	return null;
	
	
}








}
