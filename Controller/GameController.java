package Controller;

import Model.Map;
import Model.MapFactory;
import Util.StopWatch;
import View.ApplicationWindow;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class GameController implements IGameController {

    private final StopWatch stopWatch;
    private IGameEngine gameEngine;
    private ApplicationWindow applicationWindow;
    private IParametersController parametersController;

    public GameController(ApplicationWindow applicationWindow) {
        this.applicationWindow = applicationWindow;
        this.stopWatch = new StopWatch();
    }

    @Override
    public void setGameEngine(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void startGame() {
        if (stopWatch.isStopped()){
            this.stopWatch.start();
            this.gameEngine.startGame();
        }
    }

    @Override
    public void resumeGame() {
        if (this.stopWatch.isSuspended()){
            this.stopWatch.resume();
            this.gameEngine.resumeGame();
        }
    }

    @Override
    public void pauseGame() {
        if (!this.stopWatch.isSuspended()){
            this.stopWatch.suspend();
            this.gameEngine.pauseGame();
        }
    }

    @Override
    public void restartGame() {
        this.stopWatch.reset();
        this.stopWatch.start();
        this.gameEngine.restartGame();
    }

    @Override
    public void stopGame() {
        this.setMap(new MapFactory().create());
        this.gameEngine.setMap(this.getMap());
        this.parametersController.setMap(this.getMap());
        this.stopWatch.reset();
        this.gameEngine.stopGame();
        this.applicationWindow.showParameters();
    }

    @Override
    public void generateBallGame() {
        this.gameEngine.generateBall();
    }

    @Override
    public Map getMap() {
        return this.gameEngine.getMap();
    }
    @Override
    public void setMap(Map map) {
        this.gameEngine.setMap(map);
    }

    @Override
    public void setParametersController(IParametersController parametersController) {
        this.parametersController = parametersController;
    }

    @Override
    public long getGameTime() {
        return this.stopWatch.getNanoTime();
    }


}
