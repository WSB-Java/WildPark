package wildpark.model;

import java.time.Duration;

/**
 * Object of this class describes a singe state of the animal after each Time Step in Wild Park.
 * AnimalState objects are collected in animalStateList ArrayList for every animal - this is the 
 * whole history of animal life.
 */
public class AnimalState {
	public float energyLevel = 100;	// Current animal energetic state - initially 100%
	public Duration hoursSinceLastMeal = Duration.ZERO;
	public boolean isProliferating = false; // czy trwa ciążą/wysiadywanie jaj itp. 
	public boolean isFeedingNewborns = false; // czy osobnik karmi noworodki
	WildParkAreaCell wildParkAreaCell = null; // Wild Park Cell corresponds to Area coordinates in which the animal currently resides
	private float weight = -1;
	public boolean isAlive = true;

	/**
	 * Basic Constructor of Animal State object
	 * @param  weight           The initial weight of the animal
	 * @param  wildParkAreaCell Wild Park Cell corresponds to Area coordinates in which the animal currently resides
	 */
    public AnimalState( float weight, WildParkAreaCell wildParkAreaCell ) {
    	this.weight = weight;
    	this.wildParkAreaCell = wildParkAreaCell;
    }

    /**
     * Full Constructor
     * @param  animalState Another AnimalState object (source).
     */
    public AnimalState( AnimalState animalState ) {
    	this.energyLevel = animalState.energyLevel;
    	this.hoursSinceLastMeal = animalState.hoursSinceLastMeal;
    	this.isProliferating = animalState.isProliferating;
    	this.isFeedingNewborns = animalState.isFeedingNewborns;
    	this.wildParkAreaCell = animalState.wildParkAreaCell;
    	this.weight = animalState.weight;
    	this.isAlive = animalState.isAlive;
    }


	public String toString() {
		return String.format( "energyLevel: %6.1f, hoursSinceLastMeal: %s, isProliferating: %s, isFeedingNewborns: %s, \r\n%s, %,.4f kg, isAlive: %s\r\n", energyLevel, hoursSinceLastMeal.toHours(), isProliferating, isFeedingNewborns, wildParkAreaCell.toString(), weight, isAlive );
	}

	public String toStringForTooltip() {
		return String.format( " %1$6.3f %% %3$8.4f kg %2$17d  ", energyLevel, hoursSinceLastMeal.toHours(), weight );
	}

	public WildParkAreaCell getWildParkAreaCell() {
		return wildParkAreaCell;
	}


	public void setWildParkAreaCell( WildParkAreaCell wildParkAreaCell ) {
		this.wildParkAreaCell = wildParkAreaCell;
	}


	public void setEnergyLevel( float energyLevel ) {
		this.energyLevel = energyLevel; 
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight( float weight ) {
		this.weight = weight;
	}


}