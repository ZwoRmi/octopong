package Controller;

import Model.Map;

/**
 * Created by Lucas on 14/03/2016.
 */
public interface IGameEngine {
    // mon constructeur créé ball et goal engine avec un timer
    void startGame();
    void pauseGame();
    void resumeGame();
    void restartGame();
    void stopGame();
    // au déclenchement du timer tick
    void updateBallEngine();
    void updateGoalEngine();
    void updateView();
    Map getMap();
    void generateBall();
}
