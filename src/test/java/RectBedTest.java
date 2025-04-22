
import garden_planner.model.RectBed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectBedTest {

    @Test
    void testGetArea() {
        RectBed rBed = new RectBed();

        assertEquals(1, rBed.getArea());

        rBed.setWidth(2);
        rBed.setHeight(3);
        assertEquals(6, rBed.getArea());
    }

    @Test
    void testGettersAndSetters() {
        RectBed rBed = new RectBed();
        rBed.setHeight(7.0);
        rBed.setWidth(5.5);
        rBed.setTop(1.0);
        rBed.setLeft(3.5);

        assertEquals(7.0, rBed.getHeight());
        assertEquals(5.5, rBed.getWidth());
        assertEquals(1.0, rBed.getTop());
        assertEquals(3.5, rBed.getLeft());
    }

    @Test
    void testCalcs() {
        RectBed rBed = new RectBed();
        rBed.setHeight(7.0);
        rBed.setWidth(5.5);

        assertEquals(38.5, rBed.getArea());
        assertEquals(25.0, rBed.getPerimeter());
    }

    @Test void testToString() {
        RectBed rbed = new RectBed();
        assertEquals("Rectangle 0.00 0.00 1.00 1.00", rbed.toString());
    }
}
