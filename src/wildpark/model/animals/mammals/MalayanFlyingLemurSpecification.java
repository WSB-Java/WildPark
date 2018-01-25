//package wildpark.model.animals.mammals;
//
//import java.time.Duration;
//import wildpark.model.*;
//
///**
// * Absract class used to set the particular animal specification parameters.
// */
//public final class MalayanFlyingLemurSpecification extends AnimalSpeciesSpecification {
//	private static final float FOOD_QUANTITY_REQUIRED_PER_HOUR = 0;
//	private final String NAME = "MalayanFlyingLemur";
//	private final float ADULT_WEIGHT = 2;	// weight in kg 
//	private final float NEWBORN_WEIGHT = 0.035f; // in kg
//	private final float FOOD_QUANTITY_REQUIRED_PER_DAY = 0.050f; // in kg
//	private final int MAX_STARVING_HOURS_BEFORE_DEATH = 50;
//	private final int HUNGER_ENERGY_PERCENT = 70; // poniżej tej wartości zwierze poszukuje jedzenia. Powyżej zwierze nie jest zainteresowane jedzeniem 
//	private final float STANDARD_SPEED = 1;	// km/h, sprawdzamy jaką odległość zwierzę standardowo pokonuje w ciągu dnia (w czasie godzin aktywności) i na tej podstawie obliczamy stardard w km/h
//	private final int MAX_SPEED = 5;	// km/h
//	private final int MAX_STAMINA = 100; 	//
//	private final int AVERAGE_SCION_COUNT_IN_LITTER = 1; // średnia liczba potomków w miocie
//	private final int MAX_SCION_COUNT_IN_LITTER = 2;	// na tej podstawie określimy widełki RANDOMa określającego liczbę potomków w danym miocie
//	private final Duration MAX_AGE = Duration.ofDays(18*365); // 20 years
//	private final Duration MIN_BREEDING_AGE = Duration.ofDays(3*30); // minimalny wiek rozrodczy
//	private final Duration MAX_BREEDING_AGE = Duration.ofDays(13*365); // maksymalny wiek rozrodczy
//	private final Duration MAX_AGE_IN_NEST = Duration.ofDays(3*30); // po ilu 
//	private final Duration MIN_SELF_GOVERNMENT_AGE = Duration.ofDays(2*30); // minimalny wiek usamodzielnienia się
//	private int CALORIC_EFFICIENCY_PER_KILO = 700; // Cal/kg
//
//
//
//	public enum AcceptableCellType {
//		FOREST	
//				
//	}
//
//	// public AcceptableCellType[] getAcceptableCellTypes() {
//	// 	return AcceptableCellType.values();
//	// }
//
//
//	public String getSPECIES_NAME() {
//		return NAME;
//	}
//
//	public float getADULT_WEIGHT() {
//		return ADULT_WEIGHT;
//	}
//	
//	public float getNEWBORN_WEIGHT() {
//		return NEWBORN_WEIGHT;
//	}
//	
//	public float getFOOD_QUANTITY_REQUIRED_PER_HOUR() {
//		return FOOD_QUANTITY_REQUIRED_PER_HOUR;
//	}
//	
//	public int getMAX_STARVING_HOURS_BEFORE_DEATH() {
//		return MAX_STARVING_HOURS_BEFORE_DEATH;
//	}
//
//	public int getHUNGER_ENERGY_PERCENT() {
//		return HUNGER_ENERGY_PERCENT;
//	}
//	
//	public float getSTANDARD_SPEED() {
//		return STANDARD_SPEED;
//	}
//	
//	public int getMAX_SPEED() {
//		return MAX_SPEED;
//	}
//
//	public int getMAX_STAMINA() {
//		return MAX_STAMINA;
//	}
//
//	public int getAVERAGE_SCION_COUNT_IN_LITTER() {
//		return AVERAGE_SCION_COUNT_IN_LITTER;
//	}
//	
//	public int getMAX_SCION_COUNT_IN_LITTER() {
//		return MAX_SCION_COUNT_IN_LITTER;
//	}
//	
//	public Duration getMAX_AGE() {
//		return MAX_AGE;
//	}
//
//	public Duration getMIN_BREEDING_AGE() {
//		return MIN_BREEDING_AGE;
//	}
//	
//	public Duration getMAX_BREEDING_AGE() {
//		return MAX_BREEDING_AGE;
//	}
//	
//	public Duration getMAX_AGE_IN_NEST() {
//		return MAX_AGE_IN_NEST;
//	}
//	
//	public Duration getMIN_SELF_GOVERNMENT_AGE() {
//		return MIN_SELF_GOVERNMENT_AGE;
//	}
//	
//	public int getCALORIC_EFFICIENCY_PER_KILO() {
//		return CALORIC_EFFICIENCY_PER_KILO;
//	}
//
//
//}