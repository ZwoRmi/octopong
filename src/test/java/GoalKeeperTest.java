import Model.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lucas on 23/03/2016.
 */
public class GoalKeeperTest {
    private GoalKeeper goalKeeper;

    @Before
    public void setUp() throws Exception {
        this.goalKeeper = new GoalKeeper();
    }

    @Test
    public void testGetGoalPosition() throws Exception {
        GoalPosition expected = GoalPosition.NorthWest;
        this.goalKeeper.setGoalPosition(expected);
        assertEquals(expected, this.goalKeeper.getGoalPosition());
    }

    @Test
    public void testGetSpeed() throws Exception {
        int expected = 5;
        this.goalKeeper.setSpeed(expected);
        assertEquals(expected, this.goalKeeper.getSpeed(), 0.0000001);
    }

    @Test
    public void testGetScore() throws Exception {
        Score score = new Score();
        score.setScore(5);
        this.goalKeeper.setScore(score);
        assertEquals(score, this.goalKeeper.getScore());
    }

    @Test
    public void testGetActualPositionStart() throws Exception {
        Line expected = new Line(new Position(5, 6), new Position(8, 6));
        this.goalKeeper.setActualPositionStart(expected);
        assertEquals(expected, this.goalKeeper.getActualPositionStart());
    }

    @Test
    public void testGetActualPositionEnd() throws Exception {
        Line expected = new Line(new Position(15, 16), new Position(18, 16));
        this.goalKeeper.setActualPositionEnd(expected);
        assertEquals(expected, this.goalKeeper.getActualPositionEnd());
    }

    @Test
    public void testGetTargetPosition() throws Exception {
        Line expected = new Line(new Position(150, 106), new Position(28, 36));
        this.goalKeeper.setTargetPosition(expected);
        assertEquals(expected, this.goalKeeper.getTargetPosition());
    }

    @Test
    public void testGetColor() throws Exception {
        Paint expected = Color.BLUE;
        this.goalKeeper.setColor(expected);
        assertEquals(expected, this.goalKeeper.getColor());
    }

    @Test
    public void testGetPlayedByHuman() throws Exception {
        boolean expected = true;
        this.goalKeeper.setPlayedByHuman(expected);
        assertEquals(expected, this.goalKeeper.getPlayedByHuman());
    }
}