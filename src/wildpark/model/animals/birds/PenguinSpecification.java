//package wildpark.animals.birds;
//
//import java.time.Duration;
//
//import wildpark.model.AnimalSpeciesSpecification;
//
//public final class PenguinSpecification extends AnimalSpeciesSpecification {
//	
//    private static final float FOOD_QUANTITY_REQUIRED_PER_HOUR;
//	private static final int MAX_STARVING_HOURS_BEFORE_DEATH = 0;
//	/* Privates */
//    private String SPECIES_NAME;
//	private float ADULT_WEIGHT; // weight in kg 
//	private float NEWBORN_WEIGHT; // in kg
//	private float FOOD_QUANTITY_REQUIRED_PER_DAY; // in kg 
//	private int MAX_STARVING_DAYS_BEFORE_DEATH; 
//	private int HUNGER_ENERGY_PERCENT; // below this value the animal starts seeking food. Above this level the animal is not interested in food. 
//	private float STANDARD_SPEED;	// sprawdzamy jaką odległość zwierzę standardowo pokonuje w ciągu dnia (w czasie godzin aktywności) i na tej podstawie obliczamy stardard w km/h
//	private int MAX_SPEED;	
//	private int MAX_STAMINA; 
//	private int AVERAGE_SCION_COUNT_IN_LITTER; // średnia liczba potomków w miocie
//	private int MAX_SCION_COUNT_IN_LITTER;	// na tej podstawie określimy widełki RANDOMa określającego liczbę potomków w danym miocie
//	private Duration MAX_AGE; 
//	private Duration MIN_BREEDING_AGE; // minimalny wiek rozrodczy
//	private Duration MAX_BREEDING_AGE; // maksymalny wiek rozrodczy
//	private Duration MAX_AGE_IN_NEST; // specifies the number of days/hours after which a young animal leaves the nest 
//	private Duration MIN_SELF_GOVERNMENT_AGE; // minimalny wiek usamodzielnienia się
//	private float CALORIC_EFFICIENCY_PER_KILO;
//
//    /* Constructor */
//    PenguinSpecification(){
//        this.SPECIES_NAME = "Penguin";
//        this.ADULT_WEIGHT = 45f;
//        this.NEWBORN_WEIGHT = 0.09071f;
//        this.FOOD_QUANTITY_REQUIRED_PER_DAY = 2;
//        this.MAX_STARVING_DAYS_BEFORE_DEATH = 4*30;
//        this.HUNGER_ENERGY_PERCENT = 80;
//        this.STANDARD_SPEED = 5;
//        this.MAX_SPEED = 30;
//        this.MAX_STAMINA = 100;
//        this.AVERAGE_SCION_COUNT_IN_LITTER = 1;
//        this.MAX_SCION_COUNT_IN_LITTER = 3;
//        this.MAX_AGE = 40;
//        this.MIN_BREEDING_AGE = Duration.ofDays(365*4);
//        this.MAX_BREEDING_AGE = Duration.ofDays(365*40);
//        this.MAX_AGE_IN_NEST = Duration.ofDays(365);
//        this.MIN_SELF_GOVERNMENT_AGE = Duration.ofDays(30*2);
//        this.CALORIC_EFFICIENCY_PER_KILO = 1300f;
//    }
//
//    /* Publics */
//    public String getSPECIES_NAME() {
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
//    public enum AcceptableCellType {
//        OCEAN, POLAR_AREA
//	}
//
//	public AcceptableCellType[] getAcceptableCellTypes() {
//		return AcceptableCellType.values();
//	}
//
//	public String toString() {
//		return String.format( "Species Name: %1$s\r\nAdult Weight: %2$900f kg\r\n...\r\nStandard Speed: %6$30f km/h\r\n", SPECIES_NAME, ADULT_WEIGHT, FOOD_QUANTITY_REQUIRED_PER_HOUR, MAX_STARVING_HOURS_BEFORE_DEATH, HUNGER_ENERGY_PERCENT, STANDARD_SPEED  );
//	}
//
//	@Override
//	public float getFOOD_QUANTITY_REQUIRED_PER_DAY() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getMAX_STARVING_DAYS_BEFORE_DEATH() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//}