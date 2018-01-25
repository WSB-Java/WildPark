package wildpark.model;

import java.time.Duration;
import wildpark.model.*;

/**
 * Particular animal instance specification. In contrast to SpeciesSpecification which is the specification of every animal of particular species.
 */
public abstract class AnimalSpeciesSpecification {
	private String SPECIES_NAME;
	private float ADULT_WEIGHT; // average adult weight in kg 
	private float NEWBORN_WEIGHT; // average newborn in kg
	private float FOOD_QUANTITY_REQUIRED_PER_DAY; // in kg 
	private int MAX_STARVING_DAYS_BEFORE_DEATH; 
	private float ENERGY_LOSS_ON_IDLE; //= (float) 100 / (MAX_STARVING_DAYS_BEFORE_DEATH * 24); // [%] Energy lost by this species even without any move - just because of passing time
	private float ENERGY_LOSS_ON_STANDARD_SPEED_MOVE; //= (float) 100/24; // [%] Energy lost by this species while moving with STANDARD_SPEED for 1 hour (assumption - 100% energy == 24 hrs of moving)	
	private float STANDARD_SPEED;	// [km/h] sprawdzamy jaką odległość zwierzę standardowo pokonuje w ciągu dnia (w czasie godzin aktywności) i na tej podstawie obliczamy stardard w km/h
	private int MAX_SPEED;	// [km/h]
	private int MAX_STAMINA; // [sec] The abity to sustain MAX_SPEED for the specified time.
	private int HUNGER_ENERGY_PERCENT; // [%] below this value the animal starts seeking food. Above this level the animal is not interested in food. 
	private int AVERAGE_SCION_COUNT_IN_LITTER; // średnia liczba potomków w miocie
	private int MAX_SCION_COUNT_IN_LITTER;	// na tej podstawie określimy widełki RANDOMa określającego liczbę potomków w danym miocie
	private Duration MAX_AGE; //[days]
	private Duration MIN_BREEDING_AGE; // [days] minimalny wiek rozrodczy
	private Duration MAX_BREEDING_AGE; // [days] maksymalny wiek rozrodczy
	private Duration PROLIFERATION_DURATION; // [days] Duration of pregnancy or bearing and incubating eggs - czas trwania ciąży lub znoszenia i wysiadywania jaj
	//
	private Duration MAX_AGE_IN_NEST; // [days] specifies the number of days/hours after which a young animal leaves the nest 
	private Duration MIN_SELF_GOVERNMENT_AGE; // [days] minimalny wiek usamodzielnienia się
	private float CALORIC_EFFICIENCY_PER_KILO;


	/**
	 * The following array MUST be overriden in the real animal species specification class inherited fromm this 
	 * AnimalSpeciesSpecification class but with only Cell Types acceptable by particular species.
	 */	 
	private static CellType[] acceptableCellTypes = {
		CellType.OCEAN,
		CellType.LAKE,
		CellType.RIVER,
		CellType.FOREST,
		CellType.GRASS,
		CellType.DESERT,
		CellType.MOUNTAIN,
		CellType.POLAR_AREA,
		CellType.PARK_EDGE
	};

	public static CellType[] getAcceptableCellTypes() {
		return null;
	}

	/**
	 * This method MUST be overriden/implemented in the subclass representing the real
	 * animal species specification.  
	 * @param  cellType [description]
	 * @return          true if this species accepts the specified cellType (environment)
	 */
	public static boolean acceptsCellType( CellType cellType ) {
		return false;
	}

	/**
	 * The following array MUST be overriden in the real animal species specification class inherited fromm this 
	 * AnimalSpeciesSpecification class - but only with Food Types edible (jadalne) for particular species.
	 */	 
	private static FoodType[] edibleFoodTypes = {
		FoodType.SEAL,
		FoodType.RABBIT,
		FoodType.FLY
	};

	public static FoodType[] getEdibleFoodTypes() {
		return null;
	}

	/**
	 * This method MUST be overriden/implemented in the subclass representing the real
	 * animal species specification.  
 	 * Determines if this species eats particular type of Food/Meat/Animal/Plant
	 * @param  foodType FoodType object 
	 * @return          boolean - true if this species eats given FoodType.
	 */
	public static boolean eatsFoodType( FoodType foodType ) {
		return false;
	}





	public String toString() {
		return String.format( "Species Name: %1$s\r\nAdult Weight: %2$8.3f kg\r\n...\r\nStandard Speed: %6$5.1f km/h\r\n", SPECIES_NAME, ADULT_WEIGHT, FOOD_QUANTITY_REQUIRED_PER_DAY, MAX_STARVING_DAYS_BEFORE_DEATH, HUNGER_ENERGY_PERCENT, STANDARD_SPEED  );
	}

	public abstract String getSPECIES_NAME();
	public abstract float getADULT_WEIGHT(); // weight in kg 
	public abstract float getNEWBORN_WEIGHT(); // in kg
	public abstract float getFOOD_QUANTITY_REQUIRED_PER_DAY(); // in kg 
	public abstract int getMAX_STARVING_DAYS_BEFORE_DEATH(); 
	public abstract float getENERGY_LOSS_ON_IDLE();
	public abstract float getENERGY_LOSS_ON_STANDARD_SPEED_MOVE();
	public abstract int getHUNGER_ENERGY_PERCENT(); // below this value the animal starts seeking food. Above this level the animal is not interested in food. 
	public abstract float getSTANDARD_SPEED();	// sprawdzamy jaką odległość zwierzę standardowo pokonuje w ciągu dnia (w czasie godzin aktywności) i na tej podstawie obliczamy stardard w km/h
	public abstract int getMAX_SPEED();	
	public abstract int getMAX_STAMINA(); 
	public abstract int getAVERAGE_SCION_COUNT_IN_LITTER(); // średnia liczba potomków w miocie
	public abstract int getMAX_SCION_COUNT_IN_LITTER();	// na tej podstawie określimy widełki RANDOMa określającego liczbę potomków w danym miocie
	public abstract Duration getMAX_AGE(); 
	public abstract Duration getMIN_BREEDING_AGE(); // minimalny wiek rozrodczy
	public abstract Duration getMAX_BREEDING_AGE(); // maksymalny wiek rozrodczy
	public abstract Duration getMAX_AGE_IN_NEST(); // specifies the number of days/hours after which a young animal leaves the nest 
	public abstract Duration getMIN_SELF_GOVERNMENT_AGE(); // minimalny wiek usamodzielnienia się
	public abstract int getCALORIC_EFFICIENCY_PER_KILO();

}