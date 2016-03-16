package Model;

/**
 * Created by Lucas on 14/03/2016.
 */
public class Line {
    private Position startPosition;
    private Position endPosition;
    public Line(){}

    public Line(Position startPosition, Position endPosition){
        this.setStartPosition(startPosition);
        this.setEndPosition(endPosition);
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Position endPosition) {
        this.endPosition = endPosition;
    }
}
