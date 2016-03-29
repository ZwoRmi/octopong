package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TupleTest {
    @Test
    public void testControllerInitX() throws Exception {
        Tuple<Integer, Double> target = new Tuple<>(0, 2d);
        assertEquals(Integer.valueOf(0), target.x);
    }

    @Test
    public void testControllerInitY() throws Exception {
        Tuple<Integer, Double> target = new Tuple<>(0, 2d);
        assertEquals(Double.valueOf(2), target.y);
    }
}