package Model;

public class GoalKeeper {
    private float speed;
    private float size;
    private GoalPosition goalPosition;
    private Score score;
    private Line actualPosition;
    private Line targetPosition;

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

    public float getSize() {
        return this.size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Score getScore() {
        return this.score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Line getActualPosition() {
        return this.actualPosition;
    }

    public void setActualPosition(Line actualPosition) {
        this.actualPosition = actualPosition;
    }

    public Line getTargetPosition() {
        return this.targetPosition;
    }

    public void setTargetPosition(Line targetPosition) {
        this.targetPosition = targetPosition;
    }


}
