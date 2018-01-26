/**
 * @author Maciej Bejm
 *
 */

package wildpark.view;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.scene.layout.Priority;
// import javafx.scene.layout.StackPane;

import javafx.beans.value.ObservableValue;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

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
	CheckBox cb2 = new CheckBox( "Enlarge scale for tiny animals" );

    private LineChart<Number,Number> lineChart = null; 	
	private Map<String,Float> speciesTotalWeightMap = new TreeMap<>();
	private ArrayList<XYChart.Series> seriesList = new ArrayList<>();

    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();

	// XYChart.Series series1; 	
	// XYChart.Series series2;
	// XYChart.Series series3;	
	

	public long step = 0;
	
	private List <Animal> animals;
	
	double scrollPaneCurrentVvalue;
	boolean shouldListenToScroll = true;

	// private float chamoisTotalWeight;
	// private float insectEatingBatsTotalWeight;
	// private float testBatsTotalWeight;
	





	
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
        
        // The axes
        // xAxis = new NumberAxis();
        // yAxis = new NumberAxis();
        xAxis.setLabel("Time Steps [hours]");
        yAxis.setLabel("Total weight of each species [kg]");

        // The chart
        lineChart = new LineChart<Number,Number>(xAxis,yAxis);
//        lineChart.setBackground( Background.EMPTY );
       	lineChart.setLegendSide( Side.BOTTOM );
     	//lineChart.setCreateSymbols(false);           
                
        /*Button step = new Button("next step");
        step.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				nextStep();
			}
		});*/

		reset();

        lineChart.setPrefSize( 780.0, 250.0 );

        Slider slider = new Slider( 100, 100000, 100 );    // Slider( min, max, initial_value ) SLOWS DOWN AT 500 000
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
        scrollPane.setPannable( true );
        scrollPaneCurrentVvalue = 1.0;

		slider.valueProperty().addListener(
		    (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
//			    if( scrollPane.getVvalue() > 0.9 ) {
//			    	shouldListenToScroll = false;
					Timeline timeline = new Timeline( new KeyFrame(
				        Duration.millis(10),
				        ae -> scrollPane.setVvalue( scrollPaneCurrentVvalue ) ) );	// Programmatically scroll to the very bottom
//						shouldListenToScroll = true;
					timeline.play();
//				}
			});        

		// Below is a try to remember current Scroll V Value and to regain this percentage position on sliderValueProperty change 
		// BUT IT DID NOT WORK THE ELEGANT WAY (IT JUMPS A LOT AND NOT FULLY PREDICTABLY)
		// scrollPane.vvalueProperty().addListener(
		//     (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
		//         if( shouldListenToScroll ) {
		//         	scrollPaneCurrentVvalue = scrollPane.getVvalue();
		// 	        System.out.println( "Scroll V Value = " +  scrollPaneCurrentVvalue );
		//         }
		// 	});        


        // BINDINGS: WINDOW SIZE (ScrollPane) ---> LineChart 
        lineChart.prefWidthProperty().bind( scrollPane.widthProperty().multiply(0.98) );
        lineChart.prefHeightProperty().bind( scrollPane.heightProperty().multiply(0.98) );

        // Window Tranparency
		cb1.setSelected( false );
        HBox.setMargin( cb1, new Insets(9,10,9,0) );

		cb2.setSelected( false );
        HBox.setMargin( cb2, new Insets(9,30,9,0) );

		cb2.selectedProperty().addListener(
			(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//		        yAxis.setForceZeroInRange( true );
		        System.out.println( "CB2" );
			});


		HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().addAll( cb1  );    

