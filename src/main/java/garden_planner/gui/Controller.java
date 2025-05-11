package garden_planner.gui;

import garden_planner.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import static java.lang.Math.floor;

public class Controller {
    GardenPlanner planner = new GardenPlanner();
    GardenBed selectedBed;

    @FXML private Pane bedsPane;
    @FXML private BorderPane rootPane;
    @FXML private Label shapeType_display;
    @FXML private TextField left_input;
    @FXML private TextField top_input;
    @FXML private TextField width_input;
    @FXML private TextField height_input;
    @FXML private Label area_display;
    @FXML private Label perimeter_display;
    @FXML private Label total_area_display;
    @FXML private Label total_perimeter_display;
    @FXML private Label total_soil_display;
    @FXML private Label total_cost_display;
    @FXML private Label addRect_button;
    @FXML private Label addCircle_button;
    @FXML private Label addTriangle_button;

    @FXML
    public void initialize() {

        planner.createBasicDesign();    // Set up basic design
        updateGUI();                    // Update GUI
        setSelectedBed(planner.getBeds().getFirst());   // Select first bed

        // SET STYLE
        bedsPane.setStyle("-fx-background-color: #007700; -fx-background-image: url(\"grass4.png\")");

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

        addRect_button.setOnMouseClicked(e -> {
            RectBed rect = new RectBed();
            planner.getBeds().add(rect);
            setSelectedBed(rect);
            updateGUI();
        });
        addCircle_button.setOnMouseClicked(e -> {
            CircleBed circ = new CircleBed();
            planner.getBeds().add(circ);
            setSelectedBed(circ);
            updateGUI();
        });
        addTriangle_button.setOnMouseClicked(e -> {
            TriangleBed tri = new TriangleBed();
            planner.getBeds().add(tri);
            setSelectedBed(tri);
            updateGUI();
        });
    }

    /**
     * Refreshes the garden beds graphic in the GUI.
     */
    public void updateGUI() {
        bedsPane.getChildren().clear();
        for (GardenBed bed: planner.getBeds()) {
            if (bed.getShapeType().equals("Rectangle")) {
                // Add rectangle representing garden bed to bedsPane
                Rectangle rect = new Rectangle();       // Create rectangle
                rect.setWidth(bed.getWidth() * 100);    // Set width
                rect.setHeight(bed.getHeight() * 100);  // Set height
                rect.setX(bed.getLeft() * 100);         // Set X
                rect.setY(bed.getTop() * 100);          // Set Y
                rect.setOnMouseReleased(e -> {setSelectedBed(bed);}); // Set event to select bed on click
                bedsPane.getChildren().add(rect);       // Add to bedsPane

                // Click-drag event
                rect.setOnMouseDragged(ev -> {
                    rect.setX(floor(ev.getX() / 50) * 50);  // set shape X
                    rect.setY(floor(ev.getY() / 50) * 50);  // set shape Y
                    bed.setLeft(floor(ev.getX() / 100 * 2) / 2); // set gardenbed X
                    bed.setTop(floor(ev.getY() / 100 * 2) / 2 ); // set gardenbed Y
                });
            }
            if (bed.getShapeType().equals("Circle")) {
                // Add circle representing garden bed to bedsPane
                Circle circ = new Circle();                                 // Create circle
                circ.setRadius(bed.getWidth() * 50);                        // Set radius (radius = half width)
                circ.setCenterX(bed.getLeft() * 100 + bed.getWidth() * 50); // Set X
                circ.setCenterY(bed.getTop() * 100 + bed.getHeight() * 50); // Set y
                circ.setOnMouseReleased(e -> {setSelectedBed(bed);}); // Set event to select bed on click or drag
                bedsPane.getChildren().add(circ);       // Add to bedsPane

                // Click-drag event
                circ.setOnMouseDragged(ev -> {
                    circ.setCenterX(floor((ev.getX() + bed.getWidth()*50) / 50) * 50);  // set shape x
                    circ.setCenterY(floor((ev.getY() + bed.getHeight()*50) / 50) * 50); // set shape y
                    bed.setLeft(floor(ev.getX() / 100 * 2) / 2); // set gardenbed X
                    bed.setTop(floor(ev.getY() / 100 * 2) / 2 ); // set gardenbed Y
                });
            }
            if (bed.getShapeType().equals("Triangle")) {// Add triangle representing garden bed to bedsPane
                Polygon tri = new Polygon();            // Create polygon
                tri.getPoints().addAll(new Double[] {   // Set corners
                        bed.getLeft()*100,                      bed.getTop()*100,
                        bed.getLeft()*100,                      bed.getTop()*100 + bed.getHeight()*100,
                        bed.getLeft()*100 + bed.getWidth()*100, bed.getTop()*100 + bed.getHeight()*100,
                });
                tri.setOnMouseReleased(e -> {setSelectedBed(bed);}); // Set event to select bed on click or drag
                bedsPane.getChildren().add(tri);        // Add to bedsPane

                // Click-drag event
                tri.setOnMouseDragged(ev -> {
                    tri.getPoints().clear();
                    double x1 = ev.getX();                        // x for corner 1
                    double x2 = ev.getX();                        // x for corner 2
                    double x3 = ev.getX() + bed.getWidth()*100;   // x for corner 3
                    double y1 = ev.getY();                        // y for corner 1
                    double y2 = ev.getY() + bed.getHeight()*100;  // y for corner 2
                    double y3 = ev.getY() + bed.getHeight()*100;  // y for corner 3
                    tri.getPoints().addAll(new Double[] {   // set shape corners
                            floor(x1/50)*50,    floor(y1/50)*50,
                            floor(x2/50)*50,    floor(y2/50)*50,
                            floor(x3/50)*50,    floor(y3/50)*50,
                    });
                    bed.setLeft(floor(ev.getX() / 100 * 2) / 2); // set gardenbed X
                    bed.setTop(floor(ev.getY() / 100 * 2) / 2 ); // set gardenbed Y
                });
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
        area_display.setText(String.format("%.2f", bed.getArea()));
        perimeter_display.setText(String.format("%.2f", bed.getPerimeter()));
        total_area_display.setText(String.format("Total garden area: %.2fm^2", planner.getTotalGardenArea()));
        total_perimeter_display.setText(String.format("Total wall length: %.2fm", planner.getTotalWallLength()));
        total_soil_display.setText(String.format(
                "Total soil required: %.2fm^3", planner.getTotalGardenArea() * planner.SOIL_DEPTH));
        total_cost_display.setText(String.format("Total garden cost: $%.2f", planner.getTotalCost()));
    }

    /**
     * Sets selectedBed variable and updates GUI.
     * @param bed The bed to be selected
     */
    public void setSelectedBed(GardenBed bed) {
        selectedBed = bed;
        updateLabelsAndTextFields(bed);
    }
}