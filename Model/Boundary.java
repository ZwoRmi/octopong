package Model;

public class Boundary {
    private Position points[];

    public Boundary(Goal g) {
        points[0] = g.getDetectionLine().getStartPosition();
        points[1] = g.getDetectionLine().getEndPosition();
        points[2] = g.getGoalLine().getStartPosition();
        points[3] = g.getGoalLine().getEndPosition();
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