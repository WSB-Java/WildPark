//package wildpark.model.animals.Birds;
//
//class Wolf extends Mamals{
//	int hoursSinceLastMeal = 0;
//	int energyPercent = 0;
//	int maxEnergyPercent = 0;
//	// qabtity of food eaten in kg
//	public String NAME;
//	public int ADULT_WEIGHT;
//	public float FOOD_QUANTITY_REQUIRED_PER_HOUR=0.02; 
//	public int MAX_STARVING_HOURS_BEFORE_DEATH=24; 
//	public Duration hoursSinceLastMeal;
//	public int energyPercent;	// Current animal energetic state - 
//	public int MAX_ENERGY_PERCENT; 
//	public int STANDARD_SPEED=40;	// sprawdzamy jaką odległość zwierzę standardowo pokonuje w ciągu dnia (w czasie godzin aktywności) i na tej podstawie obliczamy stardard w km/h
//	public int MAX_SPEED=60;	
//	public int MAX_STAMINA=100; 
//	public int AVERAGE_SCION_COUNT_IN_LITTER=4; // średnia liczba potomków w miocie
//	public int MAX_SCION_COUNT_IN_LITTER=7;	// na tej podstawie określimy widełki RANDOMa określającego liczbę potomków w danym miocie
//	public Duration MAX_AGE=2196; 
//	public Duration MIN_BREEDING_AGE=732; // minimalny wiek rozrodczy
//	public Duration MAX_BREEDING_AGE=1830; // maksymalny wiek rozrodczy
//	public Duration MAX_AGE_IN_NEST=80; // po ilu 
//	public Duration MIN_SELF_GOVERNMENT_AGE=732; // minimalny wiek usamodzielnienia się
//	public Duration age;	// aktualny wiek zwierzęcia
//	public Gender GENDER; // płeć
//	public boolean isProliferating; // czy trwa ciążą/wysiadywanie jaj itp. 
//	public boolean isFeedingNewborns ; // czy osobnik karmi noworodki
//	public Duration TIME_OF_BIRTH; 
//
//	//
//
//	//return amount of food swollowed in kg
//	
//	//
//
//	public enum AcceptableCellType {
//		FOREST,
//		GRASS		
//	}
//	public Food getFood( WildParkAreaCell cell ) {
//		return null;
//	}
//
//	public Food eat( Food food ) {
//		return null;
//	}
//
//	public Movement move( float time ) {
//		return new Movement(  );
//	}
//
//	public void proliferate(  ) {
//	}
//
//	public boolean hunt( Animal animal ) {
//		return false;
//	}
//
//	public int digestMeat( Meat meat )	{ // return energy amount
//		return 0;
//	}
//
//	public int giveBirth() {	// Returns the number of newborns
//		return 0;		
//	}
//
//	public Food ssack( Food food ) {
//		return null;
//	}
//
//	public Food swollow( Food food ) {
//		return null;
//	}
//
//	public Food chew( Food food ) {
//		return null;
//	}
//
//	
//
//}