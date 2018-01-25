package wildpark.model.animals.reptiles;

import java.time.Duration;

import wildpark.model.AnimalSpeciesSpecification;
import wildpark.model.CellType;
import wildpark.model.Food;
import wildpark.model.Meat;
import wildpark.model.WildParkAreaCell;
import wildpark.model.animals.Animal;
import wildpark.model.animals.CarnivorousAnimal;
import wildpark.model.animals.ChewingAnimal;
import wildpark.model.animals.CrawlingAnimal;
import wildpark.model.animals.DivingAnimal;
import wildpark.model.animals.EggBearingAnimal;
import wildpark.model.animals.Predator;
import wildpark.model.animals.Reptile;

public class Crocodile extends Reptile implements Predator, CarnivorousAnimal, ChewingAnimal, CrawlingAnimal, DivingAnimal, EggBearingAnimal {
	private final static AnimalSpeciesSpecification animalSpeciesSpecification = new CrocodileSpecification();

	public Crocodile(WildParkAreaCell wildParkAreaCell, boolean isNewborn) {
		super( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}

	public CellType[] getAcceptableCellTypes() {
        return CrocodileSpecification.getAcceptableCellTypes();
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

	@Override
	public Food swallow(Food food) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food chew(Food food) {
		// TODO Auto-generated method stub
		return null;
	}
}


