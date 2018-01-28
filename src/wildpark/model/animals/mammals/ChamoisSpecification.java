package wildpark.model.animals.mammals;

import java.time.Duration;
import wildpark.model.*;
import wildpark.*;
import java.util.Random;

/**
 * Real class used to set the particular animal specification parameters.
 * Chamois - kozica górska
 */
public final class ChamoisSpecification extends AnimalSpeciesSpecification {
	private static final String SPECIES_NAME = "Chamois";
	private static final float ADULT_WEIGHT = 48.00f;	// (34–62kg) average weight in kg 
	private static final float NEWBORN_WEIGHT = 0.001f; // average in kg
	private static final float FOOD_QUANTITY_REQUIRED_PER_DAY = 0.001f; // in kg
	private static final int MAX_STARVING_DAYS_BEFORE_DEATH = 30;	
	private static final float ENERGY_LOSS_ON_IDLE = (float) 100 / (MAX_STARVING_DAYS_BEFORE_DEATH * 24); // [%] Energy lost by this species even without any move - just because of passing time
	private static final float ENERGY_LOSS_ON_STANDARD_SPEED_MOVE = (float) 100/100; // [%] Energy lost by this species while moving with STANDARD_SPEED for 1 hour (assumption - 100% energy == 24 hrs of moving)	
	private static final int HUNGER_ENERGY_PERCENT = 70; // poniżej tej wartości zwierze poszukuje jedzenia. Powyżej zwierze nie jest zainteresowane jedzeniem 
	private static final float STANDARD_SPEED = (float) 1.5;	// km/h, sprawdzamy jaką odległość zwierzę standardowo pokonuje w ciągu dnia (w czasie godzin aktywności) i na tej podstawie obliczamy stardard w km/h
	private static final int MAX_SPEED = 50;	// km/h
	private static final int MAX_STAMINA = 30; 	// in seconds. The abity to sustain MAX_SPEED for the specified time.
	private static final int AVERAGE_SCION_COUNT_IN_LITTER = 1; // średnia liczba potomków w miocie
	private static final int MAX_SCION_COUNT_IN_LITTER = 2;	// na tej podstawie określimy widełki RANDOMa określającego liczbę potomków w danym miocie
	private static final Duration MAX_AGE = Duration.ofDays(25*365); // 18-25 years
	private static final Duration MIN_BREEDING_AGE = Duration.ofDays(3*365); // minimalny wiek rozrodczy
	private static final Duration MAX_BREEDING_MALE_AGE = Duration.ofDays(23*365); // [days] maksymalny wiek rozrodczy samca
	private static final Duration MAX_BREEDING_FEMALE_AGE = Duration.ofDays(15*365); // [days] maksymalny wiek rozrodczy samicy
	private static final Duration PROLIFERATION_DURATION = Duration.ofDays(175); // 150-200 [days] Duration of pregnancy or bearing and incubating eggs - czas trwania ciąży lub znoszenia i wysiadywania jaj
	private static final Duration MAX_AGE_IN_NEST = Duration.ofDays(3*30); // po ilu dniach opuszcza gniazdo
	private static final Duration MIN_SELF_GOVERNMENT_AGE = Duration.ofDays(3*30); // minimalny wiek usamodzielnienia się
	private static final int CALORIC_EFFICIENCY_PER_KILO = 941; // Cal/kg


	private static final CellType[] acceptableCellTypes = {
		CellType.MOUNTAIN		
	};

	public static CellType[] getAcceptableCellTypes() {
		return acceptableCellTypes;
	}

	public static boolean acceptsCellType( CellType cellType ) {
		boolean accepts = false;
		for( CellType type : acceptableCellTypes ) {
//			System.out.println( "OK - Real Animal Specification: " + type );
			if( type == cellType ) {
				accepts = true;
				break;
			}
		}
		return accepts;
	}



	private static final FoodType[] edibleFoodTypes = {
		FoodType.GRASS,
		FoodType.HERBS,
		FoodType.TREE_LEAVES
	};

	public static FoodType[] getEdibleFoodTypes() {
		return edibleFoodTypes;
	}

	/**
 	 * Determines if this species eats particular type of Food/Meat/Animal/Plant
	 * @param  foodType FoodType object 
	 * @return          boolean - true if this species eats given FoodType
	 */
	public static boolean eatsFoodType( FoodType foodType ) {
		boolean eats = false;
		for( FoodType type : edibleFoodTypes ) {
			if( type == foodType ) {
				eats = true;
				break;
			}
		}
		return eats;
	}



	public static WildParkAreaCell selectRandomCell() {   
        WildParkAreaCell areaCell = null;
        // Get a random WildParkAreaCell acceptable for the particular species
        boolean isAcceptable = false;
        do {
            areaCell =  WildPark.cellArray[ new Random().nextInt( WildPark.WILD_PARK_AREA_WIDTH ) ][ new Random().nextInt( WildPark.WILD_PARK_AREA_HEIGHT ) ];      
            if( acceptsCellType( areaCell.getCellType() ) ) {
                isAcceptable = true;
            } 
            System.out.println( "Random cell for " + SPECIES_NAME + " ----- cellType: " + areaCell.getCellType() + " --- " + isAcceptable );    
        } while( !isAcceptable );

        return areaCell;
	}



	public String getSPECIES_NAME() {
		return SPECIES_NAME;
	}

	public float getADULT_WEIGHT() {
		return ADULT_WEIGHT;
	}
	
	public float getNEWBORN_WEIGHT() {
		return NEWBORN_WEIGHT;
	}
	
	public float getFOOD_QUANTITY_REQUIRED_PER_DAY() {
		return FOOD_QUANTITY_REQUIRED_PER_DAY;
	}
	
	public int getMAX_STARVING_DAYS_BEFORE_DEATH() {
		return MAX_STARVING_DAYS_BEFORE_DEATH;
	}

	public float getENERGY_LOSS_ON_IDLE() {
		return ENERGY_LOSS_ON_IDLE;
	}

	public float getENERGY_LOSS_ON_STANDARD_SPEED_MOVE() {
		return ENERGY_LOSS_ON_STANDARD_SPEED_MOVE;
	}	

	public int getHUNGER_ENERGY_PERCENT() {
		return HUNGER_ENERGY_PERCENT;
	}
	
	public float getSTANDARD_SPEED() {
		return STANDARD_SPEED;
	}
	
	public int getMAX_SPEED() {
		return MAX_SPEED;
	}

	public int getMAX_STAMINA() {
		return MAX_STAMINA;
	}

	public int getAVERAGE_SCION_COUNT_IN_LITTER() {
		return AVERAGE_SCION_COUNT_IN_LITTER;
	}
	
	public int getMAX_SCION_COUNT_IN_LITTER() {
		return MAX_SCION_COUNT_IN_LITTER;
	}
	
	public Duration getMAX_AGE() {
		return MAX_AGE;
	}

	public Duration getMIN_BREEDING_AGE() {
		return MIN_BREEDING_AGE;
	}
	
	public Duration getMAX_BREEDING_MALE_AGE() {
		return MAX_BREEDING_MALE_AGE;
	}
	
	public Duration getMAX_BREEDING_FEMALE_AGE() {
		return MAX_BREEDING_FEMALE_AGE;
	}
	
	public Duration getMAX_AGE_IN_NEST() {
		return MAX_AGE_IN_NEST;
	}
	
	public Duration getMIN_SELF_GOVERNMENT_AGE() {
		return MIN_SELF_GOVERNMENT_AGE;
	}
	
	public int getCALORIC_EFFICIENCY_PER_KILO() {
		return CALORIC_EFFICIENCY_PER_KILO;
	}


}