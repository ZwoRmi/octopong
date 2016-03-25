package Controller;

import Model.GoalKeeper;
import Model.Map;

public interface IGameController {
    Map getMap();
    long getGameTime();
    void setGameEngine(IGameEngine gameEngine);
    void generateBallGame();
    void startGame();
    void pauseGame();
    void resumeGame();
    void restartGame();
    void stopGame();
    void setMap(Map map);
    void setParametersController(IParametersController parametersController);
    void ControlSouthGoalKeeper();
    void MoveSouthGoalKeeper(int x);
    GoalKeeper getSouthGoalKeeper();
    void UnControlSouthGoalKeeper();
}
