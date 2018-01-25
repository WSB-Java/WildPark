//import javafx.scene.image.Image;
//import wildpark.model.AnimalSpeciesSpecification;
//import wildpark.model.Gender;
//import wildpark.model.WildParkAreaCell;
//import wildpark.model.animals.Mammal;
//import wildpark.model.animals.MetaturnalAnimal;
//
//public class Hyena extends Mammal implements RunningAnimal, Scavenger, ChewingAnimal, FloatingAnimal, MetaturnalAnimal {
//
//public Hyena(AnimalSpeciesSpecification animalSpeciesSpecification, WildParkAreaCell wildParkAreaCell,
//			boolean isNewborn) {
//		super(animalSpeciesSpecification, wildParkAreaCell, isNewborn);
//		// TODO Auto-generated constructor stub
//	}
//private String name = "Hyena";
//private int animalId;
//private int weight = 63; //average weight is 62-70kg
//int hoursSinceLastMeal; //how many days have past after the last meal
//int energyPercent; // current energetic state - percent of full energy (after eating > 100)
//int maxEnergyPercent; // the ability to overeat
//final int MAX_AGE_IN_NEST = 730; // days - until this age the newborn must stay in the place of birth (nest)
//final int MIN_SELF_GOVERNMENT_AGE = 730; //days when the animal becomes autonomous - does not need to be fed by parrents - before this ammount the newborn must be with parrent
//int age; //current age in days
//Gender gender = Gender.MALE; // Gender.MALE or Gender.FEMALE
//boolean isProliferating; // true if the animal is pregnant or incubating eggs
//boolean isFeedingNewborns = false; // true if the animal is feeding newborns
//Image animalImage; // plik PNG z ikoną zwierzęcia
////Photo aniamPhoto; //
//final int FOOD_QUANTITY_REQUIRED_PER_DAY = 4; //kg Spotted Hyenas consume 3 - 6 kgs (6.6 - 13.2 lbs) of meat per day
//final int MAX_STARVING_DAYS_BEFORE_DEATH  ; //
//int daysSinceLastMeal; //how many days have past after the last meal
//final int STANDARD_SPEED = 3;
//final int MAX_SPEED = 60;
//final int MAX_STAMINA; // seconds
//final int AVERAGE_SCION_COUNT_IN_LITTER = 80;
//final int MAX_AGE = 9125;				//days 12 Yrs (wild) Up to 25 Yrs (in Captivity)
//final int MIN_BREEDING_AGE = 730; 	//days 2y
//final int MAX_BREEDING_AGE = 7300; //days 20y
//
//
//	void run(){
//
//		}
//	boolean seekMeat(){
//
//		}
//	int digestMeat(float foodWeight){
//
//		}
//
//}
//
//interface RunningAnimal{
//	void run();
//}
//interface Scavenger{
//	boolean seekMeat();
//}
//interface ChewingAnimal{
//	int digestMeat(float foodWeight);
//}
//interface FloatingAnimal(){
//	void float();
//}
