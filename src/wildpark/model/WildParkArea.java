/**
 * @author 
 */

package wildpark.model;

import wildpark.*;
import wildpark.model.animals.*;
import wildpark.model.*;
import java.util.*;

public class WildParkArea {
	private static ArrayList<Meat> deadBodiesList = new ArrayList<>();
	private static ArrayList<Animal> deadInLastTimeStepAnimals= new ArrayList<>();


	public static ArrayList<Meat> getDeadBodies() {
		return deadBodiesList;
	}	

	/**
	 * Get the list of animals that died in current Wild Park Time Step. Those animals must be removed 
	 * from animals list and added to dead bodies list. This list is required to avoid concurrency 
	 * problems wile making a time step in Wild Park in .
	 * @return List of animals that died in current Wild Park Time Step.
	 */
	public static ArrayList<Animal> getDeadInLastTimeStepAnimals() {
		return deadInLastTimeStepAnimals;
	}	

    public static void removeDeadBody( Meat deadBody ) {
        getDeadBodies().remove( deadBody ); 
        // WildPark.updateUI_label_NumberOfDeadBodies( getDeadBodies().size() );  
    } 

	public static void addDeadBody( Meat deadBody ) {
		getDeadBodies().add( deadBody );
		// WildPark.updateUI_label_NumberOfDeadBodies( getDeadBodies().size() );  
	}

	public static void addDeadInLastTimeStepAnimal( Animal animal ) {
		getDeadInLastTimeStepAnimals().add( animal );
	}

}
