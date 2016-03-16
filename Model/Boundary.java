package Model;

public class Boundary {
    private Position points[];

    public Boundary(Line startLine, Line endLine) {
        this.points = new Position[4];
        points[0] = startLine.getStartPosition();
        points[1] = startLine.getEndPosition();
        points[2] = endLine.getStartPosition();
        points[3] = endLine.getEndPosition();
    }

    public Boundary(Line line) {
        this.points = new Position[4];
        points[0] = line.getStartPosition();
        points[1] = line.getEndPosition();
        points[2] = this.getFakePosition(line.getStartPosition());
        points[3] = this.getFakePosition(line.getEndPosition());
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
        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i].getY() > test.getY()) != (points[j].getY() > test.getY()) &&
                    (test.getX() < (points[j].getX() - points[i].getX()) * (test.getY() - points[i].getY()) / (points[j].getY()-points[i].getY()) + points[i].getX())) {
                result = !result;
            }
        }
        return result;
    }
}