package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Controller {
    GardenPlanner planner = new GardenPlanner();

    @FXML
    private Pane bedsPane;
    @FXML
    private BorderPane rootPane;
    @FXML
    private Label shapeType_display;
    @FXML
    private TextField left_input;
    @FXML
    private TextField top_input;
    @FXML
    private TextField width_input;
    @FXML
    private TextField height_input;
    @FXML
    private Label area_display;
    @FXML
    private Label perimeter_display;
    @FXML
    private Label total_area_display;
    @FXML
    private Label total_perimeter_display;
    @FXML
    private Label total_soil_display;
    @FXML
    private Label total_cost_display;

    @FXML
    public void initialize() {

        planner.createBasicDesign();    // Set up basic design
        updateGUI();                    // Update GUI

        // PLACEHOLDER: edit first bed
        GardenBed selectedBed = planner.getBeds().getFirst();
        updateLabelsAndTextFields(selectedBed);

        // BIND EVENT HANDLERS
        left_input.textProperty().addListener(e -> {
            double leftValue = Double.parseDouble(left_input.getText());
            selectedBed.setLeft(leftValue);
            updateGUI();
            updateLabels(selectedBed);
        });
        top_input.textProperty().addListener(e -> {
            double topValue = Double.parseDouble(top_input.getText());
            selectedBed.setTop(topValue);
            updateGUI();
            updateLabels(selectedBed);
        });
        width_input.textProperty().addListener(e -> {
            double widthValue = Double.parseDouble(width_input.getText());
            selectedBed.setWidth(widthValue);
            updateGUI();
            updateLabels(selectedBed);
        });
        height_input.textProperty().addListener(e -> {
            double heightValue = Double.parseDouble(height_input.getText());
            selectedBed.setHeight(heightValue);
            updateGUI();
            updateLabels(selectedBed);
        });

    }

    /**
     * Refreshes the garden beds graphic in the GUI.
     */
    public void updateGUI() {
        bedsPane.getChildren().clear();
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
    }

    /**
     * Updates the text fields and labels in the GUI to have the info of the selected garden bed.
     * Use when a bed is selected.
     * @param bed The selected garden bed
     */
    public void updateLabelsAndTextFields(GardenBed bed) {
        left_input.setText(String.valueOf(bed.getLeft()));
        top_input.setText(String.valueOf(bed.getTop()));
        width_input.setText(String.valueOf(bed.getWidth()));
        height_input.setText(String.valueOf(bed.getHeight()));
        updateLabels(bed);
    }

    /**
     * Updates the labels in the GUI to have the info of the selected garden bed.
     * Use when a bed is edited.
     * @param bed The selected garden bed
     */
    public void updateLabels(GardenBed bed) {
        planner.recalculateTotals();
        shapeType_display.setText(bed.getShapeType());
        area_display.setText(String.valueOf(bed.getArea()));
        perimeter_display.setText(String.valueOf(bed.getPerimeter()));
        total_area_display.setText(String.format("Total garden area: %.2fm^2", planner.getTotalGardenArea()));
        total_perimeter_display.setText(String.format("Total wall length: %.2fm", planner.getTotalWallLength()));
        total_soil_display.setText(String.format(
                "Total soil required: %.2fm^3", planner.getTotalGardenArea() * planner.SOIL_DEPTH));
        total_cost_display.setText(String.format("Total garden cost: $%.2f", planner.getTotalCost()));
    }
}