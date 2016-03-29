package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lucas on 29/03/2016.
 */
public class TupleTest {
    @Test
    public void testControllerInitX() throws Exception {
        Tuple<Integer, Double> target = new Tuple<>(Integer.valueOf(0), Double.valueOf(2));
        assertEquals(Integer.valueOf(0), target.x);
    }
    
    @Test
    public void testControllerInitY() throws Exception {
        Tuple<Integer, Double> target = new Tuple<>(Integer.valueOf(0), Double.valueOf(2));
        assertEquals(Double.valueOf(2), target.y);
    }
}