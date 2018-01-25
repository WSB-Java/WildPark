/**
 * @author Maciej Bejm
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
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;

import wildpark.*;
import wildpark.model.animals.Animal;
import wildpark.model.*;
 



 
public class CHART_SpeciesTotalWeight_LINE {

	public static boolean isVisible = false;
	private static Stage stage = new Stage();

	CheckBox cb1 = new CheckBox( "Transparent on mouse exit" );

    private LineChart<Number,Number> lineChart = null; 

	
	XYChart.Series series1; 	
	XYChart.Series series2;
	XYChart.Series series3;	


	

	public long step = 0;
	
	private List <Animal> animals;
	
	private int horseCount;
	private int insectEatingBatCount;
	private int giraffeCount;
	private float chamoisTotalWeight;
	private float insectEatingBatsTotalWeight;
	private float testBatsTotalWeight;
	





	
	public CHART_SpeciesTotalWeight_LINE( List<Animal> animals ) {
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
        
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time Steps [hours]");
        yAxis.setLabel("Species total weight [kg]");

        //creating the chart
        lineChart = new LineChart<Number,Number>(xAxis,yAxis);
//        lineChart.setBackground( Background.EMPTY );
       	lineChart.setLegendSide( Side.RIGHT );
     	//lineChart.setCreateSymbols(false);           
                
        /*Button step = new Button("next step");
        step.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				nextStep();
			}
		});*/

		reset();

        lineChart.setPrefSize( 780.0, 500.0 );

        Slider slider = new Slider( 500, 50000, 500 );    // Slider( min, max, initial_value )
        slider.setOrientation( Orientation.VERTICAL );
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(false);
        slider.setMajorTickUnit(10000f);
        slider.setBlockIncrement(1000f);
        slider.setSnapToTicks(true);
        BorderPane.setMargin( slider, new Insets(9,0,9,9) );

        // BINDINGS: Slider ---> LineChart 
        // lineChart.scaleXProperty().bind( slider.valueProperty() );
        lineChart.minHeightProperty().bind( slider.valueProperty() );

		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBackground( Background.EMPTY );
        //lineChart.setMinHeight(10000);	// Set huge MinHeight (ex. 1 000 000) for Y axis to show variations of weight of tiny animals like mice, bats, etc.
        scrollPane.setVvalue( scrollPane.getVmax() );	// Programmatically scroll to the very bottom
        scrollPane.setContent( lineChart );

        // BINDINGS: WINDOW SIZE (ScrollPane) ---> LineChart 
        lineChart.prefWidthProperty().bind( scrollPane.widthProperty().multiply(0.98) );
        lineChart.prefHeightProperty().bind( scrollPane.heightProperty().multiply(0.98) );

        // Window Tranparency
		cb1.setSelected( false );
  //       HBox.setMargin( cb1, new Insets(9,10,9,0) );

		// HBox hBox = new HBox();
  //       hBox.setAlignment(Pos.CENTER_RIGHT);
  //       hBox.getChildren().addAll( cb1 );    

//         VBox vBox = new VBox();
// //        VBox.setVgrow( lineChart, Priority.ALWAYS );
//         vBox.getChildren().addAll( hBox, scrollPane );    
//         BorderPane.setVgrow( vBox, Priority.ALWAYS );

        StackPane stackPane = new StackPane();
		StackPane.setAlignment( cb1, Pos.BOTTOM_RIGHT );
        StackPane.setMargin( cb1, new Insets(9,25,9,0) );
        stackPane.getChildren().addAll( scrollPane, cb1 );

                                  // BorderPane( center    , top ,right, bottom, left ), sceneWidth, sceneHeight  
        Scene scene = new Scene( new BorderPane( stackPane, null, null, null, slider ), 840, 528 );
		stage.setScene( scene );




        // ADD EVENT HANDLERS:

        stage.addEventFilter( MouseEvent.MOUSE_ENTERED_TARGET, e -> {
				if( cb1.isSelected() ) {
					//scene.toFront();
					if( 0 < e.getSceneX() && e.getSceneX() < scene.getWidth() &&
						0 < e.getSceneY() && e.getSceneY() < scene.getHeight() ) {
							stage.setOpacity( 1.00 );
							lineChart.setHorizontalGridLinesVisible( true );
							lineChart.setVerticalGridLinesVisible( true );
					}
//					System.out.println( "--->> MOUSE_ENTERED_TARGET on CHART scene - " + e.getEventType() + " - SceneX:Y: " + e.getSceneX() + ":" + e.getSceneY()  );
				}
            });

        stage.addEventFilter( MouseEvent.MOUSE_EXITED_TARGET, e -> {
				if( cb1.isSelected() ) {
					//stage.toFront();
					if( e.getSceneX() < 0 || scene.getWidth()-5 <  e.getSceneX() ||
						e.getSceneY() < 0 || scene.getHeight()-5 <  e.getSceneY() ) {
							stage.setOpacity( 0.55 );	// Make stage semi transparent 
							lineChart.setHorizontalGridLinesVisible( false );
							lineChart.setVerticalGridLinesVisible( false );
							//scrollPane.setMouseTransparent( true );
					}
//					System.out.println( "<<--- MOUSE_EXITED_TARGET from CHART stage - " + e.getEventType() + " - SceneX:Y: " + e.getSceneX() + ":" + e.getSceneY() );
				}
            });

        // EOF - ADD EVENT HANDLERS:

	}






	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void reset() {
		lineChart.getData().clear();
		step = 0;

		series1 = new XYChart.Series(); 	
		series2 = new XYChart.Series();
		series3 = new XYChart.Series();	

        // series1.setName("Horse");
        // series3.setName("Giraffe");
        // series4.setName("Mammal4");
        // series5.setName("Mammal5");
        series1.setName("Chamois");
        series2.setName("Test Bat");
        series3.setName("Insect Eating Bat");

        lineChart.getData().add( series1 );
        lineChart.getData().add( series2 );    
        lineChart.getData().add( series3 );    		
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
		horseCount = 0;
		giraffeCount = 0;
		chamoisTotalWeight = 0;
		testBatsTotalWeight = 0;
		insectEatingBatsTotalWeight = 0;
		
		getCount();			

		// series1.getData().add(new XYChart.Data(step, horseCount));
		// series3.getData().add(new XYChart.Data(step, giraffeCount));
		series1.getData().add( new XYChart.Data( step, chamoisTotalWeight ) );
		series2.getData().add( new XYChart.Data( step, testBatsTotalWeight ) );
		series3.getData().add( new XYChart.Data( step, insectEatingBatsTotalWeight ) );

		step++;// = WildPark.getWildParkTimeHours();
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
			// if(a.getSPECIES_NAME() == "Horse") {
			// 	horseCount +=1;
			// 	//System.out.println(++horseCount);
			// }
			// if(a.getSPECIES_NAME() == "Giraffe") {
			// 	giraffeCount +=1;
			// 	//System.out.println(++horseCount);
			// }
			if(a.getSPECIES_NAME() == "Insect Eating Bat") { 
				insectEatingBatsTotalWeight += a.getWeight();
//				System.out.printf( "insectEatingBatsTotalWeight: %.4f\r\n", insectEatingBatsTotalWeight );
			}
			//System.out.println(" >>> "+insectEatingBatCount + ", " + horseCount+ ", " + giraffeCount);
		}

		if( step > 200 )
			lineChart.setCreateSymbols( false );	// Remove little circles from chart lines 
//			System.out.printf( "ANIMALS: 200\r\n" );

	}
	
	
}