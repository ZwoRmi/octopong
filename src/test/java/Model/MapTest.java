package Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("RedundantThrows")
public class MapTest {
    private Map map;

    @Before
    public void setUp() {
        this.map = new Map(null);
    }

    @Test
    public void testGetBallSpeed() throws Exception {
        int expected = 5;
        this.map.setBallSpeed(expected);
        assertEquals(expected, this.map.getBallSpeed(), 0.00000001);
    }

    @Test
    public void testGetBallSpawnInterval() throws Exception {
        int expected = 8;
        this.map.setBallSpawnInterval(expected);
        assertEquals(expected, this.map.getBallSpawnInterval(), 0.00000001);
    }

    @Test
    public void testGetBalls() throws Exception {
        List<Ball> expected = new ArrayList<>();
        expected.add(new Ball());
        Map aMap = new Map(expected);
        assertEquals(expected,aMap.getBalls());
    }

    @Test
    public void testGetGoalsGoalKeepers() throws Exception {
        List<GoalGoalKeeper> expected = new ArrayList<>();
        expected.add(new GoalGoalKeeper());
        this.map.setGoalsGoalKeepers(expected);
        assertEquals(expected,this.map.getGoalsGoalKeepers());
    }
}