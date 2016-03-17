package Model;

public class Boundary {
    private Position points[];

    public Boundary(Line startLine, Line endLine) {
        this.points = new Position[4];
        this.points[0] = startLine.getStartPosition();
        this.points[1] = startLine.getEndPosition();
        this.points[2] = endLine.getStartPosition();
        this.points[3] = endLine.getEndPosition();
    }

    public Boundary(Line line) {
        this.points = new Position[4];
        this.points[0] = line.getStartPosition();
        this.points[1] = line.getEndPosition();
        this.points[2] = this.getFakePosition(line.getStartPosition());
        this.points[3] = this.getFakePosition(line.getEndPosition());
    }

    private Position getFakePosition(Position pos) {
        Position position = new Position();
        position.setX(pos.getX()+0.2f);
        position.setY(pos.getY()+0.2f);
        return position;
    }

    public boolean contains(Position test) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = this.points.length - 1; i < this.points.length; j = i++) {
            if ((this.points[i].getY() > test.getY()) != (this.points[j].getY() > test.getY()) &&
                    (test.getX() < (this.points[j].getX() - this.points[i].getX()) * (test.getY() - this.points[i].getY()) / (this.points[j].getY()- this.points[i].getY()) + this.points[i].getX())) {
                result = !result;
            }
        }
        return result;
    }
}