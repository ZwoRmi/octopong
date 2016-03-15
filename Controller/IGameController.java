package Controller;

/**
 * Created by Lucas on 14/03/2016.
 */
public interface IGameController {
    void updateView();
    void getMap();
    void setGameEngine(IGameEngine gameEngine);
    void goBackToParameters();
    void startGame();
    void pauseGame();
    void resumeGame();
    void restartGame();
    void stopGame();
}
