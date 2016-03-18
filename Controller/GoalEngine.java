package Controller;

import Model.*;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by Lucas on 14/03/2016.
 */
public class GoalEngine implements IGoalEngine {
    private Map map;
    private ArrayList<Ball> ballsToRemove;

    public GoalEngine(Map aMap) {
        this.map = aMap;
        ballsToRemove = new ArrayList<>();
    }

    @Override
    public void move() {
        for (GoalGoalKeeper goalGoalKeeper: this.map.getGoalsGoalKeepers()) {
            GoalKeeper goalKeeper = goalGoalKeeper.getGoalKeeper();
            this.moveGoalKeeper(goalKeeper);
        }
    }

    private void moveGoalKeeper(GoalKeeper goalKeeper) {
        float speed = goalKeeper.getSpeed();
        Position targetDirection= this.getGoalDirection(goalKeeper);
        goalKeeper.setActualPositionStart(this.getTargetPosition(goalKeeper.getActualPositionStart(), targetDirection, speed));
        goalKeeper.setActualPositionEnd(this.getTargetPosition(goalKeeper.getActualPositionEnd(), targetDirection, speed));
    }

    private Position getGoalDirection(GoalKeeper goalKeeper) {
        Position generalPosition = this.getGoalDirectionGeneral(goalKeeper);
        switch (goalKeeper.getGoalPosition()){
            case North:
            case South:
                generalPosition.setY(0);
                break;
            case West:
            case East:
                generalPosition.setX(0);
                break;
        }
        return generalPosition;
    }

    private Line getTargetPosition(Line actualPosition, Position targetDirection, float speed){
        Line targetPosition = new Line();
        Position startPosition = new Position();
        Position endPosition = new Position();
        startPosition.setX(actualPosition.getStartPosition().getX() + targetDirection.getX() * speed);
        startPosition.setY(actualPosition.getStartPosition().getY() + targetDirection.getY() * speed);
        endPosition.setX(actualPosition.getEndPosition().getX() + targetDirection.getX() * speed);
        endPosition.setY(actualPosition.getEndPosition().getY() + targetDirection.getY() * speed);
        targetPosition.setStartPosition(startPosition);
        targetPosition.setEndPosition(endPosition);
        return targetPosition;
    }

