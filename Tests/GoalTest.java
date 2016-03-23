package Tests;

import Model.Goal;
import Model.Line;
import Model.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lucas on 23/03/2016.
 */
public class GoalTest {
    private Goal goal;

    @Before
    public void setUp() throws Exception {
        this.goal = new Goal();
    }

    @Test
    public void testGetGoalStartLine() throws Exception {
        Line line = new Line(new Position(3,5), new Position(9,0));
        this.goal.setGoalStartLine(line);
        Assert.assertEquals(line,this.goal.getGoalStartLine());
    }

    @Test
    public void testGetGoalEndLine() throws Exception {
        Line line = new Line(new Position(3,987), new Position(9,230));
        this.goal.setGoalEndLine(line);
        Assert.assertEquals(line,this.goal.getGoalEndLine());
    }

    @Test
    public void testGetDetectionLine() throws Exception {
        Line line = new Line(new Position(3,987), new Position(9,230));
        this.goal.setDetectionLine(line);
        Assert.assertEquals(line,this.goal.getDetectionLine());
    }
}