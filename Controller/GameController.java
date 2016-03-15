package Controller;

import View.ApplicationWindow;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class GameController implements IGameController {

    private IGameEngine gameEngine;
    private ApplicationWindow applicationWindow;

    public GameController(ApplicationWindow applicationWindow) {
        this.applicationWindow = applicationWindow;
    }

    @Override
    public void setGameEngine(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void goBackToParameters() {
        this.applicationWindow.showParameters();
    }

    @Override
    public void startGame() {
        this.gameEngine.startGame();
        this.applicationWindow.showGame();
    }

    @Override
    public void resumeGame() {
        this.gameEngine.resumeGame();
    }

    @Override
    public void pauseGame() {
        this.gameEngine.pauseGame();
    }

    @Override
    public void restartGame() {
        this.gameEngine.restartGame();
    }

    @Override
    public void stopGame() {
        this.gameEngine.stopGame();
        this.applicationWindow.showParameters();
    }

    @Override
    public void updateView() {
        this.applicationWindow.getCurrentPanel();
    }

    @Override
    public void getMap() {
        this.gameEngine.getMap();
    }
}
