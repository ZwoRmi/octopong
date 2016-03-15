package Model;

import java.util.ArrayList;

/**
 * Created by Lucas on 14/03/2016.
 */
public class MapFactory {
    public Map create(){
        Map map = new Map();
        map.setBallSpeed(1);
        map.setBallSpawnInterval(1);
        map.setBalls(this.getBalls());
        map.setGoalsGoalKeepers(this.getGoalsGoalKeepers());
        return new Map();
    }

    private ArrayList<Ball> getBalls() {
        ArrayList<Ball> balls = new ArrayList<Ball>();
        balls.add(this.getFirstBall());
        return null;
    }

    private Ball getFirstBall() {
        Position ballPosition = new Position();
        ballPosition.setX(0);
        ballPosition.setY(0);
        Ball ball = new Ball();
        ball.setActualPosition(ballPosition);
        ball.setDirection(new RandomPositionGenerator().generatePosition());
        return ball;
    }

    private ArrayList<GoalGoalKeeper> getGoalsGoalKeepers() {
        //TODO initialiser buts et gardiens
        return null;
    }
}
