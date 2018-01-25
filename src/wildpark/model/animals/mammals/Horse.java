/**
 * @author Xtry333
 */
package wildpark.model.animals.mammals;

import java.time.Duration;

import wildpark.model.AnimalSpeciesSpecification;
import wildpark.model.Food;
import wildpark.model.Gender;
import wildpark.model.WildParkArea;
import wildpark.model.WildParkAreaCell;
import wildpark.model.animals.BirthGivingAnimal;
import wildpark.model.animals.HerbivorousAnimal;
import wildpark.model.animals.Mammal;
import wildpark.model.animals.RunningAnimal;

public class Horse extends Mammal implements RunningAnimal, BirthGivingAnimal, HerbivorousAnimal {

	private final static AnimalSpeciesSpecification animalSpeciesSpecification = new HorseSpeciesSpecification();
	
	public Horse(WildParkAreaCell wildParkAreaCell,
			boolean isNewborn) {
		super(animalSpeciesSpecification, wildParkAreaCell, isNewborn);
		// TODO Auto-generated constructor stub
	}

	public Horse() {
		this( animalSpeciesSpecification, HorseSpeciesSpecification.selectRandomCell(), false);
	}

	public Horse( AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		super( animalSpeciesSpecification, wildParkAreaCell, isNewborn );
	}

	public String NAME = "Horse";
	public float FOOD_QUANTITY_REQUIRED_PER_HOUR = 9 / 24f;// KG
	public int MAX_STARVING_HOURS_BEFORE_DEATH = 14 * 24; // HOURS
	public int STANDARD_SPEED = 7; // KMH
	public int MAX_SPEED = 60; // KMH
	public int MAX_STAMINA = 300; // SECONDS
	public int AVERAGE_SCION_COUNT_IN_LITTER = 1; // Offspring
	public int MAX_AGE = 30 * 365; // DAYS
	public int MIN_BREEDING_AGE = 5 * 365; // DAYS
	public int MAX_BREEDING_AGE = MAX_AGE - 5 * 365; // DAYS
	public int MAX_AGE_IN_NEST; // DAYS
	public int MIN_SELF_GOVERNMENT_AGE = 3 * 365; // DAYS

	Gender gender;

	int age = 0; // Current age
	int hoursSinceLastMeal = 24; // HOURS
	int energyPercent = 100; // 0-100
	int hungerEnergyPercent = 70; // Hungry

	@Override
	public Food ssack(Food food) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public int giveBirth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Food getFood(WildParkAreaCell cell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food eat(Food food) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void proliferate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(Duration duration) {
		// TODO Auto-generated method stub
//		WildParkArea.moveAnimal( this, getStandardSpeed() );
	}
}
