package Controller;

import Model.Ball;
import Model.Goal;
import Model.GoalKeeper;
import Model.Line;

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
