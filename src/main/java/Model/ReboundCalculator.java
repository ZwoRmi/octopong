package Model;

public class ReboundCalculator {
    private final Ball ball;
    private final GoalKeeper goalKeeper;

    public ReboundCalculator(Ball ball, GoalKeeper goalKeeper) {
        this.ball = ball;
        this.goalKeeper = goalKeeper;
    }

    public Position getNewDirection(){
        Position position = new Position();
        Position actualDirection = this.ball.getDirection();
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
                position.setY(actualDirection.getX());
                break;
            case SouthEast:
                position.setX(actualDirection.getY()*-1);
                position.setY(actualDirection.getX()*-1);
                break;
            case SouthWest:
                position.setX(actualDirection.getY());
                position.setY(actualDirection.getX());
                break;
            case NorthWest:
                position.setX(actualDirection.getY()*-1);
                position.setY(actualDirection.getX()*-1);
                break;
        }
        return position;
    }

    public boolean isMovingToGoalKeeper(){
        boolean result = false;
        switch (this.goalKeeper.getGoalPosition()){
            case North:
                result = this.ball.getDirection().getY()<0;
                break;
            case NorthEast:
                result = this.ball.getDirection().getX()>0 || this.ball.getDirection().getY()<0 ;
                break;
            case East:
                result = this.ball.getDirection().getX()>0;
                break;
            case SouthEast:
                result = this.ball.getDirection().getX()>0 || this.ball.getDirection().getY()>0;
                break;
            case South:
                result = this.ball.getDirection().getY()>0;
                break;
            case SouthWest:
                result = this.ball.getDirection().getX()<0 || this.ball.getDirection().getY()>0;
                break;
            case West:
                result = this.ball.getDirection().getX()<0;
                break;
            case NorthWest:
                result = this.ball.getDirection().getX()<0 || this.ball.getDirection().getY()<0;
                break;
        }
        return result;
    }
}
