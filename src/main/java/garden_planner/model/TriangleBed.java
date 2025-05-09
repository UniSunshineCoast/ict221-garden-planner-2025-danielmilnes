package garden_planner.model;

/**
 * Represents a triangular garden.
 * @author Daniel Milnes
 */
public class TriangleBed extends GardenBed {
    private double width = 1.0;
    private double height = 1.0;
    private String shapeType = "Triangle";

    public TriangleBed() {}

    /**
     * Total width of this triangle.
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
     * Total height of this triangle.
     * @return height in metres
     */
    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get the area of this triangle.
     * @return the area of the triangle in square metres
     */
    @Override
    public double getArea() {
        return width * height / 2;
    }

    /**
     * Get the perimeter of this triangle.
     * @return the perimeter of the triangle in metres
     */
    @Override
    public double getPerimeter() {
        double cSquared = width*width + height*height;
        return width + height + Math.sqrt(cSquared);
    }

    @Override
    public String toString() {return String.format("Triangle %.2f %.2f %.2f %.2f", left, top, width, height);}

    @Override
    public String getShapeType() {
        return "Triangle";
    }
}