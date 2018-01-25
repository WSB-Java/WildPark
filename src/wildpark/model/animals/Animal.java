package wildpark.model.animals;

import wildpark.*;
import wildpark.model.*;
import java.time.Duration;
import java.util.*;

public abstract class Animal 
extends Meat 
{
	/**
	 * Animal Species Specification Data - CONSTANTS.
	 */
	private AnimalSpeciesSpecification animalSpeciesSpecification;
	private Duration TIME_OF_BIRTH; 
	private Gender GENDER; // płeć

	/**
	 * Animal state data - VARIABLE in time.
	 */
	public float energyLevel = 100;	// Current animal energetic state - initially 100%
	public Duration hoursSinceLastMeal = Duration.ZERO;
	public boolean isProliferating = false; // czy trwa ciążą/wysiadywanie jaj itp. 
	public boolean isFeedingNewborns = false; // czy osobnik karmi noworodki
	public boolean isAlive = true;

	// This object is temporarily used to create the animal state history in animalStateHistory list
	private AnimalState animalState;
	// ToDo: animal state history: - updated on every Time Step
	private ArrayList<AnimalState> animalStateHistory = new ArrayList<>();

	//	Attributes inherited from super classes:
	//	
	//	Inherited from Meat:
	//		public Duration TIME_OF_DEATH = null;
	//		public long ID
	//		protected int MAX_HOURS_OF_SUITABILITY_FOR_CONSUMPTION_SINCE_DEATH_IN_15_DEGREES_CENTIGRADE = 36; 
	//		
	//	Inherited from Food:
	//		float weight;	// current animal weight
	//		WildParkAreaCell wildParkAreaCell = null; // Wild Park Cell corresponds to Area coordinates in which the Food currently is situated
	//		float CALORIC_EFFICIENCY_PER_KILO;



	/**
	 * Animal constructor. The animal of the specified AnimalSpeciesSpecification is created. 
	 * The gender is a lottery. 
	 * The weight is specified according to isNewborn parameter value. If isNewborn == true, then the AnimalSpeciesSpecification.NEWBORN_WEIGHT is used and TIME_OF_BIRTH is now. 
	 * Otherwise the weight is randomly selected according to AnimalSpeciesSpecification.ADULT_WEIGHT +/- 30% and the TIME_OF_BIRTH is randomly selected between AnimalSpeciesSpecification.MIN_SELF_GOVERNMENT_AGE and AnimalSpeciesSpecification.MAX_AGE.  
	 * @param  animalSpeciesSpecification This animal species specification
	 * @param  wildParkAreaCell    WildParkAreaCell object in which this animal is born.
	 * @param  isNewborn           boolean - if true the AnimalSpeciesSpecification.NEWBORN_WEIGHT is used. Otherwise an adult is created.
	 * @see    Animal()
	 */
	public Animal( AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell, boolean isNewborn ) {
		this.animalSpeciesSpecification = animalSpeciesSpecification;
		CALORIC_EFFICIENCY_PER_KILO = animalSpeciesSpecification.getCALORIC_EFFICIENCY_PER_KILO();
		GENDER = Gender.getRandomGender();

		if( isNewborn ) {
			TIME_OF_BIRTH = WildPark.getWildParkTime();
			weight = (float) 0.666 * ( animalSpeciesSpecification.getNEWBORN_WEIGHT() + new Random().nextFloat() * animalSpeciesSpecification.getNEWBORN_WEIGHT()  );
		} 
		else { // if this is a self-governing animal to be generated at WildPark initialization...
			Duration animalAge =  Duration.ofHours( (long)( animalSpeciesSpecification.getMIN_SELF_GOVERNMENT_AGE().toHours() + new Random().nextFloat() * ( animalSpeciesSpecification.getMAX_AGE().toHours() - animalSpeciesSpecification.getMIN_SELF_GOVERNMENT_AGE().toHours() ) ) );
			TIME_OF_BIRTH = WildPark.getWildParkTime().minus( animalAge );
			weight = (float) 0.666 * ( animalSpeciesSpecification.getADULT_WEIGHT() + new Random().nextFloat() * animalSpeciesSpecification.getADULT_WEIGHT()  );
		}

		animalState = new AnimalState( weight, wildParkAreaCell );

		this.wildParkAreaCell = wildParkAreaCell;
        wildParkAreaCell.addAnimal( this );
        WildPark.addAnimal( this );

		System.out.printf( "ID: %6d   %-18s  %-7s  %9.3f kg  %7.2f years old   cell: %03d:%03d\r\n------------------------------------------------------------------------------------\n", getId(), animalSpeciesSpecification.getSPECIES_NAME(), GENDER, weight, WildPark.getWildParkTime().minus(TIME_OF_BIRTH).toDays()/365f, wildParkAreaCell.getX(), wildParkAreaCell.getY() );
	}









	public String getSPECIES_NAME() {
		return animalSpeciesSpecification.getSPECIES_NAME();
	}

	public float getSTANDARD_SPEED() {
		return animalSpeciesSpecification.getSTANDARD_SPEED();
	}

	private float getENERGY_LOSS_ON_IDLE() {
		return animalSpeciesSpecification.getENERGY_LOSS_ON_IDLE();
	}





	public Movement getMovement() {
		return new Movement( animalSpeciesSpecification.getSTANDARD_SPEED() );
	}


	public Duration getAge() {
		return WildPark.getWildParkTime().minus( TIME_OF_BIRTH );	
	}	



	
	public void reduceEenrgy( float energyPercent ) {
		energyLevel -= energyPercent; //(float) energyLevel * energyPercent/100;	// for testing purposes here should be: energyPercen/2;
		System.out.printf( "ID:%06d   energyLevel == %10.4f   energyPercent == %10.4f\r\n", getId(), energyLevel, energyPercent );
	}


	public float getEnergyLevel() {
		return energyLevel;
	}





	/**
	 * [getFood description]
	 * @param  cell WildParkAreaCell in which the Food object should be searched/hunted and taken.
	 * @return      Food object found in the given WildParkAreaCell or null if no Food was found or hunted.
	 */
	public abstract Food getFood( WildParkAreaCell cell );
	

	public abstract Food eat( Food food );
	
	/**
	 * [move description]
	 * @param  time [description]
	 * @return      Returns % of energy used to make move
	 */
	public abstract float move( Duration time );

	protected void moveInRandomDirection( Duration time, float speed ) {
		// System.out.printf( "%s", getWildParkAreaCell().toString() );
		int currentX = getWildParkAreaCell().getX();
		int currentY = getWildParkAreaCell().getY();

		int angle, newX, newY;
		double radians;
		do {
			angle = getDirection();
			System.out.printf( "Animal.moveInRandomDirection(): ID %6d   speed: %7.1f    angle: %03d   Original %s\r\n", getId(), speed, angle, getWildParkAreaCell().toString() );

			radians = Math.toRadians(angle);

			newX = currentX + (int) Math.round( speed * Math.sin(radians) );
			newY = currentY + (int) Math.round( speed * Math.cos(radians) );			

			System.out.printf( "Target: %d:%d\r\n", newX, newY );	
		} while( newX >= WildPark.WILD_PARK_AREA_WIDTH || newX < 0 
			|| newY >= WildPark.WILD_PARK_AREA_HEIGHT || newY < 0 
			|| !acceptsCellType( WildPark.getWildParkAreaCell( newX, newY ).getCellType() ) );

		moveToCell(newX,newY);		
	}


	protected void moveToCell( int x, int y ) {
		if( isAlive ) {
				//Remove animal from current WildParkCell
				System.out.printf( "Animal.moveToCell("+x+","+y+"):  ID %6d   %-18s \r\n%s\r\n", getId(), getSPECIES_NAME(), getAnimalState().toString() );

				getWildParkAreaCell().removeAnimal( this );	
		
				//Move animal to another cell
				setWildParkAreaCell( WildPark.getWildParkAreaCell( x, y ) );
				getAnimalState().setWildParkAreaCell( WildPark.getWildParkAreaCell( x, y ) );	// only to sustain AnimalState up-to-date
				WildPark.getWildParkAreaCell( x, y ).addAnimal( this );
		}
	}






	public void die() {
		System.out.printf( "Animal Died -- ID: %6d \r\n", getId() );
		TIME_OF_DEATH = WildPark.getWildParkTime();
		isAlive = false;
		getAnimalState().isAlive = isAlive; // just to sustain AnimalState up-to-date
		WildParkArea.addDeadInLastTimeStepAnimal( this );
		WildParkArea.addDeadBody( this );
	}

	
	private void useEenrgy( float energyPercentLoss ) {
		reduceEenrgy( energyPercentLoss );
		getAnimalState().setEnergyLevel( getEnergyLevel() );	// only to sustain AnimalState up-to-date
	}

	public abstract void proliferate();
	
	public AnimalState getAnimalState() {
		return animalState;
		//hoursSinceLastMeal, energyPercent, age, isProliferating, isFeedingNewborns, weight
	}

	public AnimalSpeciesSpecification getAnimalSpeciesSpecification() {
		return animalSpeciesSpecification;
	}

	public boolean acceptsCellType( CellType cellType ) {
		return animalSpeciesSpecification.acceptsCellType( cellType );
	}

	public float getStandardSpeed() {
		return animalSpeciesSpecification.getSTANDARD_SPEED();
	}

	public int getDirection() {
		return new Random().nextInt(360);
	}


	/**
	 * If animal is alive - use standard energy + perform animal action and use additional energy associated with the undertaken action. 
	 */
	public void performTimeStep() {
		// Loose energy just because of passing time
		System.out.printf( "Animal.performTimeStep() --- getENERGY_LOSS_ON_IDLE = %.4f\r\n", getENERGY_LOSS_ON_IDLE() );
		useEenrgy( getENERGY_LOSS_ON_IDLE() );

		if( energyLevel <= 0 )
			die();
		else {
			hoursSinceLastMeal = hoursSinceLastMeal.plus( WildPark.getWildParkTimeStepDuration() );
			getAnimalState().hoursSinceLastMeal = hoursSinceLastMeal;	// just to sustain AnimalState up-to-date

			// Loose energy on move
//			float energyPercentLoss = 0;
			float energyPercentLoss = move( WildPark.getWildParkTimeStepDuration() );
			useEenrgy( energyPercentLoss );

			if( energyLevel < getAnimalSpeciesSpecification().getHUNGER_ENERGY_PERCENT() ) { //Zaczyna chudnąć dopiero, gdy osiągię poziom głodu
				energyPercentLoss += getENERGY_LOSS_ON_IDLE(); // get the sum of on_idle_energy_loss + on_move_energy_loss
				System.out.printf( "<70%% --- energyPercentLoss = %.4f\r\n", energyPercentLoss );
				reduceWeight( weight * energyPercentLoss / 100 ); // chudnie procentowo tyle, co traci energii
				getAnimalState().setWeight( weight );	// just to sustain AnimalState up-to-date
			}

			//Remember current animal state at animal history list
			animalStateHistory.add( new AnimalState( getAnimalState() ) );
		}

	}





}

