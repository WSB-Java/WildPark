package wildpark.model.animals.mammals;

import java.time.Duration;

import wildpark.model.*;
import wildpark.model.animals.Animal;
import wildpark.model.animals.Predator;
import wildpark.model.animals.NocturnalAnimal;
import wildpark.model.animals.BirthGivingAnimal;
import wildpark.model.animals.CarnivorousAnimal;
import wildpark.model.animals.ChewingAnimal;
import wildpark.model.animals.Mammal;
import wildpark.model.animals.SwallowingAnimal;



/**
 * The REAL animal class. This contains implementations of all abstract methods declared in all superclasses.
 */
public class Lion extends Mammal implements NocturnalAnimal, Predator, BirthGivingAnimal, CarnivorousAnimal, ChewingAnimal, SwallowingAnimal{
	private final AnimalSpeciesSpecification animalSpeciesSpecification = new LionSpecification();

	//	Inherited from Meat:
	// public Duration TIME_OF_DEATH = null;

	//	Inherited from Food:
	// public float weight;	// current animal weight
	// private final float CALORIC_EFFICIENCY_PER_KILO = animalSpeciesSpecification.CALORIC_EFFICIENCY_PER_KILO; // okre�la liczb� kalorii z kilograma danego mi�sa 

	public Lion( AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		super( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}





	public CellType[] getAcceptableCellTypes() {
        return LionSpecification.getAcceptableCellTypes();
   }

	public Food getFood( WildParkAreaCell cell ) {
		return null;
	}
	
	public boolean hunt( Animal animal ) {
		return false;
	}
	
	public boolean isNocturnal() {
		return true; //isActiveDuringTheNight;
	}
	
	public int giveBirth() {	// Returns the number of newborns
		return 0;		
	}
	
	public Food chew( Food food ) {
		return null;
	}

	public Food eat( Food food ) {
		return null;
	}

	public void move( Duration time ) {
	}

	public void proliferate(  ) {
	}


	public int digestMeat( Meat meat )	{ // return energy amount
		return 0;
	}


	public Food ssack( Food food ) {
		return null;
	}

	public Food swallow( Food food ) {
		return null;
	}
}