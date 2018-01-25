/**
 * @author Maciej Bejm
 * @contributor Marcin "marlepo" Potrykus
 *
 */

package wildpark.view;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import javafx.geometry.Side;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;

import wildpark.*;
import wildpark.model.animals.Animal;
import wildpark.model.*;
 


 
public class CHART_SpeciesTotalWeight_PIE {

	public static boolean isVisible = false;
	private static Stage stage = new Stage();

	private PieChart pieChart;
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

	
	

	
	private List <Animal> animals;
	
	private float chamoisTotalWeight;
	private float insectEatingBatsTotalWeight;
	private float testBatsTotalWeight;
	





	
	public CHART_SpeciesTotalWeight_PIE( List<Animal> animals ) {
		this.animals = animals;
		initialize();
	}
	






	private void initialize() {
    	stage.initOwner( WildPark.stage );
        stage.setTitle("Wild Park - Total Weight of Species");

        try {
            stage.getIcons().add(new Image("wildpark/favicon-32x32.png"));
        } catch( IllegalArgumentException e ) {
            System.out.println( "Error loading favicon-32x32.png. Should be in \'wildpark\' directory together with WildPark.class file." );
            // System.exit(-1);
        }

        stage.setOnCloseRequest( new EventHandler<WindowEvent>() {
        	@Override
        	public void handle( WindowEvent e ) {
        		isVisible = false;
        	}
        });


        stage.setOpacity( 1.00 );
        
        //creating the chart
        pieChart = new PieChart(pieChartData);       
        pieChart.setTitle("Species total weight in ecosystem [kg]");
        pieChart.setLegendSide(Side.LEFT);

        /*Button step = new Button("next step");
        step.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				nextStep();
			}
		});*/

		reset();

        pieChart.setPrefSize( 780.0, 600.0 );

        //Scene scene  = new Scene( new BorderPane( lineChart, step, null, null, null ), 800,600 );
		// ScrollPane scrollPane = new ScrollPane();
  //       scrollPane.setContent( pieChart );
        Scene scene = new Scene( pieChart, 800, 600 ); 
        stage.setScene(scene);
 
         // ADD EVENT HANDLERS:

        stage.addEventFilter( MouseEvent.MOUSE_ENTERED_TARGET, e -> {
				//scene.toFront();
				if( 0 < e.getSceneX() && e.getSceneX() < scene.getWidth() &&
					0 < e.getSceneY() && e.getSceneY() < scene.getHeight() ) {
						stage.setOpacity( 1.00 );
				}
//				System.out.println( "--->> MOUSE_ENTERED_TARGET on CHART scene - " + e.getEventType() + " - SceneX:Y: " + e.getSceneX() + ":" + e.getSceneY()  );
            });

        stage.addEventFilter( MouseEvent.MOUSE_EXITED_TARGET, e -> {
					//stage.toFront();
					if( e.getSceneX() < 0 || scene.getWidth()-5 <  e.getSceneX() ||
						e.getSceneY() < 0 || scene.getHeight()-5 <  e.getSceneY() ) {
//							stage.setOpacity( 0.65 );	// Make stage semi transparent 
							//scrollPane.setMouseTransparent( true );
					}
//					System.out.println( "<<--- MOUSE_EXITED_TARGET from CHART stage - " + e.getEventType() + " - SceneX:Y: " + e.getSceneX() + ":" + e.getSceneY() );
            });

        // EOF - ADD EVENT HANDLERS:


	}






	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void reset() {
		pieChart.getData().clear();
	}







	@SuppressWarnings("unchecked")
	public void show() {                     
       	stage.show();
        //stage.setAlwaysOnTop( true );
        
        isVisible = true;
    }







	public static Stage getStage() {
		return stage;
	}







	public void update() {
		nextStep();
	}






	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void nextStep() {	
		chamoisTotalWeight = 0;
		testBatsTotalWeight = 0;
		insectEatingBatsTotalWeight = 0;
		
		getCount();			

		// ObservableList<Data> answer = FXCollections.observableArrayList();
		// answer.addAll(new PieChart.Data("java", 17),
  //           new PieChart.Data("JavaFx",31),
  //           new PieChart.Data("Swing",10),
  //           new PieChart.Data("IO",20),
  //           new PieChart.Data("NIO",21)
  //       );
            
		pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Chamois", chamoisTotalWeight),
            new PieChart.Data("Test Bat", testBatsTotalWeight),
            new PieChart.Data("Insect Eating Bat", insectEatingBatsTotalWeight)
		);
		pieChart.setData( pieChartData );

	}
	
    





	public void getCount() {	
		for( Animal a : WildPark.getAnimals() ) {			
			if(a.getSPECIES_NAME() == "Chamois") {
				chamoisTotalWeight += a.getWeight();
//				System.out.printf( "ChamoisTotalWeight: %.4f\r\n", chamoisTotalWeight );
			}			
			if(a.getSPECIES_NAME() == "TestBat") {
				testBatsTotalWeight += a.getWeight();
//				System.out.printf( "testBatsTotalWeight: %.4f\r\n", testBatsTotalWeight );
			}
			if(a.getSPECIES_NAME() == "Insect Eating Bat") { 
				insectEatingBatsTotalWeight += a.getWeight();
//				System.out.printf( "insectEatingBatsTotalWeight: %.4f\r\n", insectEatingBatsTotalWeight );
			}
			//System.out.println(" >>> "+insectEatingBatCount + ", " + horseCount+ ", " + giraffeCount);
		}



	}
	
	
}