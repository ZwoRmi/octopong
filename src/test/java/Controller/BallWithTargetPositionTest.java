package Controller;

import Model.Ball;
import Model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BallWithTargetPositionTest {
    private BallWithTargetPosition ballWithargetPosition;

    @Before
    public void setUp() throws Exception {
        this.ballWithargetPosition = new BallWithTargetPosition();
    }

    @Test
    public void testGetBall() throws Exception {
        Ball expected = new Ball();
        this.ballWithargetPosition.setBall(expected);
        assertEquals(expected, ballWithargetPosition.getBall());
    }

    @Test
    public void testGetTargetPosition() throws Exception {
        Position expected = new Position(5, 4);
        this.ballWithargetPosition.setTargetPosition(expected);
        assertEquals(expected, this.ballWithargetPosition.getTargetPosition());
    }

    @Test
    public void testGetCountToGoToTargetPosition() throws Exception {
        int expected = 567;
        this.ballWithargetPosition.setCountToGoToTargetPosition(expected);
        assertEquals(expected, this.ballWithargetPosition.getCountToGoToTargetPosition());
    }
}