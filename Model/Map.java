package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 14/03/2016.
 */
public class Map {
    private List<Ball> balls;
    private List<GoalGoalKeeper> goalsGoalKeepers;
    private long ballSpawnInterval;
    private float ballSpeed;

    public float getBallSpeed() {
        return this.ballSpeed;
    }

    public void setBallSpeed(float speed) {
        this.ballSpeed = speed;
    }

    public long getBallSpawnInterval() {
        return this.ballSpawnInterval;
    }

    public void setBallSpawnInterval(long ballSpawnInterval) {
        this.ballSpawnInterval = ballSpawnInterval;
    }

    public List<Ball> getBalls() {
        synchronized (this.balls){
            return this.balls;
        }
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public List<GoalGoalKeeper> getGoalsGoalKeepers() {
        return this.goalsGoalKeepers;
    }

    public void setGoalsGoalKeepers(List<GoalGoalKeeper> goalsGoalKeepers) {
        this.goalsGoalKeepers = goalsGoalKeepers;
    }

}
