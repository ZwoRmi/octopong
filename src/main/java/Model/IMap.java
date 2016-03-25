package Model;

import java.util.List;

public interface IMap {
    float getBallSpeed();
    void setBallSpeed(float speed);
    long getBallSpawnInterval();
    void setBallSpawnInterval(long ballSpawnInterval);
    List<Ball> getBalls();
    List<GoalGoalKeeper> getGoalsGoalKeepers();
    void setGoalsGoalKeepers(List<GoalGoalKeeper> goalsGoalKeepers);
}
