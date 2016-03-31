package Model;

import java.util.List;

public class Map implements IMap {
    private final List<Ball> balls;
    private List<GoalGoalKeeper> goalsGoalKeepers;
    private long ballSpawnInterval;
    private float ballSpeed;

    public Map(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public float getBallSpeed() {
        return this.ballSpeed;
    }

    @Override
    public void setBallSpeed(float speed) {
        this.ballSpeed = speed;
    }

    @Override
    public long getBallSpawnInterval() {
        return this.ballSpawnInterval;
    }

    @Override
    public void setBallSpawnInterval(long ballSpawnInterval) {
        this.ballSpawnInterval = ballSpawnInterval;
    }

    @Override
    public List<Ball> getBalls() {
        synchronized (this.balls) {
            return this.balls;
        }
    }

    @Override
    public List<GoalGoalKeeper> getGoalsGoalKeepers() {
        return this.goalsGoalKeepers;
    }

    @Override
    public void setGoalsGoalKeepers(List<GoalGoalKeeper> goalsGoalKeepers) {
        this.goalsGoalKeepers = goalsGoalKeepers;
    }
}
