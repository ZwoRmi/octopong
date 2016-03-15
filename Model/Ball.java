package Model;

/**
 * Created by Lucas on 14/03/2016.
 */
public class Ball {
    private Position actualPosition;
    private Position direction;

    public Position getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Position actualPosition) {
        this.actualPosition = actualPosition;
    }

    public Position getDirection() {
        return direction;
    }

    public void setDirection(Position direction) {
        this.direction = direction;
    }
}
