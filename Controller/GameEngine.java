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
        this.timer = this.createTimer();
    }

    private Timer createTimer ()
    {
        ActionListener action = new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent event)
            {
                GameEngine.this.updateBallEngine();
                GameEngine.this.updateGoalEngine();
            }
        };
        return new Timer (100, action);
    }

    @Override
    public void startGame() {
        this.timer.start();
    }

    @Override
    public void pauseGame() {
        this.timer.stop();
    }

    @Override
    public void resumeGame() {
        this.timer.start();
    }

    @Override
    public void restartGame() {
        Map oldMap = this.map;
        this.map = new MapFactory().create();
        this.map.setBallSpawnInterval(oldMap.getBallSpawnInterval());
        this.map.setBallSpeed(oldMap.getBallSpeed());
        this.ballEngine = new BallEngine(this.map);
        this.goalEngine = new GoalEngine(this.map);
        this.timer.restart();
    }

    @Override
    public void stopGame() {
        this.restartGame();
        this.timer.stop();
    }

    @Override
    public void updateBallEngine() {
        this.ballEngine.update();
    }

    @Override
    public void updateGoalEngine() {
        this.goalEngine.update();
    }

    @Override
    public Map getMap() {
        return this.map;
    }

    @Override
    public void generateBall() {
        this.ballEngine.generateBall();
    }
}
