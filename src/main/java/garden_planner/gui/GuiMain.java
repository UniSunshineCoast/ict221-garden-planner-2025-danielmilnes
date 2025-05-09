package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootPane = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));   // Load rootPane

        // Code I might need later

        /* CODE TO SET UP GARDEN WITHOUT CONTROLLER.JAVA
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
        */


        /* CODE TO SET UP SCENE WITHOUT CONTROLLER.JAVA
        primaryStage.setTitle("Garden");    // Stage title
        BorderPane rootPane = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));   // Load rootPane
        Pane bedsPane = (Pane) rootPane.getCenter();        // Create ref to bedsPane
        GridPane menuPane = (GridPane) rootPane.getLeft();  // Create ref to menuPane
        */


        /* CODE TO ADD BEDS WITHOUT CONTROLLER.JAVA
        // Loop through garden beds and add them to panes
        for (GardenBed bed: planner.getBeds()) {
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
        }
        */


        // DISPLAY SCENE
        primaryStage.setScene(new Scene(rootPane, 1000, 600));   // Add root pane to scene
        primaryStage.show();    // Show scene
    }


    public static void main(String[] args) {
        launch(args);
    }
}