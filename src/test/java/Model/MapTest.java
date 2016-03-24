package Model;

import Model.Ball;
import Model.GoalGoalKeeper;
import Model.Map;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 23/03/2016.
 */
public class MapTest {
    Map map;

    @Before
    public void setUp() throws Exception {
        this.map = new Map();
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
        this.map.setBalls(expected);
        assertEquals(expected,this.map.getBalls());
    }

    @Test
    public void testGetGoalsGoalKeepers() throws Exception {
        List<GoalGoalKeeper> expected = new ArrayList<>();
        expected.add(new GoalGoalKeeper());
        this.map.setGoalsGoalKeepers(expected);
        assertEquals(expected,this.map.getGoalsGoalKeepers());
    }
}