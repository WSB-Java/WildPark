/**
 * @author Xtry333
 */
package wildpark.model;

import java.util.LinkedHashSet;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import wildpark.model.animals.Animal;
import javafx.scene.control.*;

public class WildParkAreaCell extends Button {
	
	private CellType cellType;
	
	public boolean modified = true;
	
	private int x;
	private int y;

	private Tooltip tooltip = new Tooltip();
	
	/**
	 * LinkedHashSet is used because we want to know the sequence of animals arrival to particular WildParkAreaCell 
	 * and we will often add or remove animals from inside the set - LinkedHashSet assures O(1).
	 */
	private LinkedHashSet<Animal> animals = new LinkedHashSet<>();

	public WildParkAreaCell( String string ) {
		super( string );
	}

	public WildParkAreaCell( int _x, int _y, String label ) { // "_" is for clear difference between this.x and method argument _x
		super( label );
//		this.cellType = _type;
		this.x = _x;
		this.y = _y;
		this.setAlignment(Pos.TOP_LEFT);
		this.setFont( Font.font(7) );
//		this.setBackground(null);
		
		tooltip.setText( String.format( "%02d:%02d", x, y ) );
		this.setTooltip( tooltip );
		tooltip.setFont( new Font( "Lucida Console", 11 ) );
	}
	
	public void setCellType( CellType cellType ) {
		this.cellType = cellType;
	}

	public CellType getCellType() {
		return cellType;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public LinkedHashSet<Animal> getAnimals() {
		return animals;
	}

	public void addAnimal( Animal animal ) {
		this.animals.add( animal );
		update(); // Update cell label
	}

	public void removeAnimal( Animal animal ) {
		this.animals.remove( animal );
		update(); // Update cell label
	}
	

	public void clear() {
		animals.clear();
		update();
	}


	/**
	 * Update cell label
	 */
	public void update() {
		String coords = String.format( "%02d:%02d", x, y );
		String animalNames = "";
		String toolTipText = "\nNAME               ID      ENERGY      WEIGHT      hSinceLastMeal";
		for( Animal animal : animals ) {
			animalNames += String.format("\n%-18s", animal.getSPECIES_NAME() );
			toolTipText += String.format("\n%-18s %05d  %s", animal.getSPECIES_NAME(), animal.getId(), animal.getAnimalState().toStringForTooltip() );
		}		
		this.setText(coords + animalNames);
		tooltip.setText(coords + toolTipText);
	}



	public String toString() {
		return String.format( "Cell %03d:%03d", x, y );
	}

	public String getPosition() {
		return "X: " + this.x + ", Y: " + this.y;

	}
}
