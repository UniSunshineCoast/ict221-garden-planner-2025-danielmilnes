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

        // DISPLAY SCENE
        primaryStage.setScene(new Scene(rootPane, 1000, 600));   // Add root pane to scene
        primaryStage.show();    // Show scene
    }


    public static void main(String[] args) {
        launch(args);
    }
}