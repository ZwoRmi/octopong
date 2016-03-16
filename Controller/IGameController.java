package Controller;

import Model.Map;

/**
 * Created by Lucas on 14/03/2016.
 */
public interface IGameController {
    void updateView();
    Map getMap();
    long getGameTime();
    void setGameEngine(IGameEngine gameEngine);

    void startGame();
    void pauseGame();
    void resumeGame();
    void restartGame();
    void stopGame();
}
