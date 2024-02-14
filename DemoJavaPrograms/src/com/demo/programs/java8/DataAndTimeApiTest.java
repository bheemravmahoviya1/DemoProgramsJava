package com.demo.programs.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DataAndTimeApiTest {
	 public static void main(String[] args) {
		 //dealingWithDates();
		 //dealingWithTime();
		 dealingWithTimeZone();
		 
	 }
	 
	 private static void dealingWithTimeZone() {
		 ZoneId zoneId=ZonedDateTime.now().getZone();  
		 ZoneId cairoTimeZone = ZoneId.of("Africa/Cairo");
		 ZoneId germeyTimeZone = ZoneId.of("Europe/Berlin");
		 ZonedDateTime cairoZonedDateTime = ZonedDateTime.now(cairoTimeZone);
		 System.out.println("current time zone: "+zoneId);
		 System.out.println("cailorZonedDateTime : "+cairoZonedDateTime);
		 System.out.println("germeyTimeZone : "+germeyTimeZone);
		 
		 
	 }
	 
	 
	 private static void dealingWithDates() {
		 printMsg("Today date");
		 LocalDate today = LocalDate.now();
		 LocalDate customDate = LocalDate.of(today.getYear(),today.getMonth(), today.getDayOfMonth());
		 LocalDate customDateFromStr = LocalDate.parse(today.getYear()+"-0"+today.getMonth().getValue()+"-"+today.getDayOfMonth());
	
		 System.out.println("today: "+today);
		 System.out.println("customDate: "+customDate);
		 System.out.println("customDateFromStr: "+customDateFromStr);
		
		 
		 printMsg("Dealing with Past Dates");
		 LocalDate yesterdayDate = LocalDate.now().minusDays(1);
		 LocalDate oneWeekBefore = LocalDate.now().minusWeeks(1);
		 LocalDate oneMonthBefore = LocalDate.now().minusMonths(1);
		 LocalDate oneYearBefore = LocalDate.now().minusYears(1);
		 
		 System.out.println("yesterdayDate: "+yesterdayDate);
		 System.out.println("oneWeekBefore: "+oneWeekBefore);
		 System.out.println("oneMonthBefore: "+oneMonthBefore);
		 System.out.println("oneYearBefore: "+oneYearBefore);
		 
		 printMsg("Dealing with Future Dates");
		 LocalDate tomorrowDate = LocalDate.now().plusDays(1);
		 LocalDate oneWeekAfter = LocalDate.now().plusWeeks(1);
		 LocalDate oneMonthAfter = LocalDate.now().plusMonths(1);
		 LocalDate oneYearAfter = LocalDate.now().plusYears(1);
		 
		 System.out.println("yesterdayDate: "+tomorrowDate);
		 System.out.println("oneWeekBefore: "+oneWeekAfter);
		 System.out.println("oneMonthBefore: "+oneMonthAfter);
		 System.out.println("oneYearBefore: "+oneYearAfter);
	 }
	 
	 private static void dealingWithTime() {
		 printMsg("Dealing with time ");
		 LocalDateTime localDateTime =LocalDateTime.now();
		 LocalTime  localTime=LocalTime.now();
		 System.out.println("localTime: "+localTime);
		 System.out.println("localDateTime: "+localDateTime);
	 }
	 
	
	 
	 
	 private static void printMsg(String msg) {
			System.out.println();
			System.out.println("------------------------- "+msg+" -------------------------");
			System.out.println();
	}
}
