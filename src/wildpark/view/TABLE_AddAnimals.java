package wildpark.view;

import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import wildpark.WildPark;

public class TABLE_AddAnimals {
	private Stage stage = new Stage();

	/**
	 * Constructor
	 */
	public TABLE_AddAnimals() {
		initialize();
	}
	
	
	
	
	private void initialize() {
		stage.initModality( Modality.APPLICATION_MODAL );
    	stage.initOwner( WildPark.stage );
        stage.setTitle("Add Animals");

        try {
            stage.getIcons().add(new Image("wildpark/favicon-32x32.png"));
        } catch( IllegalArgumentException e ) {
            System.out.println( "Error loading favicon-32x32.png. Should be in \'wildpark\' directory together with WildPark.class file." );
            // System.exit(-1);
        }

        stage.showAndWait();
	}
	
}
