package wildpark.model.animals;

public interface NestingAnimal {  //animal that feeds newborns in one place for ex. horse ich not NestingAnimal
	public void occupyNest(); 	// Nest - a permanent place of keeping newborns. When NestingAnimal is going to have newborns, it occupies a nest.
	public void leaveNest();	// After newborns become independent, the whole family leaves the nest.
	
}
