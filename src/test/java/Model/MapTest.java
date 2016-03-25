package Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("RedundantThrows")
public class MapTest {
    private IMap IMap;

    @Before
    public void setUp() {
        this.IMap = new Map(null);
    }

    @Test
    public void testGetBallSpeed() throws Exception {
        int expected = 5;
        this.IMap.setBallSpeed(expected);
        assertEquals(expected, this.IMap.getBallSpeed(), 0.00000001);
    }

    @Test
    public void testGetBallSpawnInterval() throws Exception {
        int expected = 8;
        this.IMap.setBallSpawnInterval(expected);
        assertEquals(expected, this.IMap.getBallSpawnInterval(), 0.00000001);
    }

    @Test
    public void testGetBalls() throws Exception {
        List<Ball> expected = new ArrayList<>();
        expected.add(new Ball());
        IMap aIMap = new Map(expected);
        assertEquals(expected, aIMap.getBalls());
    }

    @Test
    public void testGetGoalsGoalKeepers() throws Exception {
        List<GoalGoalKeeper> expected = new ArrayList<>();
        expected.add(new GoalGoalKeeper());
        this.IMap.setGoalsGoalKeepers(expected);
        assertEquals(expected, this.IMap.getGoalsGoalKeepers());
    }
}