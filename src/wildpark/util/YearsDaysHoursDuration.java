package wildpark.util;

import java.time.Duration;

/**
 * Object of this class describes a singe state of the animal after each Time Step in Wild Park.
 */
public class YearsDaysHoursDuration {
	private static long years;
	private static long days;
	private static long hours;

	public YearsDaysHoursDuration( long hours ) {
		countYDH( hours );
	}

	private static void countYDH( long _hours ) {
		years = _hours / (365*24);
		days = (_hours/24) % 365;	
		hours = _hours % 24;		
	}

	public static long getYears() {
		return years;
	}

	public static long getDays() {
		return days;
	}

	public static long getHours() {
		return hours;
	}

	public static String toString( Duration duration ) {
		countYDH( duration.toHours() );
		return String.format( "%3d y %3d d %2d h", years, days, hours );
	}
}