package Controller;

import Model.IMap;

public interface IGameEngine {
    void startGame();
    void pauseGame();
    void resumeGame();
    void restartGame();
    void stopGame();
    void updateBallEngine();
    void updateGoalEngine();

    IMap getMap();

    void setMap(IMap IMap);

    void generateBall();

    IGoalEngine getGoalEngine();
}
