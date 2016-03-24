package Controller;

import Model.Ball;
import Model.Goal;

/**
 * Created by Lucas on 14/03/2016.
 */
public interface IGoalEngine {
    void move();
    void checkBallInDetectionArea();
    void goalDetection();
    void onGoal(Goal goal, Ball ball);
    void updateScore(Goal goal);

    void centerGoalKeepers();
    void update();
}
