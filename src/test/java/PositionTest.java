import Model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 23/03/2016.
 */
public class PositionTest {
    private Position position;

    @Before
    public void setUp() throws Exception {
        this.position = new Position();
    }

    @Test
    public void testGetX() throws Exception {
        float expected = 5;
        this.position.setX(expected);
        assertEquals(expected, this.position.getX(), 0.0000000001);
    }

    @Test
    public void testGetY() throws Exception {
        float expected = 5;
        this.position.setY(expected);
        assertEquals(expected, this.position.getY(), 0.0000000001);
    }

    @Test
    public void testEqualsForNormalTrue() throws Exception {
        Position line = new Position(1,1);
        Position otherLine = new Position(1,1);
        assertTrue(line.equals(otherLine));
    }

    @Test
    public void testEqualsForNormalFalse() throws Exception {
        Position line = new Position(1,1);
        Position otherLine = new Position(5,0);
        assertFalse(line.equals(otherLine));
    }

    @Test
    public void testEqualsForSameReference() throws Exception {
        Position line = new Position(0,0);
        //noinspection EqualsWithItself
        assertTrue(line.equals(line));
    }

    @Test
    public void testEqualsForNull() throws Exception {
        Position line = new Position(0,0);
        //noinspection ObjectEqualsNull
        assertFalse(line.equals(null));
    }

    @Test
    public void testEqualsForOtherType() throws Exception {
        Position line = new Position(1,1);
        assertFalse(line.equals(new Object()));
    }
}