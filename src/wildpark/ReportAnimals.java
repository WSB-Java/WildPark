/**
 * @author Xtry333
 */
package wildpark;

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import wildpark.model.animals.Animal;
import javafx.geometry.Insets;
import wildpark.util.YearsDaysHoursDuration;

public class ReportAnimals {

	//static List<Animal> thisShouldBeGlobalAnimalsList = WildPark.getAnimals();
	private List<Animal> animals;
	private String label;
	/**
	 * Opens list view of animals with default title
	 * @param animals Animals list
	 */
	ReportAnimals(List<Animal> _animals) {
		this(_animals, "Animal List");
	}
	/** 
	 * Opens list view of animals
	 * @param animals Animals list
	 * @param label Window title
	 */
	ReportAnimals(List<Animal> _animals, String _label) {
		animals = _animals;
		label = _label;
	}
	
	public void show() throws Exception {
		Stage stage = new Stage(); // Creating a stage (window)

        try {
            stage.getIcons().add(new Image("wildpark/favicon-32x32.png"));
        } catch( IllegalArgumentException e ) {
            System.out.println( "Error loading favicon-32x32.png. Should be in \'wildpark\' directory together with WildPark.class file." );
            // System.exit(-1);
        }

		HBox root = new HBox(); // Creating master parent
		Scene scene = new Scene(root);
		
		VBox boxListContainer = new VBox(); // Animals list on the left
		VBox paneDetailInfoContainer = new VBox(); // Detailed info on the right
		boxListContainer.setPrefHeight(600);
		paneDetailInfoContainer.setMinWidth(300);

		paneDetailInfoContainer.setPadding( new Insets(10, 10, 10, 10) );		

		root.getChildren().add(boxListContainer);
		root.getChildren().add(paneDetailInfoContainer);
		

		ListView<Animal> listView = new ListView<Animal>(); // Animal List
		

		boxListContainer.getChildren().add(listView);
		boxListContainer.setVgrow( listView, Priority.ALWAYS );

		Label labelBigName = new Label(); // Big species name label
		labelBigName.setFont(new Font("Arial", 25));
		labelBigName.setPrefWidth(470);
		labelBigName.setAlignment(Pos.BASELINE_CENTER);

		Label labelDetailInfoName = new Label(); // Big species name label
		labelDetailInfoName.setFont(new Font("Arial", 13));
		labelDetailInfoName.setPrefWidth(470);
		//labelDetailInfoName.setAlignment(Pos.BASELINE_CENTER);
		
		paneDetailInfoContainer.getChildren().add(labelBigName);
		paneDetailInfoContainer.getChildren().add(labelDetailInfoName);
		
		listView.setMinWidth(350);
		listView.setMaxWidth(350);
		
		ObservableList<Animal> oList = FXCollections.observableArrayList();
		for (Animal a : animals) {
			oList.add(a);
		}
		
		listView.setItems(oList);
		
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Animal>() {
			@Override
			public void changed(ObservableValue<? extends Animal> observable, Animal oldAnimal, Animal newAnimal) {
				labelBigName.setText( newAnimal.getSPECIES_NAME() );
				YearsDaysHoursDuration age = new YearsDaysHoursDuration( newAnimal.getAge().toHours() );
				labelDetailInfoName.setText( String.format( "ID: %6d\r\n%s\r\nAge: %03d years %03d days %02d hours\r\n", newAnimal.getId(), newAnimal.getWildParkAreaCell().toString(), age.getYears(), age.getDays(), age.getHours() ) );
				System.out.println("Changed selection on report list: " + newAnimal.getClass().getSimpleName());
				/* TODO: Display more information about animals */
			}
		});
		
		stage.setTitle("Animal List");
		stage.setScene(scene);
		//stage.setHeight(900);
		// stage.setMaxWidth(1600);
		// stage.setMaxHeight(900);
		stage.show();
	}
}