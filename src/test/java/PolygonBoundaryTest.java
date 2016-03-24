import Model.Line;
import Model.PolygonBoundary;
import Model.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 23/03/2016.
 */
public class PolygonBoundaryTest {

    @Test
    public void testContainsForTrue() throws Exception {
        Line startLine = new Line(new Position(0,0),new Position(0,10));
        Line endLine =   new Line(new Position(10,0),new Position(10,10));
        Position pos = new Position(5,5);
        PolygonBoundary polygonBoundary = new PolygonBoundary(startLine,endLine);
        assertTrue(polygonBoundary.contains(pos));
    }

    @Test
    public void testContainsForFalse() throws Exception {
        Line startLine = new Line(new Position(0,0),new Position(0,10));
        Line endLine =   new Line(new Position(10,0),new Position(10,10));
        Position pos = new Position(15,5);
        PolygonBoundary polygonBoundary = new PolygonBoundary(startLine,endLine);
        assertFalse(polygonBoundary.contains(pos));
    }
}