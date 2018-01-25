package wildpark.model.animals;

//active only at night 
public interface MetaturnalAnimal { 
	final boolean isActiveDuringTheDay = true;
	final boolean isActiveDuringTheNight = true;
	public boolean isMetaturnal();
}
