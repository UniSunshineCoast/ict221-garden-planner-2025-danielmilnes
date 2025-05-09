package garden_planner.model;

/**
 * Represents a rectangular shapeType garden.
 *
 * @author Mark Utting
 */
public class RectBed extends GardenBed {
    private double width = 1.0;
    private double height = 1.0;
    private String shapeType = "Rectangle";

    public RectBed() {}
    /**
     * Total width of this rectangle.
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
     * Total height of this rectangle.
     *
     * @return height in metres.
     */
    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get the area of this rectangle.
     *
     * @return the total internal area of the rectangle.
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * Get the perimeter of this rectangle.
     *
     * @return the total length of the edges of the rectangle.
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Rectangle %.2f %.2f %.2f %.2f", left, top, width, height);
    }

    @Override
    public String getShapeType() {
        return shapeType;
    }
}

