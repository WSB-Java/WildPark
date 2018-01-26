/**
 * @author Xtry333
 */
package wildpark.model;

import java.util.LinkedHashSet;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.control.*;

import wildpark.model.animals.Animal;
import wildpark.util.YearsDaysHoursDuration;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;


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

	public WildParkAreaCell( int x, int y, String label ) { 
		super( label );
//		this.cellType = _type;
		this.x = x;
		this.y = y;
		this.setAlignment(Pos.TOP_LEFT);
		this.setFont( Font.font(7) );
//		this.setBackground(null);
		
		tooltip.setText( String.format( "%02d:%02d", x, y ) );
		this.setTooltip( tooltip );
		tooltip.setFont( new Font( "Lucida Console", 11 ) );

		bindTooltip( this, tooltip );
	}
	











	/**
	 * This method removes the Tooltip Delay - using it will show tootip imediatelly.
	 * @param node    [description]
	 * @param tooltip [description]
	 */
	public static void bindTooltip( final Node node, final Tooltip tooltip ){
	   node.setOnMouseMoved( new EventHandler<MouseEvent>() {
	      @Override  
	      public void handle( MouseEvent event ) {
	         // +15 moves the tooltip 15 pixels below the mouse cursor;
	         // if you don't change the y coordinate of the tooltip, you
	         // will see constant screen flicker
	         tooltip.show( node, event.getScreenX(), event.getScreenY() + 15 );
	      }
	   });  
	   node.setOnMouseExited( new EventHandler<MouseEvent>() {
	      @Override
	      public void handle( MouseEvent event ){
	         tooltip.hide();
	      }
	   });
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
		String toolTipText = "\nNAME               ID     GENDER    ENERGY      WEIGHT     hSinceLastMeal   Proliferating  AGE";

		// // Remove rotten meat
		// ArrayList<Animal> rottenAnimalBodies = new ArrayList<>();
		// for( Animal animal : animals ) {
		// 	if( !animal.isAlive() ) {
		// 		System.out.println( "######Animal is dead" );
		// 		if( animal.isRotten() )
		// 			System.out.println( "Animal is rotten --------------------------------" );
		// 			rottenAnimalBodies.add( animal );
		// 	}
		// }

		// System.out.println( "WildParkAreaCell.update() - animals.size() BEFORE = " + animals.size() );
		// for( Animal animal : rottenAnimalBodies ) {
		// 	animals.remove( animal );
		// }
		// System.out.println( "WildParkAreaCell.update() - animals.size() AFTER = " + animals.size() );

		// Display living animals and fresh meat 
		for( Animal animal : animals ) {
			animalNames += String.format("\n%-18s", animal.getSPECIES_NAME() );
			toolTipText += String.format("\n%-18s %05d  %-7s  %s    %16s", animal.getSPECIES_NAME(), animal.getId(), animal.getGender(), animal.getAnimalState().toStringForTooltip(), YearsDaysHoursDuration.toString( animal.getAge() ) );
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
