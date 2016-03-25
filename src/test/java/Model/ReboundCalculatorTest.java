package Model;

import org.junit.Ignore;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.*;

public class ReboundCalculatorTest {

    @Ignore
    @Test
    public void testGetNewDirection() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    public void testIsMovingToGoalKeeperNorth() throws Exception {
        Ball ball = this.getBall(new Position(10,-10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.North);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertTrue(value);
    }

    @Test
    public void testIsMovingToGoalKeeperNorthEast() throws Exception {
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.NorthEast);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertTrue(value);
    }

    @Test
    public void testIsMovingToGoalKeeperEast() throws Exception {
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.East);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertTrue(value);
    }

    @Test
    public void testIsMovingToGoalKeeperSouthEast() throws Exception {
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.SouthEast);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertTrue(value);
    }

    @Test
    public void testIsMovingToGoalKeeperSouth() throws Exception {
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.South);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertTrue(value);
    }

    @Test
    public void testIsMovingToGoalKeeperSouthWest() throws Exception {
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.SouthWest);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertTrue(value);
    }

    @Test
    public void testIsMovingToGoalKeeperWest() throws Exception {
        Ball ball = this.getBall(new Position(-10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.West);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertTrue(value);
    }

    @Test
    public void testIsMovingToGoalKeeperNorthWest() throws Exception {
        Ball ball = this.getBall(new Position(-10,-10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.NorthWest);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertTrue(value);
    }

    @Test
    public void testIsMovingToGoalKeeperNorthFalse() throws Exception {
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.North);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertFalse(value);
    }

    @Test
    public void testIsMovingToGoalKeeperNorthEastFalse() throws Exception {
        Ball ball = this.getBall(new Position(-10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.NorthEast);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertFalse(value);
    }

    @Test
    public void testIsMovingToGoalKeeperEastFalse() throws Exception {
        Ball ball = this.getBall(new Position(-10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.East);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertFalse(value);
    }

    @Test
    public void testIsMovingToGoalKeeperSouthEastFalse() throws Exception {
        Ball ball = this.getBall(new Position(-10,-10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.SouthEast);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertFalse(value);
    }

    @Test
    public void testIsMovingToGoalKeeperSouthFalse() throws Exception {
        Ball ball = this.getBall(new Position(10,-10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.South);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertFalse(value);
    }

    @Test
    public void testIsMovingToGoalKeeperSouthWestFalse() throws Exception {
        Ball ball = this.getBall(new Position(10,-10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.SouthWest);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertFalse(value);
    }

    @Test
    public void testIsMovingToGoalKeeperWestFalse() throws Exception {
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.West);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertFalse(value);
    }

    @Test
    public void testIsMovingToGoalKeeperNorthWestFalse() throws Exception {
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.NorthWest);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        boolean value = rCalculator.isMovingToGoalKeeper();
        assertFalse(value);
    }

    private Ball getBall(Position p) {
        Ball ball = new Ball();
        ball.setDirection(p);
        ball.setMass(1);
        return ball;
    }

    private GoalKeeper getGoalKeeper(GoalPosition gp) {
        GoalKeeper goalKeeper = new GoalKeeper();
        goalKeeper.setGoalPosition(gp);
        return goalKeeper;
    }
}