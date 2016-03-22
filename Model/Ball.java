package Model;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Created by Lucas on 14/03/2016.
 */
public class Ball {
    private Position actualPosition;
    private Position direction;
    private boolean needToRemove;
    private Color color;
    private float radius;

    public Ball() {
        this.color = new RandomColorGenerator().getColor();
        this.setRadius(3);
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
}
