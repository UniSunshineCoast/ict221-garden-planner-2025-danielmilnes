package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));

        // Set up garden
        GardenPlanner planner = new GardenPlanner();
        planner.createBasicDesign();

        // Set up scene
        primaryStage.setTitle("Garden");                    // Stage title
        Pane pane = new Pane();                             // Create pane
        pane.setStyle("-fx-background-color: #007700;");    // Set colour

        // Loop through garden beds
        for (GardenBed bed: planner.getBeds()) {
            // Add rectangle representing garden bed to pane
            Rectangle rect = new Rectangle();       // Create rectangle
            rect.setWidth(bed.getWidth()*100);      // Set width
            rect.setHeight(bed.getHeight()*100);    // Set height
            rect.setX(bed.getLeft()*100);           // Set X
            rect.setY(bed.getTop()*100);            // Set Y
            pane.getChildren().add(rect);           // Add to pane
        }

        primaryStage.setScene(new Scene(pane, 800, 600));   // Add pane to scene
        primaryStage.show();    // Show scene
    }


    public static void main(String[] args) {
        launch(args);
    }
}