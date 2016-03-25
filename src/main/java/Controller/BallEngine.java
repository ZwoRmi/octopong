package Controller;

import Model.*;
import Util.StopWatch;

import java.util.Random;

public class BallEngine implements IBallEngine {
    private final IMap map;
    private final StopWatch stopWatch;

    public BallEngine(IMap aIMap) {
        this.stopWatch = new StopWatch();
        this.map = aIMap;
        this.initTimeForGenerateBall();
    }

    @Override
    public void update() {
        this.move();
        if (this.stopWatch.getTime() > this.map.getBallSpawnInterval()) {
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
        synchronized (this.map.getBalls()) {
            this.map.getBalls().forEach(this::moveBall);
        }
    }

    private void moveBall(Ball ball) {
        GoalKeeper goalKeeper = this.getGoalBallRebound(ball);
        if(goalKeeper!=null){
            ReboundCalculator reboundCalculator = new ReboundCalculator(ball,goalKeeper);
            if (reboundCalculator.isMovingToGoalKeeper()){
                this.setColorToGoalkeeper(ball,goalKeeper);
                ball.setDirection(reboundCalculator.getNewDirection());
            }
        }
        Ball reboundBall = this.getBallBallRebound(ball);
        if(reboundBall!=null){
            BallToBallReboundCalculator ballToBallReboundCalculator= new BallToBallReboundCalculator(ball, reboundBall);
            ballToBallReboundCalculator.updateDirections();
        }
        Position actualPosition = ball.getActualPosition();
        Position targetPosition = new Position();
        targetPosition.setX(actualPosition.getX() + ball.getDirection().getX() * this.map.getBallSpeed());
        targetPosition.setY(actualPosition.getY() + ball.getDirection().getY() * this.map.getBallSpeed());
        ball.setActualPosition(targetPosition);
    }

    private Ball getBallBallRebound(Ball ball) {
        for (Ball otherBall : this.map.getBalls()) {
            if(!ball.equals(otherBall)){
                if (this.colliding(ball, otherBall)){
                    return otherBall;
                }
            }
        }
        return null;
    }

    private boolean colliding(Ball ball, Ball otherBall) {
        float xd = ball.getActualPosition().getX() - otherBall.getActualPosition().getX();
        float yd = ball.getActualPosition().getY() - otherBall.getActualPosition().getY();
        float sumRadius = ball.getRadius() + otherBall.getRadius();
        float sqrRadius = sumRadius * sumRadius;
        float distSqr = (xd * xd) + (yd * yd);
        return  (distSqr <= sqrRadius);
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

    private void setColorToGoalkeeper(Ball ball,GoalKeeper goalKeeper){
        goalKeeper.setColor(ball.getColor());
    }
    @Override
    public void generateBall() {
        this.map.getBalls().add(this.getGeneratedBall());
    }

    private Ball getGeneratedBall() {
        int count = 0;
        float x = 602;
        float y = 315;
        Ball ball = new Ball();
        ball.setDirection(new RandomPositionGenerator().generatePosition());
        ball.setNeedToRemove(false);
        Random rn = new Random();
        do {
            count++;
            ball.setActualPosition(new Position(x,y));
            x=rn.nextInt(80)+562;
            y=rn.nextInt(80)+275;
        }while (this.getBallBallRebound(ball)!=null && count < 1000);
        return ball;
    }
}
