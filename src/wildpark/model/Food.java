package wildpark.model;

//import wildpark.controller.*;


/**
 * This is the superclass of classes Plant and Meat.
 */
public abstract class Food 
{
	/**
	 * Weight of food (plant-food or meat-food) in kilograms.
	 */
	protected float weight;

	protected WildParkAreaCell wildParkAreaCell = null; // Wild Park Cell corresponds to Area coordinates in which the Food currently is situated


	/**
	 * Caloric efficiency of 1 kilogram of food. This is constant specified in the real animal class inherited from this abstract. 
	 */
	protected int CALORIC_EFFICIENCY_PER_KILO;




	public void setCALORIC_EFFICIENCY_PER_KILO( int caloricEfficiencyPerKilo ) {
		CALORIC_EFFICIENCY_PER_KILO = caloricEfficiencyPerKilo;
	}
	/**
	 * Getter of weight attribute.
	 * @return float weight of food in kilograms.
	 */
	public float getWeight() { 
		return weight; 
	}

	public void setWeight( float weight ) { 
		this.weight = weight; 
	}

	/**
	 * Add the specified quantity of food material (in [kg]).
	 * @param weight Weight in [kg] 
	 */
	public void increaseWeight( float weight ) { 
		this.weight += weight; 
	}

	/**
	 * Substract the specified quantity of food material (in [kg]).
	 * @param weight [description]
	 */
	public void reduceWeight( float weight ) { 
		this.weight -= weight; 
		System.out.printf( "weightREDUCTION == %10.4f   ANIMALweight == %10.4f\r\n", weight, this.weight );		
	} 

	public WildParkAreaCell getWildParkAreaCell() {
		return wildParkAreaCell;
	}


	public void setWildParkAreaCell( WildParkAreaCell wildParkAreaCell ) {
		this.wildParkAreaCell = wildParkAreaCell;
	}


//	public abstract long getSuitabilityForConsumption();

}
