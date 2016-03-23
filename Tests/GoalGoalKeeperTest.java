package Tests;

import Model.Goal;
import Model.GoalGoalKeeper;
import Model.GoalKeeper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lucas on 23/03/2016.
 */
public class GoalGoalKeeperTest {
    private GoalGoalKeeper goalGoalKeeper;

    @Before
    public void setUp() throws Exception {
        this.goalGoalKeeper = new GoalGoalKeeper();
    }

    @Test
    public void testGetGoal() throws Exception {
        GoalKeeper expected = new GoalKeeper();
        this.goalGoalKeeper.setGoalKeeper(expected);
        Assert.assertEquals(expected,goalGoalKeeper.getGoalKeeper());
    }

    @Test
    public void testGetGoalKeeper() throws Exception {
        Goal expected = new Goal();
        this.goalGoalKeeper.setGoal(expected);
        Assert.assertEquals(expected,goalGoalKeeper.getGoal());
    }
}