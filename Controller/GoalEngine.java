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
        for (GoalGoalKeeper goalGoalKeeper: this.map.getGoalsGoalKeepers()) {
            GoalKeeper goalKeeper = goalGoalKeeper.getGoalKeeper();
            this.moveGoalKeeper(goalKeeper);
        }
    }

    private void moveGoalKeeper(GoalKeeper goalKeeper) {
        Line actualPosition = goalKeeper.getActualPosition();
        Position targetDirection= this.getGoalDirection(goalKeeper);
        Line targetPosition = new Line();
        Position startPosition = new Position();
        Position endPosition = new Position();
        startPosition.setX(actualPosition.getStartPosition().getX() + targetDirection.getX() * this.map.getBallSpeed());
        startPosition.setY(actualPosition.getStartPosition().getY() + targetDirection.getY() * this.map.getBallSpeed());
        endPosition.setX(actualPosition.getEndPosition().getX() + targetDirection.getX() * this.map.getBallSpeed());
        endPosition.setY(actualPosition.getEndPosition().getY() + targetDirection.getY() * this.map.getBallSpeed());
        goalKeeper.setActualPosition(targetPosition);
    }

    private Position getGoalDirection(GoalKeeper g){
        Position direction = new Position();
        Position actualPosition = g.getActualPosition().getStartPosition();
        Position targetPosition = g.getTargetPosition().getStartPosition();
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

    @Override
    public void checkBallInDetectionArea() {
        for (GoalGoalKeeper goalGoalKeeper: this.map.getGoalsGoalKeepers()) {
            Goal goal = goalGoalKeeper.getGoal();
            this.UpdateGoalTargetPosition(goalGoalKeeper, this.getBallsInDetectionArea(goal));
        }
    }

    private void UpdateGoalTargetPosition(GoalGoalKeeper goalGoalKeeper, ArrayList<Ball> ballsInDetectionArea) {
        ArrayList<BallWithTargetPosition> ballWithTargetPositions = this.getBallsWithTargetPosition(goalGoalKeeper, ballsInDetectionArea);
        Line targetPosition = this.getPositionToStopBall(ballWithTargetPositions, goalGoalKeeper.getGoalKeeper());
        goalGoalKeeper.getGoalKeeper().setTargetPosition(targetPosition);
    }

    private Line getPositionToStopBall(ArrayList<BallWithTargetPosition> ballWithTargetPositions, GoalKeeper goalKeeper) {
        int minCount = 1000000;
        BallWithTargetPosition ballWithTargetPosition = null;
        for (BallWithTargetPosition currentBallWithTargetPosition:ballWithTargetPositions) {
            if (currentBallWithTargetPosition.getCountToGoToTargetPosition()<minCount){
                minCount = currentBallWithTargetPosition.getCountToGoToTargetPosition();
                ballWithTargetPosition = currentBallWithTargetPosition;
            }
        }
        return this.getTargetLine(ballWithTargetPosition.getTargetPosition(), goalKeeper);
    }

    private Line getTargetLine(Position positionToGo, GoalKeeper goalKeeper) {
        Line targetLinePosition = new Line();
        Position startPosition = new Position();
        startPosition.setX(positionToGo.getX()-
                (goalKeeper.getActualPosition().getStartPosition().getX()+ goalKeeper.getActualPosition().getEndPosition().getX())/2);
        startPosition.setY(positionToGo.getY()-
                (goalKeeper.getActualPosition().getStartPosition().getY()+goalKeeper.getActualPosition().getEndPosition().getY())/2);
        targetLinePosition.setStartPosition(startPosition);
        Position endPosition = new Position();
        endPosition.setX(positionToGo.getX()+
                (goalKeeper.getActualPosition().getStartPosition().getX()+goalKeeper.getActualPosition().getEndPosition().getX())/2);
        endPosition.setY(positionToGo.getY()+
                (goalKeeper.getActualPosition().getStartPosition().getY()+goalKeeper.getActualPosition().getEndPosition().getY())/2);
        targetLinePosition.setStartPosition(startPosition);
        return targetLinePosition;
    }

    private ArrayList<BallWithTargetPosition> getBallsWithTargetPosition(GoalGoalKeeper goalGoalKeeper, ArrayList<Ball> ballsInDetectionArea) {
        ArrayList<BallWithTargetPosition> ballWithTargetPositions = new ArrayList<BallWithTargetPosition>();
        for (Ball ball : ballsInDetectionArea) {
            Position fakePosition = ball.getActualPosition();
            int count = 0;
            while(!this.isGoal(ball, goalGoalKeeper.getGoal())){
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
        Position targetPosition = new Position();
        targetPosition.setX(fakePosition.getX() + ball.getDirection().getX() * this.map.getBallSpeed());
        targetPosition.setY(fakePosition.getY() + ball.getDirection().getY() * this.map.getBallSpeed());
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
            for (GoalGoalKeeper goalGoalKeeper : this.map.getGoalsGoalKeepers()) {
                if (this.isGoal(ball, goalGoalKeeper.getGoal())){
                    this.onGoal(goalGoalKeeper.getGoal(), ball);
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

    private GoalKeeper getGoalKeeper(Goal goal){
        boolean found = false;
        int i = 0;
        GoalKeeper result = null;
        while (i< this.map.getGoalsGoalKeepers().size() && !found){
            if (this.map.getGoalsGoalKeepers().get(i).getGoal().equals(goal)){
                result = this.map.getGoalsGoalKeepers().get(i).getGoalKeeper();
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
        for (GoalGoalKeeper goalGoalKeeper: this.map.getGoalsGoalKeepers()) {
            if(goalGoalKeeper.getGoalKeeper().getActualPosition().equals(goalGoalKeeper.getGoalKeeper().getTargetPosition())){
                Position targetPosition = new Position();
                targetPosition.setX((goalGoalKeeper.getGoal().getGoalStartLine().getStartPosition().getX()+goalGoalKeeper.getGoal().getGoalStartLine().getEndPosition().getX())/2);
                targetPosition.setY((goalGoalKeeper.getGoal().getGoalStartLine().getStartPosition().getY()+goalGoalKeeper.getGoal().getGoalStartLine().getEndPosition().getY())/2);
                goalGoalKeeper.getGoalKeeper().setTargetPosition(this.getTargetLine(targetPosition, goalGoalKeeper.getGoalKeeper()));
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
