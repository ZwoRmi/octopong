package Model;

import javafx.scene.paint.Paint;

public class Ball {
    private Position actualPosition;
    private Position direction;
    private boolean needToRemove;
    private Paint color;
    private float radius;
    private float mass;

    public Ball() {
        this.color = new RandomColorGenerator().getColor();
        this.setRadius(4);
        this.setMass(this.getRadius());
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

    public void setColor(Paint color) {
        this.color = color;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getMass() {
        return this.mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}
