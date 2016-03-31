package Controller;

import Model.Ball;
import Model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BallWithTargetPositionTest {
    private BallWithTargetPosition ballWithTargetPosition;

    @Before
    public void setUp() {
        this.ballWithTargetPosition = new BallWithTargetPosition();
    }

    @Test
    public void testGetBall() throws Exception {
        Ball expected = new Ball();
        this.ballWithTargetPosition.setBall(expected);
        assertEquals(expected, ballWithTargetPosition.getBall());
    }

    @Test
    public void testGetTargetPosition() throws Exception {
        Position expected = new Position(5, 4);
        this.ballWithTargetPosition.setTargetPosition(expected);
        assertEquals(expected, this.ballWithTargetPosition.getTargetPosition());
    }

    @Test
    public void testGetCountToGoToTargetPosition() throws Exception {
        int expected = 567;
        this.ballWithTargetPosition.setCountToGoToTargetPosition(expected);
        assertEquals(expected, this.ballWithTargetPosition.getCountToGoToTargetPosition());
    }
}