package wildpark.model.animals.mammals;

import java.time.Duration;

import wildpark.model.*;
import wildpark.model.animals.Animal;
import wildpark.model.animals.NocturnalAnimal;
import wildpark.model.animals.Predator;
import wildpark.model.animals.mammals.*;
import wildpark.model.animals.*;
/**
 * The REAL animal class. This contains implementations of all abstract methods declared in all superclasses.
 */
public class PolarBear extends Mammal implements MetaturnalAnimal, Predator {
	private final AnimalSpeciesSpecification animalSpeciesSpecification = new InsectEatingBatSpecification();

	//	Inherited from Meat:
	// public Duration TIME_OF_DEATH = null;

	//	Inherited from Food:
	// public float weight;	// current animal weight
	// private final float CALORIC_EFFICIENCY_PER_KILO = animalSpeciesSpecification.CALORIC_EFFICIENCY_PER_KILO; // określa liczbę kalorii z kilograma danego mięsa 

	public PolarBear( AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		super( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}





	public CellType[] getAcceptableCellTypes() {
        return LionSpecification.getAcceptableCellTypes();
   }

	public Food getFood( WildParkAreaCell cell ) {
		return null;
	}

	public Food eat( Food food ) {
		return null;
	}

	public void move( Duration time ) {
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

	public boolean isMetaturnal() {
		return false; //isActiveDuring Day and Night;
	}




}