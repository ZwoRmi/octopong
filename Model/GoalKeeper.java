package Model;

public class GoalKeeper {
    private float speed;
    private float size;
    private GoalPosition goalPosition;
    private Score score;
    private Line actualPosition;
    private Line targetPosition;

    public GoalPosition getGoalPosition() {
        return goalPosition;
    }

    public void setGoalPosition(GoalPosition goalPosition) {
        this.goalPosition = goalPosition;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Line getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Line actualPosition) {
        this.actualPosition = actualPosition;
    }

    public Line getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Line targetPosition) {
        this.targetPosition = targetPosition;
    }


}