    private Position getGoalDirectionGeneral(GoalKeeper g){
        Position direction = new Position();
        Position actualPosition = g.getActualPositionStart().getStartPosition();
        Position targetPosition = g.getTargetPosition().getStartPosition();
        if(actualPosition.getX()<targetPosition.getX()){
            direction.setX(-1);
        }
        else if (actualPosition.getX()>targetPosition.getX())
        {
            direction.setX(1);
        }
        else {
            direction.setX(0);
        }
        if(actualPosition.getY()<targetPosition.getY()){
            direction.setY(-1);
        }
        else if (actualPosition.getY()>targetPosition.getY())
        {
            direction.setY(1);
        }
        else {
            direction.setY(0);
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
        long minCount = 1000000000;
        BallWithTargetPosition ballWithTargetPosition = null;
        if (ballWithTargetPositions.size()==0)
            return goalKeeper.getActualPositionStart();
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

        Position middleGoalKeeperStart = new Position();
        middleGoalKeeperStart.setX(
                (goalKeeper.getActualPositionStart().getStartPosition().getX()+
                goalKeeper.getActualPositionStart().getEndPosition().getX())/2);
        middleGoalKeeperStart.setY(
                (goalKeeper.getActualPositionStart().getStartPosition().getY()+
                goalKeeper.getActualPositionStart().getEndPosition().getY())/2);
        Position middleGoalKeeperEnd = new Position();
        middleGoalKeeperEnd.setX(
                (goalKeeper.getActualPositionEnd().getStartPosition().getX()+
                goalKeeper.getActualPositionEnd().getEndPosition().getX())/2);
        middleGoalKeeperEnd.setY(
                (goalKeeper.getActualPositionEnd().getStartPosition().getY()+
                goalKeeper.getActualPositionEnd().getEndPosition().getY())/2);
        float differenceXStart = middleGoalKeeperStart.getX()-positionToGo.getX();
        float differenceYStart = middleGoalKeeperStart.getY()-positionToGo.getY();
        float differenceXEnd = middleGoalKeeperEnd.getX()-positionToGo.getX();
        float differenceYEnd = middleGoalKeeperEnd.getY()-positionToGo.getY();


        Position startPosition = new Position();
        startPosition.setX(goalKeeper.getActualPositionStart().getStartPosition().getX()+differenceXStart);
        startPosition.setY(goalKeeper.getActualPositionStart().getStartPosition().getY()+differenceYStart);
        targetLinePosition.setStartPosition(startPosition);
        Position endPosition = new Position();
        endPosition.setX(goalKeeper.getActualPositionStart().getEndPosition().getX()+differenceXEnd);
        endPosition.setY(goalKeeper.getActualPositionStart().getEndPosition().getY()+differenceYEnd);
        targetLinePosition.setEndPosition(startPosition);
        return targetLinePosition;
    }

    private ArrayList<BallWithTargetPosition> getBallsWithTargetPosition(GoalGoalKeeper goalGoalKeeper, ArrayList<Ball> ballsInDetectionArea) {
        ArrayList<BallWithTargetPosition> ballWithTargetPositions = new ArrayList<BallWithTargetPosition>();
        for (Ball ball : ballsInDetectionArea) {
            Position fakePosition = ball.getActualPosition();
            int count = 0;
            while(!this.isGoal(fakePosition, goalGoalKeeper.getGoal()) && count<1000){
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
        PolygonBoundary boundary = new PolygonBoundary(goal.getGoalStartLine(), goal.getDetectionLine());
        synchronized (this.map.getBalls()){
        for (Ball ball : this.map.getBalls()) {
            if (boundary.contains(ball.getActualPosition())){
                ballsInArea.add(ball);
            }
        }}
        return ballsInArea;
    }

    @Override
    public void goalDetection() {
        synchronized (this.map.getBalls()){
            for (Ball ball : this.map.getBalls()) {
                for (GoalGoalKeeper goalGoalKeeper : this.map.getGoalsGoalKeepers()) {
                    if (this.isGoal(ball.getActualPosition(), goalGoalKeeper.getGoal())){
                        this.onGoal(goalGoalKeeper.getGoal(), ball);
                    }
                }
            }
        }
    }

    private boolean isGoal(Position ballPosition, Goal goal) {
        PolygonBoundary boundary = new PolygonBoundary(goal.getGoalStartLine(),goal.getGoalEndLine());
        return boundary.contains(ballPosition);
    }

    @Override
    public void onGoal(Goal goal, Ball ball) {
        this.updateScore(goal);
        this.ballsToRemove.add(ball);
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
            i++;
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
            if(goalGoalKeeper.getGoalKeeper().getActualPositionStart().equals(goalGoalKeeper.getGoalKeeper().getTargetPosition())){
                //Position targetPosition = new Position();
                //targetPosition.setX((goalGoalKeeper.getGoal().getGoalStartLine().getStartPosition().getX()+goalGoalKeeper.getGoal().getGoalStartLine().getEndPosition().getX())/2);
                //targetPosition.setY((goalGoalKeeper.getGoal().getGoalStartLine().getStartPosition().getY()+goalGoalKeeper.getGoal().getGoalStartLine().getEndPosition().getY())/2);
                //goalGoalKeeper.getGoalKeeper().setTargetPosition(this.getTargetLine(targetPosition, goalGoalKeeper.getGoalKeeper()));
            }
        }
    }

    @Override
    public void update() {
        this.goalDetection();
        this.checkBallInDetectionArea();
        this.removeBallsInGoal();
        this.centerGoalKeepers();
        this.move();
    }

    private void removeBallsInGoal() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        synchronized (this.map.getBalls()){
        for (Ball ball : this.map.getBalls()) {
                if(!ball.getNeedToRemove()){
                    ball.setNeedToRemove(ball.getActualPosition().getX() > width ||
                            ball.getActualPosition().getY() > height ||
                            ball.getActualPosition().getX() <0||
                            ball.getActualPosition().getY()<0);
                }
            }
        }
        for (Ball ball : this.ballsToRemove) {
            ball.setNeedToRemove(true);
        }
        this.ballsToRemove.clear();
    }
}
