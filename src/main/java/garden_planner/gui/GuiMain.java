package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
        Pane pane = new HBox();                             // Create pane
        pane.setStyle("-fx-background-color: #007700;");    // Set colour

        // Loop through garden beds
        for (RectBed bed: planner.getBeds()) {
            // Add rectangle representing garden bed to pane
            pane.getChildren().add(
                    new Rectangle(bed.getWidth()*100, bed.getHeight()*100)
            );
            // Add padding
            pane.getChildren().add(new Rectangle(50, 1)); // i got 99 problems but a syntax error aint one
        }

        primaryStage.setScene(new Scene(pane, 800, 600));   // Add pane to scene
        primaryStage.show();    // Show scene
    }


    public static void main(String[] args) {
        launch(args);
    }
}