package Model;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BallTest {
    private Ball ball;

    @Before
    public void setUp() {
        this.ball = new Ball();
    }

    @Test
    public void testGetNeedToRemove() throws Exception {
        this.ball.setNeedToRemove(true);
        Assert.assertTrue(this.ball.getNeedToRemove());
    }

    @org.junit.Test
    public void testGetActualPosition() throws Exception {
        Position pos = new Position(432,345);
        this.ball.setActualPosition(pos);
        Assert.assertEquals(pos, this.ball.getActualPosition());
    }

    @org.junit.Test
    public void testGetDirection() throws Exception {
        Position pos = new Position(432,3345);
        this.ball.setDirection(pos);
        Assert.assertEquals(pos, this.ball.getDirection());
    }

    @Test
    public void testGetColor() throws Exception {
        Paint expected = Color.BLUE;
        this.ball.setColor(expected);
        Assert.assertEquals(expected, this.ball.getColor());
    }

    @org.junit.Test
    public void testGetRadius() throws Exception {
        int expected = 3;
        this.ball.setRadius(expected);
        Assert.assertEquals(expected, this.ball.getRadius(), 0.00000000001);
    }

    @org.junit.Test
    public void testGetMass() throws Exception {
        int expected = 5;
        this.ball.setMass(expected);
        Assert.assertEquals(expected, this.ball.getMass(), 0.00000000001);
    }
}