package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        primaryStage.setTitle("Garden");                        // Stage title
        Pane bedsPane = new Pane();                             // Create beds pane
        bedsPane.setStyle("-fx-background-color: #007700;");    // Set colour
        VBox textPane = new VBox();                             // Create text pane
        BorderPane rootPane = new BorderPane();                 // Create root pane
        rootPane.setCenter(bedsPane);                           // Put beds pane in root pane
        rootPane.setBottom(textPane);                           // Put text pane in root pane

        // Loop through garden beds
        int counter = 0;
        for (GardenBed bed: planner.getBeds()) {
            counter++;
            // Add rectangle representing garden bed to bedsPane
            Rectangle rect = new Rectangle();       // Create rectangle
            rect.setWidth(bed.getWidth()*100);      // Set width
            rect.setHeight(bed.getHeight()*100);    // Set height
            rect.setX(bed.getLeft()*100);           // Set X
            rect.setY(bed.getTop()*100);            // Set Y
            bedsPane.getChildren().add(rect);       // Add to bedsPane

            // Add bed info
            Text bedInfoText = new Text();            // Create text node
            bedInfoText.setText(
                    "Bed " + counter + "\tWidth: " + bed.getWidth() + "m\tHeight: " + bed.getHeight() +
                    "m\tArea: " + bed.getArea() + "m^2\tPerimeter: " + bed.getPerimeter() + "m");
            textPane.getChildren().add(bedInfoText);
        }

        primaryStage.setScene(new Scene(rootPane, 800, 600));   // Add root pane to scene
        primaryStage.show();    // Show scene
    }


    public static void main(String[] args) {
        launch(args);
    }
}