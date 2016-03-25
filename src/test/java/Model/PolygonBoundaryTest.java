package Model;

import javafx.scene.shape.Polygon;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonBoundaryTest {

    @Test
    public void testGetPolygon() throws Exception {
        Line startLine = new Line(new Position(0,0),new Position(0,10));
        Line endLine =   new Line(new Position(10,0),new Position(10,10));
        PolygonBoundary polygonBoundary = new PolygonBoundary(startLine,endLine);
        Polygon polygon = this.getPolygon();
        assertEquals(polygon.getPoints(), polygonBoundary.getPolygon().getPoints());
    }

    private Polygon getPolygon() {
        return new Polygon(0,10,10,10,10,0,0,0);
    }

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