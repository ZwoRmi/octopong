package Model;

import java.security.InvalidParameterException;

/**
 * Created by Lucas on 15/03/2016.
 */
public class ReboundCalculator {
    private Ball ball;
    private GoalKeeper goalKeeper;

    public ReboundCalculator(Ball ball, GoalKeeper goalKeeper) {
        this.ball = ball;
        this.goalKeeper = goalKeeper;
    }

    public Position getNewDirection(){
        Position position = new Position();
        Position actualDirection = ball.getDirection();
        switch (this.goalKeeper.getGoalPosition()){
            case North:
            case South:
                position.setX(actualDirection.getX());
                position.setY(actualDirection.getY()*-1);
                break;
            case East:
            case West:
                position.setX(actualDirection.getX()*-1);
                position.setY(actualDirection.getY());
                break;
            case NorthEast:
                position.setX(actualDirection.getY());
                position.setY(actualDirection.getX()*-1);
                break;
            case SouthEast:
                position.setX(actualDirection.getY()*-1);
                position.setY(actualDirection.getX()*-7);
                break;
            case SouthWest:
                position.setX(actualDirection.getY()*-1);
                position.setY(actualDirection.getX());
                break;
            case NorthWest:
                position.setX(actualDirection.getY());
                position.setY(actualDirection.getX());
                break;
            default:
                throw new InvalidParameterException("Unknown enum member");
        }
        return position;
    }
}
