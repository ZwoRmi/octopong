package Model;

import java.util.ArrayList;

/**
 * Created by Lucas on 14/03/2016.
 */
public class MapFactory {
    private PositionProvider positionProvider;

    public Map create(){
        Map map = new Map();
        map.setBallSpeed(1);
        map.setBallSpawnInterval(1);
        map.setBalls(this.getBalls());
        map.setGoalsGoalKeepers(this.getGoalsGoalKeepers());
        return map;
    }

    private ArrayList<Ball> getBalls() {
        ArrayList<Ball> balls = new ArrayList<Ball>();
        balls.add(this.getFirstBall());
        return balls;
    }

    private Ball getFirstBall() {
        Position ballPosition = new Position();
        ballPosition.setX(0);
        ballPosition.setY(0);
        Ball ball = new Ball();
        ball.setActualPosition(ballPosition);
        ball.setDirection(new RandomPositionGenerator().generatePosition());
        return ball;
    }

    private ArrayList<GoalGoalKeeper> getGoalsGoalKeepers() {
        this.positionProvider = new PositionProvider();
        ArrayList<GoalGoalKeeper> goalGoalKeepers = new ArrayList<GoalGoalKeeper>();
        goalGoalKeepers.add(this.getGoalGoalKeeper(GoalPosition.North));
        goalGoalKeepers.add(this.getGoalGoalKeeper(GoalPosition.NorthWest));
        goalGoalKeepers.add(this.getGoalGoalKeeper(GoalPosition.West));
        goalGoalKeepers.add(this.getGoalGoalKeeper(GoalPosition.SouthWest));
        goalGoalKeepers.add(this.getGoalGoalKeeper(GoalPosition.South));
        goalGoalKeepers.add(this.getGoalGoalKeeper(GoalPosition.SouthEast));
        goalGoalKeepers.add(this.getGoalGoalKeeper(GoalPosition.East));
        goalGoalKeepers.add(this.getGoalGoalKeeper(GoalPosition.NorthEast));
        return goalGoalKeepers;
    }

    private GoalGoalKeeper getGoalGoalKeeper(GoalPosition goalPosition) {
        GoalGoalKeeper goalGoalKeeper = new GoalGoalKeeper();
        goalGoalKeeper.setGoal(this.getGoal(
                this.positionProvider.getStartGoalPosition(goalPosition),
                this.positionProvider.getEndGoalPosition(goalPosition)));
        goalGoalKeeper.setGoalKeeper(this.getGoalKeeper(goalPosition));
        return goalGoalKeeper;
    }

    private GoalKeeper getGoalKeeper(GoalPosition goalPosition) {
        GoalKeeper goalKeeper = new GoalKeeper();
        Score score = new Score();
        score.setScore(0);
        score.setPosition(this.positionProvider.getScorePosition(goalPosition));
        goalKeeper.setScore(score);
        goalKeeper.setActualPosition(new Line(
                this.positionProvider.getGoalKeeperPosition(this.positionProvider.getStartGoalPosition(goalPosition)),
                this.positionProvider.getGoalKeeperPosition(this.positionProvider.getEndGoalPosition(goalPosition))));
        goalKeeper.setGoalPosition(goalPosition);
        goalKeeper.setSpeed(1);
        goalKeeper.setTargetPosition(goalKeeper.getActualPosition());
        return null;
    }

    private Goal getGoal(GoalPositions startPosition, GoalPositions endPosition) {
        Goal goal = new Goal();
        Line lineGoalStart = new Line();
        lineGoalStart.setStartPosition(this.positionProvider.getPositionGoalStart(startPosition));
        lineGoalStart.setEndPosition(this.positionProvider.getPositionGoalStart(endPosition));
        goal.setGoalStartLine(lineGoalStart);
        Line lineGoalEnd = new Line();
        lineGoalEnd.setStartPosition(this.positionProvider.getPositionGoalEnd(startPosition));
        lineGoalEnd.setEndPosition(this.positionProvider.getPositionGoalEnd(endPosition));
        goal.setGoalEndLine(lineGoalEnd);
        Line detectionLineGoal = new Line();
        detectionLineGoal.setStartPosition(this.positionProvider.getPositionDetectionLine(startPosition));
        detectionLineGoal.setEndPosition(this.positionProvider.getPositionDetectionLine(endPosition));
        goal.setGoalEndLine(detectionLineGoal);
        return goal;
    }
}
