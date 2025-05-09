
import garden_planner.model.RectBed;
import garden_planner.model.TriangleBed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleBedTest {

    @Test
    void testGetArea() {
        TriangleBed tBed = new TriangleBed();

        assertEquals(0.5, tBed.getArea());

        tBed.setWidth(2);
        tBed.setHeight(3);
        assertEquals(3, tBed.getArea());
    }

    @Test
    void testGettersAndSetters() {
        TriangleBed tBed = new TriangleBed();
        tBed.setHeight(7.0);
        tBed.setWidth(5.5);
        tBed.setTop(1.0);
        tBed.setLeft(3.5);

        assertEquals(7.0, tBed.getHeight());
        assertEquals(5.5, tBed.getWidth());
        assertEquals(1.0, tBed.getTop());
        assertEquals(3.5, tBed.getLeft());
        assertEquals("Triangle", tBed.getShapeType());
    }

    @Test
    void testCalcs() {
        TriangleBed tBed = new TriangleBed();
        tBed.setHeight(7.0);
        tBed.setWidth(5.5);

        assertEquals(19.25, tBed.getArea());
        assertEquals(21.4, tBed.getPerimeter(), 0.01);
    }

    @Test void testToString() {
        TriangleBed tBed = new TriangleBed();
        assertEquals("Triangle 0.00 0.00 1.00 1.00", tBed.toString());
    }
}