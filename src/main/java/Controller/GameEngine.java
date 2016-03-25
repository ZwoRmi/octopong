package Controller;


import Model.Map;
import Model.MapFactory;
import javax.swing.*;
import java.awt.event.ActionListener;

public class GameEngine implements IGameEngine {
    private Timer timer;
    private Map map;
    private IGoalEngine goalEngine;
    private IBallEngine ballEngine;

    public GameEngine(Map aMap) {
        this.map = aMap;
        this.init();
    }

    private void init(){
        this.goalEngine = new GoalEngine(this.map);
        this.ballEngine = new BallEngine(this.map);
        this.timer = this.createTimer();
    }

    private Timer createTimer ()
    {
        ActionListener action = event -> {
            GameEngine.this.updateBallEngine();
            GameEngine.this.updateGoalEngine();
        };
        return new Timer (3, action);
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
        this.ballEngine = new BallEngine(this.map);
        this.goalEngine = new GoalEngine(this.map);
        this.map.setBallSpawnInterval(oldMap.getBallSpawnInterval());
        this.map.setBallSpeed(oldMap.getBallSpeed());
        this.timer.restart();
        this.timer.start();
    }

    @Override
    public void stopGame() {
        this.ballEngine = new BallEngine(this.map);
        this.goalEngine = new GoalEngine(this.map);
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
    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public IGoalEngine getGoalEngine() {
        return this.goalEngine;
    }

    @Override
    public void generateBall() {
        this.ballEngine.generateBall();
    }
}
