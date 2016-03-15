package Controller;

import Model.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by Lucas on 14/03/2016.
 */
public class GoalEngine implements IGoalEngine {
    private Map map;

    public GoalEngine(Map aMap) {
        this.map = aMap;
    }

    @Override
    public void move() {
        for (GoalGoalKeeper goalGoalKeeper: map.getGoalsGoalKeepers()) {
            GoalKeeper goalKeeper = goalGoalKeeper.getGoalKeeper();
            this.moveGoalKeeper(goalKeeper);
        }
    }

    private void moveGoalKeeper(GoalKeeper goalKeeper) {
        Position actualPosition = goalKeeper.getActualPosition();
        Position targetDirection=this.getGoalDirection(goalKeeper);
        Position targetPosition = new Position();
        targetPosition.setX(actualPosition.getX() + targetDirection.getX() * map.getBallSpeed());
        targetPosition.setY(actualPosition.getY() + targetDirection.getY() * map.getBallSpeed());
        goalKeeper.setActualPosition(targetPosition);
    }

    private Position getGoalDirection(GoalKeeper g){
        Position direction = new Position();
        Position actualPosition = g.getActualPosition();
        Position targetPosition = g.getTargetPosition();
        if(actualPosition.getX()-targetPosition.getX()<0){
            direction.setX(1);
        }
        else if (actualPosition.getX()-targetPosition.getX()>0)
        {
            direction.setX(-1);
        }
        if(actualPosition.getY()-targetPosition.getY()<0){
            direction.setY(1);
        }
        else if (actualPosition.getY()-targetPosition.getY()>0)
        {
            direction.setY(-1);
        }
        return direction;
    }

    public void checkBallInDetectionArea() {
        for (GoalGoalKeeper goalGoalKeeper: map.getGoalsGoalKeepers()) {
            Goal goal = goalGoalKeeper.getGoal();
            this.UpdateGoalTargetPosition(goalGoalKeeper, this.getBallsInDetectionArea(goal));
        }
    }

    private void UpdateGoalTargetPosition(GoalGoalKeeper goalGoalKeeper, ArrayList<Ball> ballsInDetectionArea) {
        ArrayList<BallWithTargetPosition> ballWithTargetPositions = this.getBallsWithTargetPosition(goalGoalKeeper, ballsInDetectionArea);
        Position targetPosition = this.getPositionToStopBall(ballWithTargetPositions);
        goalGoalKeeper.getGoalKeeper().setTargetPosition(targetPosition);
    }

    private Position getPositionToStopBall(ArrayList<BallWithTargetPosition> ballWithTargetPositions) {
        int minCount = 1000000;
        BallWithTargetPosition ballWithTargetPosition = null;
        for (BallWithTargetPosition currentBallWithTargetPosition:ballWithTargetPositions) {
            if (currentBallWithTargetPosition.getCountToGoToTargetPosition()<minCount){
                minCount = currentBallWithTargetPosition.getCountToGoToTargetPosition();
                ballWithTargetPosition = currentBallWithTargetPosition;
            }
        }
        return ballWithTargetPosition.getTargetPosition();
    }

    private ArrayList<BallWithTargetPosition> getBallsWithTargetPosition(GoalGoalKeeper goalGoalKeeper, ArrayList<Ball> ballsInDetectionArea) {
        ArrayList<BallWithTargetPosition> ballWithTargetPositions = new ArrayList<BallWithTargetPosition>();
        for (Ball ball : ballsInDetectionArea) {
            Position fakePosition = ball.getActualPosition();
            int count = 0;
            while(!isGoal(ball, goalGoalKeeper.getGoal())){
                fakePosition = this.getNextPosition(ball, fakePosition);
                count++;
            }
            BallWithTargetPosition ballWithTargetPosition = new BallWithTargetPosition();
            ballWithTargetPosition.setBall(ball);
            ballWithTargetPosition.setTargetPosition(fakePosition);
            ballWithTargetPosition.setCountToGoToTargetPosition(count);
            ballWithTargetPositions.add(ballWithTargetPosition);
        }
        return ballWithTargetPositions;
    }


