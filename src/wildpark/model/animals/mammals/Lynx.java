package wildpark.model.animals.mammals;

import java.time.Duration;
import wildpark.model.Food;
import wildpark.model.Gender;
import wildpark.model.Meat;
import wildpark.model.Movement;
import wildpark.model.WildParkAreaCell;
import wildpark.model.*;
import wildpark.model.animals.Animal;
import wildpark.model.animals.Mammal;
import wildpark.model.animals.DiurnalAnimal;
import wildpark.*;
import java.util.Random;

/**
 * The REAL animal class. This contains implementations of all abstract methods declared in all superclasses.
 * Lynx - ryś.
 */
public class Lynx extends Mammal implements DiurnalAnimal {
	private static final AnimalSpeciesSpecification animalSpeciesSpecification = new LynxSpecification();

	//	Inherited from Meat:
	// public Duration TIME_OF_DEATH = null;

	//	Inherited from Food:
	// public float weight;	// current animal weight
	// private final float CALORIC_EFFICIENCY_PER_KILO = animalSpeciesSpecification.CALORIC_EFFICIENCY_PER_KILO; // określa liczbę kalorii z kilograma danego mięsa 

	public Lynx( AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		super( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}

	public Lynx( WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		this( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}

	public Lynx() {
		this( animalSpeciesSpecification, LynxSpecification.selectRandomCell(), false );
	}


	public CellType[] getAcceptableCellTypes() {
         return LynxSpecification.getAcceptableCellTypes();
    }

	public boolean acceptsCellType( CellType cellType ) {
		return LynxSpecification.acceptsCellType( cellType );
	}

	// public static WildParkAreaCell selectRandomCell() {   
 //        WildParkAreaCell areaCell = null;
 //        LynxSpecification ss = new LynxSpecification();
 //        // Get a random WildParkAreaCell acceptable for the particular species
 //        boolean isAcceptable = false;
 //        do {
 //            areaCell =  WildPark.cellArray[ new Random().nextInt( WildPark.WILD_PARK_AREA_WIDTH ) ][ new Random().nextInt( WildPark.WILD_PARK_AREA_HEIGHT ) ];      
 //            if( ss.acceptsCellType( areaCell.getCellType() ) ) {
 //                isAcceptable = true;
 //            } 
 //            System.out.println( "----------o--------------------------------------------------------------------------\nRandom cell for " + ss.getSPECIES_NAME() + " ----- cellType: " + areaCell.getCellType() + " --- " + isAcceptable );    
 //        } while( !isAcceptable );

 //        return areaCell;
	// }

	@Override
	public String getSPECIES_NAME() {
		return animalSpeciesSpecification.getSPECIES_NAME();
	}


	/**
	 * Try to get food in current WildParkAreaCell
	 * @return      Food object found in the given WildParkAreaCell or null if no Food was found or hunted.
	 */
	public Food getFood() {
		return null;
	}
	


	/**
	 * [eat description]
	 * @param  food [description]
	 * @return      [description]
	 */
	public void eat( Food food ) {

	}



	/**
	 * [move description]
	 * @param  time [description]
	 * @return      Returns the amount of energy required to make the specific move 
	 */
//	public float move( Duration time ) {
//		float energyPercentLoss = getAnimalSpeciesSpecification().getENERGY_LOSS_ON_STANDARD_SPEED_MOVE();
//		useEenergy( energyPercentLoss );	
//		moveInRandomDirection( time, getStandardSpeed() );
//		return energyPercentLoss;
//	}


	public boolean hunt( Animal animal ) {
		return false;
	}

	public int digestMeat( Meat meat )	{ // return energy amount
		return 0;
	}

	public int giveBirth() {	// Returns the number of newborns
		return 0;		
	}

	public Food ssack( Food food ) {
		return null;
	}

	public Food swallow( Food food ) {
		return null;
	}

	public Food chew( Food food ) {
		return null;
	}

	public boolean isDiurnal() {
		return true; //isActiveDuringTheDay;
	}




}