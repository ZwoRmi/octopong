package Controller;

import Model.Ball;
import Model.Goal;
import Model.GoalKeeper;
import Model.Line;

/**
 * Created by Lucas on 14/03/2016.
 */
public interface IGoalEngine {
    void move();

    boolean isInLimitedArea(GoalKeeper goalKeeper, Line targetPositionStart);

    void checkBallInDetectionArea();
    void goalDetection();
    void onGoal(Goal goal, Ball ball);
    void updateScore(Goal goal);

    void centerGoalKeepers();
    void update();
}
