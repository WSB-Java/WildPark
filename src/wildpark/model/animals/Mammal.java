package wildpark.model.animals;

import wildpark.model.*;

public abstract class Mammal extends Animal
implements SsackingAnimal, ChewingAnimal, BirthGivingAnimal
{
	public Mammal( AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		super( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}


	public abstract int giveBirth();

	public void feedNewbornWithMilk() {

	}

	public Food ssackMilk() {
		return null;
	}

	public Food chew() {
		return null;		
	}

	public Food swollow() {
		return null;		
	}
}
