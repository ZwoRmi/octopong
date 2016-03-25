package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BallToBallReboundCalculatorTest {
    private Ball ballOne;
    private Ball ballTwo;

    @Before
    public void setUp() {
        this.ballOne = this.getBall(new Position(10,0));
        this.ballTwo = this.getBall(new Position(-10,0));
    }

    @Test
    public void testUpdateDirectionsBallOne() throws Exception {
        Position expectedUpdatedDirection = new Position(-10,0);
        BallToBallReboundCalculator BallToBallRC = new BallToBallReboundCalculator(ballOne,ballTwo);
        BallToBallRC.updateDirections();
        assertEquals(expectedUpdatedDirection, ballOne.getDirection());
    }

    @Test
    public void testUpdateDirectionsBallTwo() throws Exception {
        Position expectedUpdatedDirection = new Position(10,0);
        BallToBallReboundCalculator BallToBallRC = new BallToBallReboundCalculator(ballOne,ballTwo);
        BallToBallRC.updateDirections();
        assertEquals(expectedUpdatedDirection, ballTwo.getDirection());
    }

    private Ball getBall(Position p) {
        Ball ballOne = new Ball();
        ballOne.setDirection(p);
        ballOne.setMass(1);
        return ballOne;
    }
}