    private Position getNextPosition(Ball ball, Position fakePosition){
        Position actualPosition = fakePosition;
        Position targetPosition = new Position();
        targetPosition.setX(actualPosition.getX() + ball.getDirection().getX() * map.getBallSpeed());
        targetPosition.setY(actualPosition.getY() + ball.getDirection().getY() * map.getBallSpeed());
        return targetPosition;
    }

    private ArrayList<Ball> getBallsInDetectionArea(Goal goal) {
        ArrayList<Ball> ballsInArea = new ArrayList<Ball>();
        Boundary boundary = new Boundary(goal.getGoalStartLine(), goal.getDetectionLine());
        for (Ball ball : this.map.getBalls()) {
            if (boundary.contains(ball.getActualPosition())){
                ballsInArea.add(ball);
            }
        }
        return ballsInArea;
    }

    @Override
    public void goalDetection() {
        for (Ball ball : this.map.getBalls()) {
            for (GoalGoalKeeper goalGoalKeeper : map.getGoalsGoalKeepers()) {
                if (isGoal(ball, goalGoalKeeper.getGoal())){
                    onGoal(goalGoalKeeper.getGoal(), ball);
                }
            }
        }
    }

    private boolean isGoal(Ball ball, Goal goal) {
        Boundary boundary = new Boundary(goal.getGoalStartLine(),goal.getGoalEndLine());
        return boundary.contains(ball.getActualPosition());
    }

    @Override
    public void onGoal(Goal goal, Ball ball) {
        this.updateScore(goal);
        this.map.getBalls().remove(ball);
    }

    @Override
    public void updateScore(Goal goal) {
        GoalKeeper goalKeeper = this.getGoalKeeper(goal);
        goalKeeper.getScore().setScore(goalKeeper.getScore().getScore()+1);
    }

    private Goal getGoal(GoalKeeper goalKeeper){
        boolean found = false;
        int i = 0;
        Goal result = null;
        while (i<map.getGoalsGoalKeepers().size() && !found){
            if (map.getGoalsGoalKeepers().get(i).getGoalKeeper().equals(goalKeeper)){
                result = map.getGoalsGoalKeepers().get(i).getGoal();
                found = true;
            }
        }
        if(!found){
            throw new InvalidParameterException("Cannot find the goalKeeper in the list");
        }
        else {
            return result;
        }
    }

    private GoalKeeper getGoalKeeper(Goal goal){
        boolean found = false;
        int i = 0;
        GoalKeeper result = null;
        while (i<map.getGoalsGoalKeepers().size() && !found){
            if (map.getGoalsGoalKeepers().get(i).getGoal().equals(goal)){
                result = map.getGoalsGoalKeepers().get(i).getGoalKeeper();
                found = true;
            }
        }
        if(!found){
            throw new InvalidParameterException("Cannot find the goal in the list");
        }
        else {
            return result;
        }
    }

    @Override
    public void centerGoalKeepers() {
        for (GoalGoalKeeper goalGoalKeeper: map.getGoalsGoalKeepers()) {
            if(goalGoalKeeper.getGoalKeeper().getActualPosition().equals(goalGoalKeeper.getGoalKeeper().getTargetPosition())){
                Position targetPosition = new Position();
                targetPosition.setX((goalGoalKeeper.getGoal().getGoalStartLine().getStartPosition().getX()+goalGoalKeeper.getGoal().getGoalStartLine().getEndPosition().getX())/2);
                targetPosition.setY((goalGoalKeeper.getGoal().getGoalStartLine().getStartPosition().getY()+goalGoalKeeper.getGoal().getGoalStartLine().getEndPosition().getY())/2);
                goalGoalKeeper.getGoalKeeper().setTargetPosition(targetPosition);
            }
        }
    }

    @Override
    public void update() {
        this.goalDetection();
        this.checkBallInDetectionArea();
        this.centerGoalKeepers();
        this.move();
    }
}
