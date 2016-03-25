package Controller;

import Model.*;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GoalEngine implements IGoalEngine {
    private final IMap IMap;
    private final ArrayList<Ball> ballsToRemove;

    public GoalEngine(IMap aIMap) {
        this.IMap = aIMap;
        this.ballsToRemove = new ArrayList<>();
    }

    @Override
    public void move() {
        for (GoalGoalKeeper goalGoalKeeper : this.IMap.getGoalsGoalKeepers()) {
            GoalKeeper goalKeeper = goalGoalKeeper.getGoalKeeper();
            if(!goalGoalKeeper.getGoalKeeper().getPlayedByHuman())
                this.moveGoalKeeper(goalKeeper);
        }
    }

    private void moveGoalKeeper(GoalKeeper goalKeeper) {
        float speed = goalKeeper.getSpeed();
        Position targetDirection= this.getGoalDirection(goalKeeper);
        Line targetPositionStart = this.getTargetPosition(goalKeeper.getActualPositionStart(), targetDirection, speed);
        if (this.isInLimitedArea(goalKeeper, targetPositionStart)){
            goalKeeper.setActualPositionStart(targetPositionStart);
            goalKeeper.setActualPositionEnd(this.getTargetPosition(goalKeeper.getActualPositionEnd(), targetDirection, speed));
        }

    }

    @Override
    public boolean isInLimitedArea(GoalKeeper goalKeeper, Line targetPositionStart) {
        Line goalLine = this.getGoal(goalKeeper).getGoalStartLine();
        switch (goalKeeper.getGoalPosition()){
            case North:
                return goalLine.getStartPosition().getX()<targetPositionStart.getStartPosition().getX() &&
                        goalLine.getEndPosition().getX()>targetPositionStart.getEndPosition().getX() ;
            case South:
                return goalLine.getStartPosition().getX()>targetPositionStart.getStartPosition().getX() &&
                       goalLine.getEndPosition().getX()<targetPositionStart.getEndPosition().getX() ;
            case East:
                return goalLine.getStartPosition().getY()<targetPositionStart.getStartPosition().getY() &&
                        goalLine.getEndPosition().getY()>targetPositionStart.getEndPosition().getY() ;
            case West:
                return goalLine.getStartPosition().getY()>targetPositionStart.getStartPosition().getY() &&
                        goalLine.getEndPosition().getY()<targetPositionStart.getEndPosition().getY() ;
            case NorthEast:
                return goalLine.getStartPosition().getX()<targetPositionStart.getStartPosition().getX() &&
                        goalLine.getEndPosition().getX()>targetPositionStart.getEndPosition().getX() &&
                        goalLine.getStartPosition().getY()<targetPositionStart.getStartPosition().getY() &&
                        goalLine.getEndPosition().getY()>targetPositionStart.getEndPosition().getY() ;
            case NorthWest:
                return goalLine.getStartPosition().getX()<targetPositionStart.getStartPosition().getX() &&
                        goalLine.getEndPosition().getX()>targetPositionStart.getEndPosition().getX() &&
                        goalLine.getStartPosition().getY()>targetPositionStart.getStartPosition().getY() &&
                        goalLine.getEndPosition().getY()<targetPositionStart.getEndPosition().getY() ;
            case SouthEast:
                return goalLine.getStartPosition().getX()>targetPositionStart.getStartPosition().getX() &&
                        goalLine.getEndPosition().getX()<targetPositionStart.getEndPosition().getX() &&
                        goalLine.getStartPosition().getY()<targetPositionStart.getStartPosition().getY() &&
                        goalLine.getEndPosition().getY()>targetPositionStart.getEndPosition().getY() ;
            case SouthWest:
                return goalLine.getStartPosition().getX()>targetPositionStart.getStartPosition().getX() &&
                        goalLine.getEndPosition().getX()<targetPositionStart.getEndPosition().getX() &&
                        goalLine.getStartPosition().getY()>targetPositionStart.getStartPosition().getY() &&
                        goalLine.getEndPosition().getY()<targetPositionStart.getEndPosition().getY() ;

        }
        return false;
    }

    private Goal getGoal(GoalKeeper goalKeeper) {
        boolean found = false;
        int i = 0;
        Goal result = null;
        while (i < this.IMap.getGoalsGoalKeepers().size() && !found) {
            if (this.IMap.getGoalsGoalKeepers().get(i).getGoalKeeper().equals(goalKeeper)) {
                result = this.IMap.getGoalsGoalKeepers().get(i).getGoal();
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
            case NorthWest:
            case SouthEast:
                if (generalPosition.getX()!=(generalPosition.getY()*-1)){
                    generalPosition.setX(0);
                    generalPosition.setY(0);
                }
                break;
            case NorthEast:
            case SouthWest:
                if (generalPosition.getX()!=generalPosition.getY()){
                    generalPosition.setX(0);
                    generalPosition.setY(0);
                }
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
            direction.setX(1);
        }
        else if (actualPosition.getX()>targetPosition.getX())
        {
            direction.setX(-1);
        }
        else {
            direction.setX(0);
        }
        if(actualPosition.getY()<targetPosition.getY()){
            direction.setY(1);
        }
        else if (actualPosition.getY()>targetPosition.getY())
        {
            direction.setY(-1);
        }
        else {
            direction.setY(0);
        }
        return direction;
    }

    @Override
    public void checkBallInDetectionArea() {
        for (GoalGoalKeeper goalGoalKeeper : this.IMap.getGoalsGoalKeepers()) {
            this.UpdateGoalTargetPosition(goalGoalKeeper, this.getBallsInDetectionArea(goalGoalKeeper));
        }
    }

    private void UpdateGoalTargetPosition(GoalGoalKeeper goalGoalKeeper, ArrayList<Ball> ballsInDetectionArea) {
        ArrayList<BallWithTargetPosition> ballWithTargetPositions = this.getBallsWithTargetPosition(goalGoalKeeper, ballsInDetectionArea);
        Line targetPosition = this.getPositionToStopBall(ballWithTargetPositions, goalGoalKeeper.getGoalKeeper());
        if (targetPosition!=null)
            goalGoalKeeper.getGoalKeeper().setTargetPosition(targetPosition);
    }

    private Line getPositionToStopBall(ArrayList<BallWithTargetPosition> ballWithTargetPositions, GoalKeeper goalKeeper) {
        long minCount = 1000;
        BallWithTargetPosition ballWithTargetPosition = null;
        if (ballWithTargetPositions.size()>0){
            for (BallWithTargetPosition currentBallWithTargetPosition:ballWithTargetPositions) {
                if (currentBallWithTargetPosition.getCountToGoToTargetPosition()<minCount){
                    minCount = currentBallWithTargetPosition.getCountToGoToTargetPosition();
                    ballWithTargetPosition = currentBallWithTargetPosition;
                }
            }
            if (minCount>=1000){
                return goalKeeper.getActualPositionStart();
            }
            return this.getTargetLine(ballWithTargetPosition.getTargetPosition(), goalKeeper);
        }
        return null;
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
        startPosition.setX(goalKeeper.getActualPositionStart().getStartPosition().getX()-differenceXStart);
        startPosition.setY(goalKeeper.getActualPositionStart().getStartPosition().getY()-differenceYStart);
        targetLinePosition.setStartPosition(startPosition);
        Position endPosition = new Position();
        endPosition.setX(goalKeeper.getActualPositionStart().getEndPosition().getX()-differenceXEnd);
        endPosition.setY(goalKeeper.getActualPositionStart().getEndPosition().getY()-differenceYEnd);
        targetLinePosition.setEndPosition(startPosition);
        return targetLinePosition;
    }

    private ArrayList<BallWithTargetPosition> getBallsWithTargetPosition(GoalGoalKeeper goalGoalKeeper, ArrayList<Ball> ballsInDetectionArea) {
        ArrayList<BallWithTargetPosition> ballWithTargetPositions = new ArrayList<>();
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
        targetPosition.setX(fakePosition.getX() + ball.getDirection().getX() * this.IMap.getBallSpeed());
        targetPosition.setY(fakePosition.getY() + ball.getDirection().getY() * this.IMap.getBallSpeed());
        return targetPosition;
    }

    private ArrayList<Ball> getBallsInDetectionArea(GoalGoalKeeper goalGoalKeeper) {
        ArrayList<Ball> ballsInArea = new ArrayList<>();
        PolygonBoundary boundary = new PolygonBoundary(goalGoalKeeper.getGoal().getGoalStartLine(), goalGoalKeeper.getGoal().getDetectionLine());
        synchronized (this.IMap.getBalls()) {
            ballsInArea.addAll(this.IMap.getBalls().stream().filter(ball -> boundary.contains(ball.getActualPosition()) &&
                    new ReboundCalculator(ball, goalGoalKeeper.getGoalKeeper()).isMovingToGoalKeeper()).collect(Collectors.toList()));
        }
        return ballsInArea;
    }

    @Override
    public void goalDetection() {
        synchronized (this.IMap.getBalls()) {
            for (Ball ball : this.IMap.getBalls()) {
                this.IMap.getGoalsGoalKeepers().stream().filter(goalGoalKeeper -> this.isGoal(ball.getActualPosition(),
                        goalGoalKeeper.getGoal())).forEach(goalGoalKeeper -> this.onGoal(goalGoalKeeper.getGoal(), ball));
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
        while (i < this.IMap.getGoalsGoalKeepers().size() && !found) {
            if (this.IMap.getGoalsGoalKeepers().get(i).getGoal().equals(goal)) {
                result = this.IMap.getGoalsGoalKeepers().get(i).getGoalKeeper();
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
        this.IMap.getGoalsGoalKeepers().stream().filter(goalGoalKeeper -> this.getBallsInDetectionArea(goalGoalKeeper).isEmpty()).forEach(goalGoalKeeper -> {
            PositionProvider positionProvider = new PositionProvider();
            goalGoalKeeper.getGoalKeeper().setTargetPosition(new Line(positionProvider.getGoalKeeperPositionStart(positionProvider.getStartGoalPosition(goalGoalKeeper.getGoalKeeper().getGoalPosition())), positionProvider.getGoalKeeperPositionStart(positionProvider.getEndGoalPosition(goalGoalKeeper.getGoalKeeper().getGoalPosition()))));
        });
    }

    @Override
    public void update() {
        this.centerGoalKeepers();
        this.goalDetection();
        this.removeBallsInGoal();
        this.checkBallInDetectionArea();
        this.move();
    }

    private void removeBallsInGoal() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        synchronized (this.IMap.getBalls()) {
            this.IMap.getBalls().stream().filter(ball -> !ball.getNeedToRemove()).forEach(ball ->
                    ball.setNeedToRemove(ball.getActualPosition().getX() > width ||
                    ball.getActualPosition().getY() > height ||
                    ball.getActualPosition().getX() < 0 ||
                    ball.getActualPosition().getY() < 0));
        }
        for (Ball ball : this.ballsToRemove) {
            ball.setNeedToRemove(true);
        }
        this.ballsToRemove.clear();
        synchronized (this.IMap.getBalls()) {
            this.IMap.getBalls().removeIf(Ball::getNeedToRemove);
        }
    }
}
