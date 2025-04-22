
import garden_planner.model.CircleBed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleBedTest {

    @Test
    void testGetArea() {
        CircleBed cBed = new CircleBed();

        assertEquals(0.79, cBed.getArea(), 0.01);

        cBed.setWidth(2);
        assertEquals(3.14, cBed.getArea(), 0.01);
    }

    @Test
    void testGettersAndSetters() {
        CircleBed cBed = new CircleBed();
        cBed.setWidth(5.5);
        cBed.setTop(1.0);
        cBed.setLeft(3.5);

        assertEquals(5.5, cBed.getWidth());
        assertEquals(1.0, cBed.getTop());
        assertEquals(3.5, cBed.getLeft());
    }

    @Test
    void testCalcs() {
        CircleBed cBed = new CircleBed();
        cBed.setWidth(5.5);

        assertEquals(23.76, cBed.getArea(), 0.01);
        assertEquals(17.28, cBed.getPerimeter(), 0.01);
    }

    @Test void testToString() {
        CircleBed cbed = new CircleBed();
        assertEquals("Circle 0.00 0.00 1.00", cbed.toString());
    }
}
