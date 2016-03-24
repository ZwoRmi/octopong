import Model.Line;
import Model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 23/03/2016.
 */
public class LineTest {
    private Line line;

    @Before
    public void setUp() throws Exception {
        this.line = new Line();
    }

    @Test
    public void testGetStartPosition() throws Exception {
        Position expected = new Position(34,56);
        this.line.setStartPosition(expected);
        assertEquals(expected, this.line.getStartPosition());
    }

    @Test
    public void testGetEndPosition() throws Exception {
        Position expected = new Position(73,12);
        this.line.setEndPosition(expected);
        assertEquals(expected, this.line.getEndPosition());
    }

    @Test
    public void testEqualsForNormalTrue() throws Exception {
        Line line = new Line(new Position(0,0),new Position(1,1));
        Line otherLine = new Line(new Position(0,0),new Position(1,1));
        assertTrue(line.equals(otherLine));
    }

    @Test
    public void testEqualsForNormalTrueNullStartPosition() throws Exception {
        Line line = new Line(null,new Position(1,1));
        Line otherLine = new Line(null,new Position(1,1));
        assertTrue(line.equals(otherLine));
    }

    @Test
    public void testEqualsForNormalTrueNullEndPosition() throws Exception {
        Line line = new Line(null,null);
        Line otherLine = new Line(null,null);
        assertTrue(line.equals(otherLine));
    }

    @Test
    public void testEqualsForNormalFalse() throws Exception {
        Line line = new Line(new Position(0,0),new Position(1,1));
        Line otherLine = new Line(new Position(5,0),new Position(5,1));
        assertFalse(line.equals(otherLine));
    }

    @Test
    public void testEqualsForSameReference() throws Exception {
        Line line = new Line(new Position(0,0),new Position(1,1));
        //noinspection EqualsWithItself
        assertTrue(line.equals(line));
    }

    @Test
    public void testEqualsForNull() throws Exception {
        Line line = new Line(new Position(0,0),new Position(1,1));
        //noinspection ObjectEqualsNull
        assertFalse(line.equals(null));
    }

    @Test
    public void testEqualsForOtherType() throws Exception {
        Line line = new Line(new Position(0,0),new Position(1,1));
        assertFalse(line.equals(new Object()));
    }

    @Test
    public void testSameHashCode() throws Exception {
        Line lineOne = new Line(new Position(0,0),new Position(1,1));
        Line lineTwo = new Line(new Position(0,0),new Position(1,1));
        assertEquals(lineOne.hashCode(),lineTwo.hashCode());
    }

    @Test
    public void testDifferentHashCode() throws Exception {
        Line lineOne = new Line(new Position(0,0),new Position(1,1));
        Line lineTwo = new Line(new Position(0,0),new Position(2,1));
        assertFalse(lineOne.hashCode() == lineTwo.hashCode());
    }
}