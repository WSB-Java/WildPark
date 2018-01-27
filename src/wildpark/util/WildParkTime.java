package wildpark.util;

import java.time.Duration;

import wildpark.WildPark;

public class WildParkTime {
    /**
     * Returns the current Wild Park Time counter value. The counter started from Duration.ZERO when 
     * this park was initiated. Everytime the New or Reset options are selected this counter is set 
     * to Duration.ZERO. The WildParkTime starts at the first day of year at midnight. After 24 hours 
     * the first day passes. Etc.
     * @return wildParkTime value - the current time counter of Wild Park
     */
    public static Duration getWildParkTime() {
        //System.out.println("Access to park time: " + wildParkTime.toHours());
        return WildPark.getWildParkTime();
    }
 

    /**
     * Each day starts at midnight.
     * @return Current hour of the day in Wild Park. Together with getDayOfYear() this method can be 
     * used to determine hour of sunrise and sunset at particular season of the year.
     */
	public static long getHourOfDay() {
		return getWildParkTime().toHours() % 24;
	}



	public static long getDayOfYear() {
		return 0; //ToDo
	}



	public static int getSeason() {
		return 0;	//ToDo
	}

}

