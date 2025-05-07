package garden_planner.model;

/**
 * Represents a rectangular shape garden.
 *
 * @author Daniel Milnes
 */
public class CircleBed extends GardenBed {
    private double width = 1.0;
    private String shapeType = "Circle";

    public CircleBed() {}

    /**
     * Total width of this circle.
     *
     * @return width in metres.
     */
    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Total height of this circle.
     *
     * @return height in metres.
     */
    @Override
    public double getHeight() {
        return getWidth();
    }

    @Override
    public void setHeight(double height) {
        this.width = height;
    }

    /**
     * Get the area of this circle.
     *
     * @return the total internal area of the circle.
     */
    @Override
    public double getArea() {
        double r = width / 2;
        return (Math.PI * r * r);
    }

    @Override
    public double getPerimeter() {
        double r = width / 2;
        return (Math.PI * r * 2);
    }

    @Override
    public String toString() {
        return String.format("Circle %.2f %.2f %.2f", left, top, width);
    }

    @Override
    public String getShapeType() {
        return shapeType;
    }
}