package Controller;

import Model.Map;

public interface IGameEngine {
    void startGame();
    void pauseGame();
    void resumeGame();
    void restartGame();
    void stopGame();
    void updateBallEngine();
    void updateGoalEngine();
    Map getMap();
    void generateBall();
    void setMap(Map map);
    IGoalEngine getGoalEngine();
}
