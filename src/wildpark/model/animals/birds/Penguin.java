//package wildpark.model.animals.birds;
//
//import java.time.Duration;
//import wildpark.animals.birds.PenguinSpecification;
//import wildpark.model.Food;
//import wildpark.model.Gender;
//
//public class Penguin extends Bird implements DivingAnimal, WalkingAnimal, EggBearingAnimal, EggIncubatingAnimal, Predator {
//    
//    private final AnimalSpeciesSpecification animalSpeciesSpecification;
//    private int age;
//    private Gender gender;
//    private boolean isProliferating;
//    private boolean isFeedingNewborns;
//    private Duration timeOfBirth;
//    private Duration timeOfDeath;
//
//    public Penguin() {
//        this.animalSpeciesSpecification = new PenguinSpecification();
//        Random generator = new Random(); 
//        this.age = generator.nextInt(animalSpeciesSpecification.getMAX_AGE()) + 1;
//        // this.gender = ?
//        this.isProliferating = generator.nextInt(1);
//        this.isFeedingNewborns = generator.nextInt(1);
//        // this.timeOfBirth = ??? czemu Duration::class a nie LocalDateTime???
//        // this.timeOfDeath = ??? czemu Duration::class a nie LocalDateTime???
//    }
//
//    public Food getFood(WildparkAreaCell cell){
//
//    }
//
//    public Food eat(Food food){
//
//    }
//
//    public Movement move(float time){
//
//    }
//
//    public void proliferate() {
//
//    }
//
//    public void sleep(){
//
//    }
//
//    public void wakeUp(){
//
//    }
//
//    public void die(){
//
//    }
//
//    public void swallow(){
//        System.out.println("Pingwin polyka");
//    }
//    public void dive(){
//        System.out.println("Pingwin nurkuje");
//    }
//    public void walk(){
//        System.out.println("Pingwin chodzi");
//    }
//    public void bearEggs(){
//        System.out.println("Pingwin znosi jajko");
//    }
//    public void incubateEggs(){
//        System.out.println("Pingwin wysiaduje jajka");
//    }
//
//    // Hunts only fishes? (pike/macrel?)
//    public boolean hunt(Fish fish){
//        // returns 0 or 1 if hunt was successful
//    }
//}