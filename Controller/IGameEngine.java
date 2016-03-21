package Controller;

import Model.Map;

/**
 * Created by Lucas on 14/03/2016.
 */
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
}
