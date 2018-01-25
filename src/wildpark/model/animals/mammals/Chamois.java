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
 * Chamois - kozica górska.
 */
public class Chamois extends Mammal implements DiurnalAnimal {
	private static final AnimalSpeciesSpecification animalSpeciesSpecification = new ChamoisSpecification();

	//	Inherited from Meat:
	// public Duration TIME_OF_DEATH = null;

	//	Inherited from Food:
	// public float weight;	// current animal weight
	// private final float CALORIC_EFFICIENCY_PER_KILO = animalSpeciesSpecification.CALORIC_EFFICIENCY_PER_KILO; // określa liczbę kalorii z kilograma danego mięsa 

	public Chamois( AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		super( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}

	public Chamois( WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		this( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}

	public Chamois() {
		this( animalSpeciesSpecification, ChamoisSpecification.selectRandomCell(), false );
	}


	public CellType[] getAcceptableCellTypes() {
         return ChamoisSpecification.getAcceptableCellTypes();
    }

	public boolean acceptsCellType( CellType cellType ) {
		return ChamoisSpecification.acceptsCellType( cellType );
	}

	// public static WildParkAreaCell selectRandomCell() {   
 //        WildParkAreaCell areaCell = null;
 //        ChamoisSpecification ss = new ChamoisSpecification();
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


	public Food getFood( WildParkAreaCell cell ) {
		return null;
	}

	public Food eat( Food food ) {
		return null;
	}

	/**
	 * [move description]
	 * @param  time [description]
	 * @return      Returns the amount of energy required to make the specific move 
	 */
	public float move( Duration time ) {
		moveInRandomDirection( time, getStandardSpeed() );
		return getAnimalSpeciesSpecification().getENERGY_LOSS_ON_STANDARD_SPEED_MOVE();
	}

	public void proliferate(  ) {
	}

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