package wildpark.model.animals.mammals;

import java.time.Duration;

import wildpark.model.*;
import wildpark.model.animals.*;
import wildpark.model.animals.mammals.*;

public class AntEater extends Mammal implements SwallowingAnimal{
	
    public AntEater(AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell,
			boolean isNewborn) {
		super(animalSpeciesSpecification, wildParkAreaCell, isNewborn);
		// TODO Auto-generated constructor stub
	}

	private String name;
    private int weight; //18-25kg
    final int MAX_STARVING_HOURS_BEFORE_DEATH = 210;
    protected int hoursSinceLastMeal = 0;
    protected int maxEnergyPercent = 100;
    protected int energyPercent = 100;
    final int STANDARD_SPEED = 5;
    final int MAX_SPEED = 60;
    final int MAX_STAMINA = energyPercent;
    final int AVERAGE_SCION_COUNT_IN_LITTER = 1;
    final int MAX_AGE = 9490; //days
    final int MIN_BREEDING_AGE = 900; //days
    final int MAX_BREEDING_AGE = 9000; //days
    final int MIN_SELF_GOVERNMENT_AGE = 547; // days
    protected int age;
    Gender gender;
    boolean isProfilerating; // true if pregnant
    boolean isFeedingNewborns;

    public String set_name(String name){
        return this.name = name;
    }

    public int set_weight(int weight){
        return this.weight = weight;
    }

    public int giveBirth(){ //AntEater have always one child
        return 1;
    }

    public void feedNewbornWithMilk(){
        this.energyPercent -= 5;
    }

    public void ssack_Milk(){
        this.energyPercent += 10;
    }

    public void swallow(int howManyAnt){
        if(howManyAnt<=300){
            this.energyPercent += 1;
        } else if (howManyAnt <=3000){
            this.energyPercent +=10;
        } else {
            this.energyPercent +=20;
        }
    }

	@Override
	public Food ssack(Food food) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food chew(Food food) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food swallow(Food food) {
		// TODO Auto-generated method stub
		return null;
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
	public void move(Duration time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void proliferate() {
		// TODO Auto-generated method stub
		
	}


}
