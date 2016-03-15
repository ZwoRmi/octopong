package Controller;


import Model.Map;
import Model.MapFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lucas on 14/03/2016.
 */
public class GameEngine implements IGameEngine {
    private final IGameController gameController;
    private Timer timer;
    private Map map;
    private IGoalEngine goalEngine;
    private IBallEngine ballEngine;

    public GameEngine(Map aMap, IGameController aGameController) {
        this.map = aMap;
        this.gameController = aGameController;
        this.init();
    }

    private void init(){
        this.goalEngine = new GoalEngine(this.map);
        this.ballEngine = new BallEngine(this.map);
        timer = createTimer();
    }

    private Timer createTimer ()
    {
        ActionListener action = new ActionListener()
        {
            public void actionPerformed (ActionEvent event)
            {
                updateBallEngine();
                updateGoalEngine();
            }
        };
        return new Timer (100, action);
    }

    @Override
    public void startGame() {
        timer.start();
    }

    @Override
    public void pauseGame() {
        timer.stop();
    }

    @Override
    public void resumeGame() {
        timer.start();
    }

    @Override
    public void restartGame() {
        Map oldMap = this.map;
        this.map = new MapFactory().create();
        this.map.setBallSpawnInterval(oldMap.getBallSpawnInterval());
        this.map.setBallSpeed(oldMap.getBallSpeed());
        timer.restart();
    }

    @Override
    public void stopGame() {
        //TODO show parameters view
        timer.stop();
    }

    @Override
    public void updateBallEngine() {
        this.ballEngine.update();
        this.updateView();
    }

    @Override
    public void updateGoalEngine() {
        this.goalEngine.update();
        this.updateView();
    }

    @Override
    public void updateView() {
        this.gameController.updateView();
    }

    @Override
    public Map getMap() {
        return this.map;
    }
}
