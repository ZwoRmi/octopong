package Controller;

import Model.*;
import Util.StopWatch;
import View.IApplicationWindow;

public class GameController implements IGameController {
    private final StopWatch stopWatch;
    private final IApplicationWindow applicationWindow;
    private IGameEngine gameEngine;
    private IParametersController parametersController;

    public GameController(IApplicationWindow applicationWindow) {
        this.applicationWindow = applicationWindow;
        this.stopWatch = new StopWatch();
    }

    @Override
    public void setGameEngine(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void startGame() {
        if (this.stopWatch.isStopped()) {
            this.stopWatch.start();
            this.gameEngine.startGame();
        }
    }

    @Override
    public void resumeGame() {
        if (this.stopWatch.isSuspended()) {
            this.stopWatch.resume();
            this.gameEngine.resumeGame();
        }
    }

    @Override
    public void pauseGame() {
        if (!this.stopWatch.isSuspended()) {
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
    public IMap getMap() {
        return this.gameEngine.getMap();
    }

    @Override
    public void setMap(IMap map) {
        this.gameEngine.setMap(map);
    }

    @Override
    public long getGameTime() {
        return this.stopWatch.getNanoTime();
    }

    @Override
    public void ControlSouthGoalKeeper() {
        this.getSouthGoalKeeper().setPlayedByHuman(true);
    }

    @Override
    public void MoveSouthGoalKeeper(int x) {
        GoalKeeper southGoalKeeper = this.getSouthGoalKeeper();
        if (!southGoalKeeper.getPlayedByHuman()) return;
        Line targetPositionStart = new Line(new Position(), new Position());
        targetPositionStart.getStartPosition().setX(southGoalKeeper.getActualPositionStart().getStartPosition().getX
                () + x);
        targetPositionStart.getStartPosition().setY(southGoalKeeper.getActualPositionStart().getStartPosition().getY());
        targetPositionStart.getEndPosition().setX(southGoalKeeper.getActualPositionStart().getEndPosition().getX() + x);
        targetPositionStart.getEndPosition().setY(southGoalKeeper.getActualPositionStart().getEndPosition().getY());
        if (this.gameEngine.getGoalEngine().isInLimitedArea(southGoalKeeper, targetPositionStart)) {
            southGoalKeeper.setActualPositionStart(targetPositionStart);
            southGoalKeeper.getActualPositionEnd().getStartPosition().setX(southGoalKeeper.getActualPositionEnd()
                    .getStartPosition().getX() + x);
            southGoalKeeper.getActualPositionEnd().getEndPosition().setX(southGoalKeeper.getActualPositionEnd()
                    .getEndPosition().getX() + x);
        }

    }

    @Override
    public GoalKeeper getSouthGoalKeeper() {
        for (GoalGoalKeeper goalGoalKeeper : this.getMap().getGoalsGoalKeepers()) {
            if (goalGoalKeeper.getGoalKeeper().getGoalPosition() == GoalPosition.South) {
                return goalGoalKeeper.getGoalKeeper();
            }
        }
        return null;
    }

    @Override
    public void UnControlSouthGoalKeeper() {
        this.getSouthGoalKeeper().setPlayedByHuman(false);
    }

    @Override
    public IParametersController getParametersController() {
        return this.parametersController;
    }

    @Override
    public void setParametersController(IParametersController parametersController) {
        this.parametersController = parametersController;
    }
}
