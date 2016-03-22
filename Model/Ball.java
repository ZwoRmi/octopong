package Model;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

/**
 * Created by Lucas on 14/03/2016.
 */
public class Ball {
    private Position actualPosition;
    private Position direction;
    private boolean needToRemove;
    private Color color;
    private float radius;
    private float mass;

    public Ball() {
        Random rn = new Random();
        this.color = new RandomColorGenerator().getColor();
        this.setRadius(rn.nextInt(3)+3);
        this.mass = this.getRadius();
    }

    public boolean getNeedToRemove() {
        return this.needToRemove;
    }

    public void setNeedToRemove(boolean needToRemove) {
        this.needToRemove = needToRemove;
    }

    public Position getActualPosition() {
        return this.actualPosition;
    }

    public void setActualPosition(Position actualPosition) {
        this.actualPosition = actualPosition;
    }

    public Position getDirection() {
        return this.direction;
    }

    public void setDirection(Position direction) {
        this.direction = direction;
    }

    public Paint getColor() {
        return this.color;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getMass() {
        return mass;
    }
}
