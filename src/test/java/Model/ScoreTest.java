package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("RedundantThrows")
public class ScoreTest {
    private Score score;

    @Before
    public void setUp() {
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