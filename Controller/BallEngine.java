package Controller;

import Model.*;
import Util.StopWatch;

/**
 * Created by Lucas on 14/03/2016.
 */
public class BallEngine implements IBallEngine {
    private final Map map;
    private StopWatch stopWatch;


    public BallEngine(Map aMap) {
        this.stopWatch = new StopWatch();
        this.map = aMap;
        this.initTimeForGenerateBall();
    }

    @Override
    public void update() {
        this.move();
        if (this.stopWatch.getTime()> this.map.getBallSpawnInterval()){
            this.generateBall();
            this.stopWatch.stop();
            this.stopWatch.reset();
            this.initTimeForGenerateBall();
        }
    }

    private void initTimeForGenerateBall(){
        this.stopWatch.start();
    }

    @Override
    public void move() {
        synchronized (this.map.getBalls()){
            for (Ball ball: this.map.getBalls()) {
                this.moveBall(ball);
            }
        }
    }

    private void moveBall(Ball ball) {
        GoalKeeper goalKeeper = this.getGoalBallRebound(ball);
        if(goalKeeper!=null){
            ReboundCalculator reboundCalculator = new ReboundCalculator(ball,goalKeeper);
            ball.setDirection(reboundCalculator.getNewDirection());
        }
        Position actualPosition = ball.getActualPosition();
        Position targetPosition = new Position();
        targetPosition.setX(actualPosition.getX() + ball.getDirection().getX() * this.map.getBallSpeed());
        targetPosition.setY(actualPosition.getY() + ball.getDirection().getY() * this.map.getBallSpeed());
        ball.setActualPosition(targetPosition);
    }

    private GoalKeeper getGoalBallRebound(Ball ball) {
        for (GoalGoalKeeper goalGoalKeeper : this.map.getGoalsGoalKeepers()) {
            PolygonBoundary boundary = new PolygonBoundary(goalGoalKeeper.getGoalKeeper().getActualPositionStart(), goalGoalKeeper.getGoalKeeper().getActualPositionEnd());
            if (boundary.contains(ball.getActualPosition())){
                return goalGoalKeeper.getGoalKeeper();
            }
        }
        return null;
    }

    @Override
    public void generateBall() {
        Ball b = new Ball();
        b.setNeedToRemove(false);
        Position startPosition = new Position();
        startPosition.setX(602);
        startPosition.setY(315);
        b.setActualPosition(startPosition);
        b.setDirection(new RandomPositionGenerator().generatePosition());
        synchronized (this.map.getBalls()){
            this.map.getBalls().add(b);
        }
    }
}
