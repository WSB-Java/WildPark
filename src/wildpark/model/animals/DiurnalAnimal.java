package wildpark.model.animals;

//active only at night 
public interface DiurnalAnimal { 
	final boolean isActiveDuringTheDay = true;
	final boolean isActiveDuringTheNight = false;
	public boolean isDiurnal();
}
