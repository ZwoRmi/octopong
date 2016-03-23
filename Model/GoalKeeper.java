package Model;

import javafx.scene.paint.Paint;

public class GoalKeeper {
    private float speed;
    private GoalPosition goalPosition;
    private Score score;
    private Line actualPositionStart;
    private Line actualPositionEnd;
    private Line targetPosition;
    private Paint color;

    public GoalPosition getGoalPosition() {
        return this.goalPosition;
    }

    public void setGoalPosition(GoalPosition goalPosition) {
        this.goalPosition = goalPosition;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Score getScore() {
        return this.score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Line getActualPositionStart() {
        return this.actualPositionStart;
    }

    public void setActualPositionStart(Line actualPositionStart) {
        this.actualPositionStart = actualPositionStart;
    }

    public Line getActualPositionEnd() {
        return this.actualPositionEnd;
    }

    public void setActualPositionEnd(Line actualPositionEnd) {
        this.actualPositionEnd = actualPositionEnd;
    }

    public Line getTargetPosition() {
        return this.targetPosition;
    }

    public void setTargetPosition(Line targetPosition) {
        this.targetPosition = targetPosition;
    }


    public void setColor(Paint color) {
        this.color = color;
    }

    public Paint getColor() {
        return this.color;
    }
}
