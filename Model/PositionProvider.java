package Model;

public class PositionProvider {
    public Position getPositionGoalStart(GoalPositions goalPositions){
        Position position = new Position();
        switch (goalPositions){
            case StartNorth:
                position.setX(512);
                position.setY(95);
                break;
            case EndNorth:
                position.setX(692);
                position.setY(95);
                break;
            case StartNorthEast:
                position.setX(692);
                position.setY(95);
                break;
            case EndNorthEast:
                position.setX(821);
                position.setY(224);
                break;
            case StartEast:
                position.setX(821);
                position.setY(224);
                break;
            case EndEast:
                position.setX(821);
                position.setY(404);
                break;
            case StartSouthEast:
                position.setX(821);
                position.setY(404);
                break;
            case EndSouthEast:
                position.setX(692);
                position.setY(533);
                break;
            case StartSouth:
                position.setX(692);
                position.setY(533);
                break;
            case EndSouth:
                position.setX(512);
                position.setY(533);
                break;
            case StartSouthWest:
                position.setX(512);
                position.setY(533);
                break;
            case EndSouthWest:
                position.setX(383);
                position.setY(404);
                break;
            case StartWest:
                position.setX(383);
                position.setY(404);
                break;
            case EndWest:
                position.setX(383);
                position.setY(224);
                break;
            case StartNorthWest:
                position.setX(383);
                position.setY(224);
                break;
            case EndNorthWest:
                position.setX(512);
                position.setY(95);
                break;

        }
        return position;
    }

    public Position getPositionGoalEnd(GoalPositions goalPositions){
        Position resultPosition = new Position();
        Position positionGoalStart = this.getPositionGoalStart(goalPositions);
        Position positionDetectionLine = this.getPositionDetectionLine(goalPositions);
        float xDifference = positionGoalStart.getX()-positionDetectionLine.getX();
        float yDifference = positionGoalStart.getY()-positionDetectionLine.getY();
        resultPosition.setX(positionGoalStart.getX()+xDifference/2);
        resultPosition.setY(positionGoalStart.getY()+yDifference/2);
        return resultPosition;
    }

    public Position getPositionDetectionLine(GoalPositions goalPositions){
        Position position = new Position();
        switch (goalPositions){
            case StartNorth:
                position.setX(531);
                position.setY(147);
                break;
            case EndNorth:
                position.setX(673);
                position.setY(147);
                break;
            case StartNorthEast:
                position.setX(673);
                position.setY(147);
                break;
            case EndNorthEast:
                position.setX(772);
                position.setY(245);
                break;
            case StartEast:
                position.setX(772);
                position.setY(245);
                break;
            case EndEast:
                position.setX(772);
                position.setY(383);
                break;
            case StartSouthEast:
                position.setX(772);
                position.setY(383);
                break;
            case EndSouthEast:
                position.setX(673);
                position.setY(481);
                break;
            case StartSouth:
                position.setX(673);
                position.setY(481);
                break;
            case EndSouth:
                position.setX(531);
                position.setY(481);
                break;
            case StartSouthWest:
                position.setX(531);
                position.setY(481);
                break;
            case EndSouthWest:
                position.setX(431);
                position.setY(383);
                break;
            case StartWest:
                position.setX(431);
                position.setY(383);
                break;
            case EndWest:
                position.setX(431);
                position.setY(245);
                break;
            case StartNorthWest:
                position.setX(431);
                position.setY(245);
                break;
            case EndNorthWest:
                position.setX(531);
                position.setY(147);
                break;
        }
        return position;
    }