//         VBox vBox = new VBox();
// //        VBox.setVgrow( lineChart, Priority.ALWAYS );
//         vBox.getChildren().addAll( hBox, scrollPane );    
//         BorderPane.setVgrow( vBox, Priority.ALWAYS );

  //       StackPane stackPane = new StackPane();
		// StackPane.setAlignment( cb1, Pos.BOTTOM_RIGHT );
  //       StackPane.setMargin( cb1, new Insets(9,25,80,0) );
  //       stackPane.getChildren().addAll( scrollPane, cb1 );

                                  // BorderPane( center    , top ,right, bottom, left ), sceneWidth, sceneHeight  
        Scene scene = new Scene( new BorderPane( scrollPane, null, null, hBox, slider ), 840, 310 );
		stage.setScene( scene );

		slider.requestFocus();




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
		lineChart.setCreateSymbols( true );	// Display little circles at chart lines 

		// series1 = new XYChart.Series(); 	
		// series2 = new XYChart.Series();
		// series3 = new XYChart.Series();	

  //       series1.setName("Chamois");
  //       series2.setName("Test Bat");
  //       series3.setName("Insect Eating Bat");

  //       lineChart.getData().add( series1 );
  //       lineChart.getData().add( series2 );    
  //       lineChart.getData().add( series3 );    	


        // Create Species Weight Map 
		speciesTotalWeightMap.clear();
		for( Animal a : WildPark.getAnimals() ) {	
			String speciesName = a.getSPECIES_NAME();		
			Float speciesTotalWeight = speciesTotalWeightMap.get( speciesName );   	
			speciesTotalWeightMap.put( speciesName, ( speciesTotalWeight==null ) ? Float.valueOf(a.getWeight()) : Float.valueOf(Float.sum(speciesTotalWeight.floatValue(),a.getWeight())) );
		}

		// Create series list and add each series to the lineChart
		seriesList.clear();
		for( String speciesName : speciesTotalWeightMap.keySet() ) {
			XYChart.Series series = new XYChart.Series(); 	
			series.setName( speciesName );
			seriesList.add( series );
			lineChart.getData().add( series );
		}

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
		// chamoisTotalWeight = 0;
		// testBatsTotalWeight = 0;
		// insectEatingBatsTotalWeight = 0;

        // Create Species Weight Map 
        // Put ZERO for every species - do not delete species that were present in preceding steps
		for( String speciesName : speciesTotalWeightMap.keySet() ) {
			speciesTotalWeightMap.put( speciesName, Float.valueOf( 0 ) );
		}

		// Get species weight info from WildPark.animals list
		for( Animal a : WildPark.getAnimals() ) {	
			String speciesName = a.getSPECIES_NAME();		
			Float speciesTotalWeight = speciesTotalWeightMap.get( speciesName );   	
			speciesTotalWeightMap.put( speciesName, ( speciesTotalWeight==null ) ? Float.valueOf(a.getWeight()) : Float.valueOf(Float.sum(speciesTotalWeight.floatValue(),a.getWeight())) );
		}

		getValues();			

//		series1.getData().add( new XYChart.Data( step, chamoisTotalWeight ) );
//		series2.getData().add( new XYChart.Data( step, testBatsTotalWeight ) );
//		series3.getData().add( new XYChart.Data( step, insectEatingBatsTotalWeight ) );

		// Set every series
		for( XYChart.Series series : seriesList ) {
//			System.out.println( "CHART: series: " + series.getName() + " --- " + series.toString() );
			series.getData().add( new XYChart.Data( step, speciesTotalWeightMap.get( series.getName() ) ) );
		}

		step++; // = WildPark.getWildParkTimeHours();
	}
	
    





	public void getValues() {	
// 		for( Animal a : WildPark.getAnimals() ) {			
// 			if(a.getSPECIES_NAME() == "Chamois") {
// 				chamoisTotalWeight += a.getWeight();
// //				System.out.printf( "ChamoisTotalWeight: %.4f\r\n", chamoisTotalWeight );
// 			}			
// 			if(a.getSPECIES_NAME() == "TestBat") {
// 				testBatsTotalWeight += a.getWeight();
// //				System.out.printf( "testBatsTotalWeight: %.4f\r\n", testBatsTotalWeight );
// 			}
// 			if(a.getSPECIES_NAME() == "Insect Eating Bat") { 
// 				insectEatingBatsTotalWeight += a.getWeight();
// //				System.out.printf( "insectEatingBatsTotalWeight: %.4f\r\n", insectEatingBatsTotalWeight );
// 			}
// 			//System.out.println(" >>> "+insectEatingBatCount + ", " + horseCount+ ", " + giraffeCount);
// 		}

		if( step > 100 )
			lineChart.setCreateSymbols( false );	// Remove little circles from chart lines 
//			System.out.printf( "ANIMALS: 200\r\n" );

	}
	
	
}