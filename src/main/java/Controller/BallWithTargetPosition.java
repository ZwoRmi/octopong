package Controller;

import Model.Ball;
import Model.Position;

public class BallWithTargetPosition {
    private Ball ball;
    private Position targetPosition;
    private int countToGoToTargetPosition;

    public Ball getBall() {
        return this.ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Position getTargetPosition() {
        return this.targetPosition;
    }

    public void setTargetPosition(Position targetPosition) {
        this.targetPosition = targetPosition;
    }

    public int getCountToGoToTargetPosition() {
        return this.countToGoToTargetPosition;
    }

    public void setCountToGoToTargetPosition(int countToGoToTargetPosition) {
        this.countToGoToTargetPosition = countToGoToTargetPosition;
    }
}
