package Controller;

import View.GameView;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class GameController implements IGameController {

    private GameView gameView;
    private GameEngine gameEngine;

    public GameController(GameView gameView, GameEngine gameEngine) {
        this.gameView = gameView;
        this.gameEngine = gameEngine;
    }

    @Override
    public void updateView() {
        this.gameView.drawMap();
    }

    @Override
    public void getMap() {
        this.gameEngine.getMap();
    }
}
