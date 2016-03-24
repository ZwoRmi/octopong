package Model;

import Model.Position;
import Model.Score;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lucas on 23/03/2016.
 */
public class ScoreTest {
    Score score;

    @Before
    public void setUp() throws Exception {
        this.score = new Score();
    }

    @Test
    public void testGetPosition() throws Exception {
        Position expected = new Position(0, 1);
        this.score.setPosition(expected);
        assertEquals(expected, this.score.getPosition());
    }

    @Test
    public void testGetScore() throws Exception {
        int expected = 6;
        this.score.setScore(expected);
        assertEquals(expected, this.score.getScore());
    }
}