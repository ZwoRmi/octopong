package Model;

import java.util.ArrayList;

/**
 * Created by Lucas on 14/03/2016.
 */
public class Map {
    private ArrayList<Ball> balls;
    private ArrayList<GoalGoalKeeper> goalsGoalKeepers;
    private float diameter;
    private float ballSpawnInterval;
    private float ballSpeed;

    public float getBallSpeed() {
        return this.ballSpeed;
    }

    public void setBallSpeed(float speed) {
        this.ballSpeed = speed;
    }

    public float getBallSpawnInterval() {
        return this.ballSpawnInterval;
    }

    public void setBallSpawnInterval(float ballSpawnInterval) {
        this.ballSpawnInterval = ballSpawnInterval;
    }

    public ArrayList<Ball> getBalls() {
        return this.balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public ArrayList<GoalGoalKeeper> getGoalsGoalKeepers() {
        return this.goalsGoalKeepers;
    }

    public void setGoalsGoalKeepers(ArrayList<GoalGoalKeeper> goalsGoalKeepers) {
        this.goalsGoalKeepers = goalsGoalKeepers;
    }

    public float getDiameter() {
        return this.diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

}
