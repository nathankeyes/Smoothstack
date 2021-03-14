package AssignmentFive;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/14/21
 * @LastEdited  3/14/21
 * @Description Basic Date-Time API stuff with some Q&A as well
 * 
 * 				1. Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
 * 					- LocalDateTime.of(YEAR, Month.MONTH, DAY, TIMEINHOURS, TIMEINMINUTES, TIMEINESECONDS, TIMEINNANOSECONDS)
 * 					- LocalDateTime birthday = LocalDateTime.of(2015, Month.JANUARY, 9, 05, 30, 20, 30);
 * 
 * 				2. Given a random date, how would you find the date of the previous Thursday?
 * 
 * 				3. WHat is the difference between a ZoneId and a ZoneOffset
 * 					- ZoneId is used to specifiy a specific time zone where zoneoffset is an immutable representation of an offset 
 * 					  from a specified time/date 
 * 						- immutable meaning once the object is created, we cannot change its content
 * 
 * 				4. How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant
 * 
 * 				5. Write an example that, for a given year, reports the length of each month within that year
 * 
 * 				6. Write an example that, for a given month of the current year, lists  all of the Mondays in that month
 * 
 * 				7. Write an example that tests whether a given date occurs on Friday the 13th
 * 
 * Referenced:
 * https://www.baeldung.com/java-8-date-time-intro
 */

public class DateTimeAPI {
	public boolean spookyDay(LocalDate spooky) {
		//check if friday, check if day is 13th lol
		DayOfWeek friday = DayOfWeek.valueOf("FRIDAY");
		
		
		if ( (spooky.getDayOfWeek() == friday) && (spooky.getDayOfMonth() == 13) ) {
			System.out.println("It's a spooky day");
			return true;
		}
		else {
			System.out.println("It's safe to go outside");
			return false;
		}
	}
	
	
	public boolean howManyMondays(Month month) {
		// specify the date (year-month-day)
		LocalDate specDate = Year.now().atMonth(month).atDay(1);
		
		// get the first monday of the month
		specDate = specDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		
		// save the first day of the month for iterator
		LocalDate curDay = specDate;
		
		//checks to see if iterator day is before the last day of the month, else iterate a week
		while ( curDay.isBefore(specDate.with(TemporalAdjusters.lastDayOfMonth())) ) {
			System.out.println(curDay);
			curDay = curDay.plusWeeks(1);
		}

		return true;
	}
	
	
	// Documentation for: 
	//		Year:      https://docs.oracle.com/javase/8/docs/api/java/time/Year.html
	// 		YearMonth: https://docs.oracle.com/javase/8/docs/api/java/time/YearMonth.html
	// 		Month:     https://docs.oracle.com/javase/8/docs/api/java/time/Month.html
	public boolean howManyDays(Integer year) {
		
		// iterate through the month constants
		for (Month month : Month.values() ) {
			YearMonth yearMonth = YearMonth.of(year, month);
			System.out.println(month + ": " + yearMonth.lengthOfMonth());
		}
		
		return true;
	}
	
	public boolean timeToInstant() {
		//  of instant needs an instant (gave it the current one) and a zoneId (I don't know ids so i have it my systems default one)
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant( Instant.now(), ZoneId.systemDefault());
		
		//now gets the current ZDT and toInstant converts it into an instant
		Instant in = ZonedDateTime.now().toInstant();
		
		System.out.println("ZDT: " + zonedDateTime);
		System.out.println("Instant: " + in);
		
		return true;
	}
	
	public boolean lastThursday(String randomDate) {
		// both do same thing, just one uses now, other uses specified date
		
		// with() is used with TemporalAdjusters to adjust the date specified
		LocalDate previousThursday = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
		
		LocalDate previousThursday2 = LocalDate.parse(randomDate).with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
		
		
		System.out.println(previousThursday);
		System.out.println(previousThursday2);
		
		return true;
	}
	
	public boolean storeBirthday() {
		LocalDateTime birthday = LocalDateTime.of(2015, Month.JANUARY, 9, 05, 30, 20, 30);
		System.out.println(birthday);
		
		return true;
	}

	public static void main(String[] args) {
		DateTimeAPI obj = new DateTimeAPI();
		
		boolean result;
		Integer year = 2021;
		String randomDate = "2016-06-12";
		String spookyDay = "2021-08-13";
		LocalDate testDate1 = LocalDate.now();
		LocalDate testDate2 = LocalDate.parse(spookyDay);
		
		
		String monthString = "march";
		Month month = Month.valueOf(monthString.toUpperCase());
		

		
		//result = obj.storeBirthday();
		//result = obj.lastThursday(randomDate);
		//result = obj.timeToInstant();
		//result = obj.howManyDays(year);
		//result = obj.howManyMondays(month);
		result = obj.spookyDay(testDate1);
		
		if (result)
			System.out.println("End of Program");
		

	}

}
