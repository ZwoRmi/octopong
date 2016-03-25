package Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("RedundantThrows")
public class GoalGoalKeeperTest {
    private GoalGoalKeeper goalGoalKeeper;

    @Before
    public void setUp() {
        this.goalGoalKeeper = new GoalGoalKeeper();
    }

    @Test
    public void testGetGoal() throws Exception {
        GoalKeeper expected = new GoalKeeper();
        this.goalGoalKeeper.setGoalKeeper(expected);
        Assert.assertEquals(expected, this.goalGoalKeeper.getGoalKeeper());
    }

    @Test
    public void testGetGoalKeeper() throws Exception {
        Goal expected = new Goal();
        this.goalGoalKeeper.setGoal(expected);
        Assert.assertEquals(expected, this.goalGoalKeeper.getGoal());
    }
}