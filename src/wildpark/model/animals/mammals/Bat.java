package wildpark.model.animals.mammals;

import wildpark.model.*;
import wildpark.model.animals.*;

public abstract class Bat extends Mammal 
implements FloatingAnimal, NestingAnimal, FlyingAnimal
{
	public Bat( AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		super( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}


	public void fly() { 
	}

	public Movement floatOnWater( float time ) {
		return null;
	}

	public void occupyNest() { 
	}

	public void leaveNest() { }

	public void soar() {  }
}
