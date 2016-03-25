package Model;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class ReboundCalculatorTest {

    @Test
    public void testGetNewDirectionNorth() throws Exception {
        Position expectedPosition = new Position(10,-10);
        Ball ball = this.getBall(new Position(10,10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.North);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        Position actualPosition = rCalculator.getNewDirection();
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetNewDirectionSouth() throws Exception {
        Position expectedPosition = new Position(10,-5);
        Ball ball = this.getBall(new Position(10,5));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.South);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        Position actualPosition = rCalculator.getNewDirection();
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetNewDirectionEast() throws Exception {
        Position expectedPosition = new Position(13,-10);
        Ball ball = this.getBall(new Position(-13,-10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.East);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        Position actualPosition = rCalculator.getNewDirection();
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetNewDirectionWest() throws Exception {
        Position expectedPosition = new Position(-12,-10);
        Ball ball = this.getBall(new Position(12,-10));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.West);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        Position actualPosition = rCalculator.getNewDirection();
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetNewDirectionNorthEast() throws Exception {
        Position expectedPosition = new Position(1,6);
        Ball ball = this.getBall(new Position(6,1));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.NorthEast);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        Position actualPosition = rCalculator.getNewDirection();
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetNewDirectionNorthWest() throws Exception {
        Position expectedPosition = new Position(2,-8);
        Ball ball = this.getBall(new Position(8,-2));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.NorthWest);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        Position actualPosition = rCalculator.getNewDirection();
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetNewDirectionSouthEast() throws Exception {
        Position expectedPosition = new Position(4,-9);
        Ball ball = this.getBall(new Position(9,-4));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.SouthEast);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        Position actualPosition = rCalculator.getNewDirection();
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetNewDirectionSouthWest() throws Exception {
        Position expectedPosition = new Position(2,3);
        Ball ball = this.getBall(new Position(3,2));
        GoalKeeper goalKeeper = this.getGoalKeeper(GoalPosition.SouthWest);
        ReboundCalculator rCalculator = new ReboundCalculator(ball,goalKeeper);
        Position actualPosition = rCalculator.getNewDirection();
        assertEquals(expectedPosition,actualPosition);
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