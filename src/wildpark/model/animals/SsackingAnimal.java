package wildpark.model.animals;

import wildpark.model.*;

public interface SsackingAnimal extends SwallowingAnimal 
{
	public Food ssack( Food food );
}