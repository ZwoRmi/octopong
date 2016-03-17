package Controller;

import Model.Map;
import Util.StopWatch;
import View.ApplicationWindow;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class GameController implements IGameController {

    private final StopWatch stopWatch;
    private IGameEngine gameEngine;
    private ApplicationWindow applicationWindow;

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
        if (this.stopWatch.isStarted()){
            this.stopWatch.suspend();
            this.gameEngine.pauseGame();
        }
    }

    @Override
    public void restartGame() {
        if (stopWatch.isStarted()){
            this.stopWatch.stop();
        }
        this.stopWatch.reset();
        this.stopWatch.start();
        this.gameEngine.restartGame();
    }

    @Override
    public void stopGame() {
        this.stopWatch.stop();
        this.stopWatch.reset();
        this.gameEngine.stopGame();
        this.applicationWindow.showParameters();
    }

    @Override
    public void generateBallGame() {
        this.gameEngine.generateBall();
    }

    @Override
    public void updateView() {

    }

    @Override
    public Map getMap() {
        return this.gameEngine.getMap();
    }

    @Override
    public long getGameTime() {
        return this.stopWatch.getNanoTime();
    }


}
