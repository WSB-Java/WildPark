package wildpark.util;

/**
 * Object of this class describes a singe state of the animal after each Time Step in Wild Park.
 */
public class YearsDaysHoursDuration {
	private long years;
	private long days;
	private long hours;

	public YearsDaysHoursDuration( long hours ) {
		years = hours / (365*24);
		days = (int) (hours/24) % 365;	
		this.hours = hours % (365*24);
	}

	public long getYears() {
		return years;
	}

	public long getDays() {
		return days;
	}

	public long getHours() {
		return hours;
	}


}