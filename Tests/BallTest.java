package Tests;

import Model.Ball;
import Model.Position;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lucas on 23/03/2016.
 */
public class BallTest {
    Ball ball;

    @Before
    public void setUp() throws Exception {
        ball = new Ball();
    }

    @Test
    public void testGetNeedToRemove() throws Exception {
        ball.setNeedToRemove(true);
        Assert.assertTrue(ball.getNeedToRemove());
    }

    @org.junit.Test
    public void testGetActualPosition() throws Exception {
        Position pos = new Position(432,345);
        ball.setActualPosition(pos);
        Assert.assertEquals(pos, ball.getActualPosition());
    }

    @org.junit.Test
    public void testGetDirection() throws Exception {
        Position pos = new Position(432,345);
        ball.setDirection(pos);
        Assert.assertEquals(pos, ball.getDirection());
    }

    @Test
    public void testGetColor() throws Exception {
        Paint expected = Color.BLUE;
        ball.setColor(expected);
        Assert.assertEquals(expected, ball.getColor());
    }

    @org.junit.Test
    public void testGetRadius() throws Exception {
        int expected = 3;
        ball.setRadius(expected);
        Assert.assertEquals(expected, ball.getRadius(), 0.00000000001);
    }

    @org.junit.Test
    public void testGetMass() throws Exception {
        int expected = 5;
        ball.setMass(expected);
        Assert.assertEquals(expected, ball.getMass(), 0.00000000001);
    }
}