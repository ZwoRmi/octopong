package Controller;

import Model.*;

/**
 * Created by Lucas on 14/03/2016.
 */
public class BallEngine implements IBallEngine {
    private final Map map;
    private float timeForGenerateBall;


    public BallEngine(Map aMap) {
        this.map = aMap;
        this.initTimeForGenerateBall();
    }

    @Override
    public void update() {
        this.move();
        if (System.nanoTime()>this.timeForGenerateBall){
            this.generateBall();
            this.initTimeForGenerateBall();
        }
    }

    private void initTimeForGenerateBall(){
        this.timeForGenerateBall = System.nanoTime() + this.map.getBallSpawnInterval();
    }

    @Override
    public void move() {
        for (Ball ball: this.map.getBalls()) {
            this.moveBall(ball);
        }
    }

    private void moveBall(Ball ball) {
        GoalKeeper goalKeeper = getGoalBallRebound(ball);
        if(goalKeeper!=null){
            ReboundCalculator reboundCalculator = new ReboundCalculator(ball,goalKeeper);
            ball.setDirection(reboundCalculator.getNewDirection());
        }
        Position actualPosition = ball.getActualPosition();
        Position targetPosition = new Position();
        targetPosition.setX(actualPosition.getX() + ball.getDirection().getX() * map.getBallSpeed());
        targetPosition.setY(actualPosition.getY() + ball.getDirection().getY() * map.getBallSpeed());
        ball.setActualPosition(targetPosition);
    }

    private GoalKeeper getGoalBallRebound(Ball ball) {
        for (GoalGoalKeeper goalGoalKeeper : this.map.getGoalsGoalKeepers()) {
            Boundary boundary = new Boundary(goalGoalKeeper.getGoalKeeper().getActualPosition());
            if (boundary.contains(ball.getActualPosition())){
                return goalGoalKeeper.getGoalKeeper();
            }
        }
        return null;
    }

    @Override
    public void generateBall() {
        Ball b = new Ball();
        Position randomPosition = new Position();
        randomPosition.setX(randRange(2, 2));
        randomPosition.setY(randRange(-2, 2));
        b.setActualPosition(randomPosition);
        this.map.getBalls().add(b);
    }

    private float randRange(float min, float max) {
        return min + (float)Math.random() * (max - min);
    }
}
