package wildpark.model.animals;

import wildpark.model.*;

public interface ChewingAnimal
extends SwallowingAnimal  
{
	public Food chew( Food food );
}
