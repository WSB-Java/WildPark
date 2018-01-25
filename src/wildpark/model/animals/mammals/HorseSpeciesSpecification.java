package wildpark.model.animals.mammals;

import java.time.Duration;
import java.util.Random;

import wildpark.WildPark;
import wildpark.model.AnimalSpeciesSpecification;
import wildpark.model.CellType;
import wildpark.model.FoodType;
import wildpark.model.WildParkAreaCell;

public class HorseSpeciesSpecification extends AnimalSpeciesSpecification {

	public static final Object ADULT_WEIGHT = null;
	
	public static final String SPECIES_NAME = "Horse";
	public static final float FOOD_QUANTITY_REQUIRED_PER_HOUR = 9 / 24f;// KG
	public static final int MAX_STARVING_HOURS_BEFORE_DEATH = 14 * 24; // HOURS
	public static final int STANDARD_SPEED = 7; // KMH
	public static final int MAX_SPEED = 60; // KMH
	public static final int MAX_STAMINA = 300; // SECONDS
	public static final int AVERAGE_SCION_COUNT_IN_LITTER = 1; // Offspring
	public static final Duration MAX_AGE = Duration.ofDays(30 * 365); // DAYS
	//public static final int MAX_BREEDING_AGE = MAX_AGE - 5 * 365; // DAYS
	//public static final int MAX_AGE_IN_NEST; // DAYS
	//public static final int MIN_SELF_GOVERNMENT_AGE; // DAYS
	private static final Object HUNGER_ENERGY_PERCENT = null;
	public static final Duration MIN_BREEDING_AGE = Duration.ofDays(5 * 365); // DAYS
	public static final Duration MAX_BREEDING_AGE = Duration.ofDays(25 * 365); // DAYS
	public static final Duration MAX_AGE_IN_NEST = Duration.ofDays(0 * 365); // DAYS
	public static final Duration MIN_SELF_GOVERNMENT_AGE = Duration.ofDays(10 * 30); // DAYS
	public static final int CALORIC_EFFICIENCY_PER_KILO = 1750;
	
	private static final CellType[] acceptableCellTypes = {
		CellType.FOREST,
		CellType.GRASS,	
	};

	public static CellType[] getAcceptableCellTypes() {
		return acceptableCellTypes;
	}
	
	public static boolean acceptsCellType( CellType cellType ) {
		boolean accepts = false;
		for( CellType type : acceptableCellTypes ) {
			System.out.println( "OK - ISBSpecification: "+type );
			if( type == cellType ) {
				accepts = true;
				break;
			}
		}
		return accepts;
	}
	private static final FoodType[] edibleFoodTypes = {
		FoodType.GRASS
	};
		
	public static WildParkAreaCell selectRandomCell() {   // Shouldnt this be in a generation method?
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
	
	public String toString() {
		return String.format( "Species Name: %1$s\r\nAdult Weight: %2$900f kg\r\n...\r\nStandard Speed: %6$30f km/h\r\n", SPECIES_NAME, ADULT_WEIGHT, FOOD_QUANTITY_REQUIRED_PER_HOUR, MAX_STARVING_HOURS_BEFORE_DEATH, HUNGER_ENERGY_PERCENT, STANDARD_SPEED  );
	}
	
	@Override
	public String getSPECIES_NAME() {
		return HorseSpeciesSpecification.SPECIES_NAME;
	}

	@Override
	public float getADULT_WEIGHT() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getNEWBORN_WEIGHT() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFOOD_QUANTITY_REQUIRED_PER_DAY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMAX_STARVING_DAYS_BEFORE_DEATH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHUNGER_ENERGY_PERCENT() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getSTANDARD_SPEED() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMAX_SPEED() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMAX_STAMINA() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAVERAGE_SCION_COUNT_IN_LITTER() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMAX_SCION_COUNT_IN_LITTER() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Duration getMAX_AGE() {
		// TODO Auto-generated method stub
		return MAX_AGE;
	}

	@Override
	public Duration getMIN_BREEDING_AGE() {
		// TODO Auto-generated method stub
		return MIN_BREEDING_AGE;
	}

	@Override
	public Duration getMAX_BREEDING_AGE() {
		// TODO Auto-generated method stub
		return MAX_BREEDING_AGE;
	}

	@Override
	public Duration getMAX_AGE_IN_NEST() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Duration getMIN_SELF_GOVERNMENT_AGE() {
		// TODO Auto-generated method stub
		return MIN_SELF_GOVERNMENT_AGE;
	}

	@Override
	public int getCALORIC_EFFICIENCY_PER_KILO() {
		// TODO Auto-generated method stub
		return CALORIC_EFFICIENCY_PER_KILO;
	}
}
