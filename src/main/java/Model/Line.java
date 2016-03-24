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
        return this.startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public Position getEndPosition() {
        return this.endPosition;
    }

    public void setEndPosition(Position endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;

        Line line = (Line) o;

        return this.getStartPosition() != null ?
                this.getStartPosition().equals(line.getStartPosition()) :
                line.getStartPosition() == null && (this.getEndPosition() != null
                        ? this.getEndPosition().equals(line.getEndPosition()) :
                        line.getEndPosition() == null);

    }

    @Override
    public int hashCode() {
        int result = this.getStartPosition() != null ? this.getStartPosition().hashCode() : 0;
        result = 31 * result + (this.getEndPosition() != null ? this.getEndPosition().hashCode() : 0);
        return result;
    }
}