    public Position getScorePosition(GoalPosition goalPosition) {
        int addToPos = 30;
        int downY = 9;
        int leftX = 9;
        int addToPosAngle = 25;

        Position position = new Position();
        switch (goalPosition){
            case North:
                position.setX(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getX()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getX())/2) - leftX
                );
                position.setY(this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getY()-addToPos);
                break;
            case NorthEast:
                position.setX(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getX()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getX())/2)+addToPosAngle
                );
                position.setY(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getY()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getY())/2)-addToPosAngle
                );
                break;
            case East:
                position.setX(this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getX()+addToPos);
                position.setY(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getY()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getY())/2)
                );
                break;
            case SouthEast:
                position.setX(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getX()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getX())/2)+addToPosAngle
                );
                position.setY(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getY()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getY())/2)+addToPosAngle
                );
                break;
            case South:
                position.setX(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getX()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getX())/2)
                );
                position.setY(this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getY()+addToPos + downY);
                break;
            case SouthWest:
                position.setX(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getX()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getX())/2)-addToPosAngle - leftX
                );
                position.setY(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getY()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getY())/2)+addToPosAngle + downY
                );
                break;
            case West:
                position.setX(this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getX()-addToPos - leftX);
                position.setY(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getY()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getY())/2 + downY)
                );
                break;
            case NorthWest:
                position.setX(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getX()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getX())/2)-addToPosAngle - leftX
                );
                position.setY(((
                        this.getPositionGoalStart(this.getStartGoalPosition(goalPosition)).getY()+
                                this.getPositionGoalEnd(this.getEndGoalPosition(goalPosition)).getY())/2)-addToPosAngle + downY
                );
                break;
        }
        return position;
    }

    public Position getGoalKeeperPositionStart(GoalPositions goalPositions) {
        return this.getTranslatedGoalStartPosition(70,5,46,52.9999996847f, goalPositions);
    }

    public Position getGoalKeeperPositionEnd(GoalPositions goalPositions) {
        return this.getTranslatedGoalStartPosition(70,6f,45.5f,53.366656257f, goalPositions);
    }

    private Position getTranslatedGoalStartPosition(float step1, float step2, float step3, float step4, GoalPositions goalPositions) {
        Position pos = new Position();
        Position goalPosition = this.getPositionGoalStart(goalPositions);
        switch (goalPositions){
            case StartNorth:
                pos.setX(goalPosition.getX()+step1);
                pos.setY(goalPosition.getY()+step2);
                break;
            case EndNorth:
                pos.setX(goalPosition.getX()-step1);
                pos.setY(goalPosition.getY()+step2);
                break;
            case StartNorthEast:
                pos.setX(goalPosition.getX()+step3);
                pos.setY(goalPosition.getY()+step4);
                break;
            case EndNorthEast:
                pos.setX(goalPosition.getX()-step4);
                pos.setY(goalPosition.getY()-step3);
                break;
            case StartEast:
                pos.setX(goalPosition.getX()-step2);
                pos.setY(goalPosition.getY()+step1);
                break;
            case EndEast:
                pos.setX(goalPosition.getX()-step2);
                pos.setY(goalPosition.getY()-step1);
                break;
            case StartSouthEast:
                pos.setX(goalPosition.getX()-step4);
                pos.setY(goalPosition.getY()+step3);
                break;
            case EndSouthEast:
                pos.setX(goalPosition.getX()+step3);
                pos.setY(goalPosition.getY()-step4);
                break;
            case StartSouth:
                pos.setX(goalPosition.getX()-step1);
                pos.setY(goalPosition.getY()-step2);
                break;
            case EndSouth:
                pos.setX(goalPosition.getX()+step1);
                pos.setY(goalPosition.getY()-step2);
                break;
            case StartSouthWest:
                pos.setX(goalPosition.getX()-step3);
                pos.setY(goalPosition.getY()-step4);
                break;
            case EndSouthWest:
                pos.setX(goalPosition.getX()+step4);
                pos.setY(goalPosition.getY()+step3);
                break;
            case StartWest:
                pos.setX(goalPosition.getX()+step2);
                pos.setY(goalPosition.getY()-step1);
                break;
            case EndWest:
                pos.setX(goalPosition.getX()+step2);
                pos.setY(goalPosition.getY()+step1);
                break;
            case StartNorthWest:
                pos.setX(goalPosition.getX()+step4);
                pos.setY(goalPosition.getY()-step3);
                break;
            case EndNorthWest:
                pos.setX(goalPosition.getX()-step3);
                pos.setY(goalPosition.getY()+step4);
                break;
        }
        return pos;
    }


    public GoalPositions getStartGoalPosition(GoalPosition goalPosition){
        switch (goalPosition){
            case North:
                return GoalPositions.StartNorth;
            case NorthEast:
                return GoalPositions.StartNorthEast;
            case East:
                return GoalPositions.StartEast;
            case SouthEast:
                return GoalPositions.StartSouthEast;
            case South:
                return GoalPositions.StartSouth;
            case SouthWest:
                return GoalPositions.StartSouthWest;
            case West:
                return GoalPositions.StartWest;
            case NorthWest:
                return GoalPositions.StartNorthWest;
            default:
                return null;
        }
    }

    public GoalPositions getEndGoalPosition(GoalPosition goalPosition){
        switch (goalPosition){
            case North:
                return GoalPositions.EndNorth;
            case NorthEast:
                return GoalPositions.EndNorthEast;
            case East:
                return GoalPositions.EndEast;
            case SouthEast:
                return GoalPositions.EndSouthEast;
            case South:
                return GoalPositions.EndSouth;
            case SouthWest:
                return GoalPositions.EndSouthWest;
            case West:
                return GoalPositions.EndWest;
            case NorthWest:
                return GoalPositions.EndNorthWest;
            default:
                return null;
        }
    }
}
