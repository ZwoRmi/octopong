package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("RedundantThrows")
public class PositionTest {
    private Position position;

    @Before
    public void setUp() {
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
        Position position = new Position(1,1);
        Position otherPosition = new Position(1,1);
        assertTrue(position.equals(otherPosition));
    }

    @Test
    public void testEqualsForNormalFalse() throws Exception {
        Position line = new Position(1,1);
        Position otherPosition = new Position(5,0);
        assertFalse(line.equals(otherPosition));
    }

    @Test
    public void testEqualsForSameReference() throws Exception {
        Position line = new Position(0,0);
        //noinspection EqualsWithItself
        assertTrue(line.equals(line));
    }

    @Test
    public void testEqualsForNull() throws Exception {
        Position position = new Position(0,0);
        //noinspection ObjectEqualsNull
        assertFalse(position.equals(null));
    }

    @Test
    public void testEqualsForOtherType() throws Exception {
        Position position = new Position(1,1);
        assertFalse(position.equals(new Object()));
    }
}