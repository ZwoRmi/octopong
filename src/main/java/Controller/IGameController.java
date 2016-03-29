package Controller;

import Model.GoalKeeper;
import Model.IMap;

public interface IGameController {
    IMap getMap();
    void setMap(IMap map);
    long getGameTime();
    void setGameEngine(IGameEngine gameEngine);
    void generateBallGame();
    void startGame();
    void pauseGame();
    void resumeGame();
    void restartGame();
    void stopGame();

    void ControlSouthGoalKeeper();

    void MoveSouthGoalKeeper(int x);

    GoalKeeper getSouthGoalKeeper();

    void UnControlSouthGoalKeeper();

    IParametersController getParametersController();

    void setParametersController(IParametersController parametersController);
}
