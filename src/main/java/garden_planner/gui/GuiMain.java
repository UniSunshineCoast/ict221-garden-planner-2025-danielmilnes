package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.File;
import java.util.List;
import java.util.Scanner;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));

        // Set up garden
        List<String> args = getParameters().getRaw();   // Get args
        GardenPlanner planner = new GardenPlanner();    // Create planner object
        // This bit is copied from TextUI.java
        // First 2 args are soil and wall price
        if (args.size() >= 2) {
            planner.setSoilPrice(Double.parseDouble(args.get(0)));
            planner.setWallPrice(Double.parseDouble(args.get(1)));
        }
        // 3rd arg is the file to read
        if (args.size() == 3) {
            planner.readBeds(new Scanner(new File(args.get(2))));
        }
        // If no 3rd arg, use basic design
        else {
            planner.createBasicDesign();
        }

        // Set up scene
        primaryStage.setTitle("Garden");                        // Stage title
        Pane bedsPane = new Pane();                             // Create beds pane
        bedsPane.setStyle("-fx-background-color: #007700;");    // Set colour
        VBox textPane = new VBox();                             // Create text pane
        BorderPane rootPane = new BorderPane();                 // Create root pane
        rootPane.setCenter(bedsPane);                           // Put beds pane in root pane
        rootPane.setBottom(textPane);                           // Put text pane in root pane

        // Loop through garden beds and add them to panes
        int counter = 0;
        for (GardenBed bed: planner.getBeds()) {
            counter++;
            if (bed.getShapeType() == "Rectangle") {
                // Add rectangle representing garden bed to bedsPane
                Rectangle rect = new Rectangle();       // Create rectangle
                rect.setWidth(bed.getWidth() * 100);    // Set width
                rect.setHeight(bed.getHeight() * 100);  // Set height
                rect.setX(bed.getLeft() * 100);         // Set X
                rect.setY(bed.getTop() * 100);          // Set Y
                bedsPane.getChildren().add(rect);       // Add to bedsPane
            }
            if (bed.getShapeType() == "Circle") {
                // Add circle representing garden bed to bedsPane
                Circle circ = new Circle();            // Create circle
                circ.setRadius(bed.getWidth() * 50);   // Set radis (50 instead of 100 because radius = half width)
                circ.setCenterX(bed.getLeft() * 100 + bed.getWidth() * 50);  // Set X
                circ.setCenterY(bed.getTop() * 100 + bed.getWidth() * 50);   // Set y
                bedsPane.getChildren().add(circ);
            }

            // Add bed info
            Text bedInfoText = new Text();              // Create text node
            bedInfoText.setText(                        // Set bed info
                "Bed " + counter + "\t" + bed.getShapeType() + "\t\t"
                + "Top: " + String.format("%.2f", bed.getTop()) + "m\t\t"
                + "Left: " + String.format("%.2f", bed.getLeft()) + "m\t\t"
                + "Width: " + String.format("%.2f", bed.getWidth()) + "m\t\t"
                + "Height: " + String.format("%.2f", bed.getHeight()) + "m\t\t"
                + "Area: " + String.format("%.2f", bed.getArea()) + "m^2\t\t"
                + "Perimeter: " + String.format("%.2f", bed.getPerimeter()) + "m");
            textPane.getChildren().add(bedInfoText);    // Add to textPane
        }

        primaryStage.setScene(new Scene(rootPane, 800, 600));   // Add root pane to scene
        primaryStage.show();    // Show scene
    }


    public static void main(String[] args) {
        launch(args);
    }
}