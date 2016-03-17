package Model;

import java.awt.*;

/**
 * Created by Lucas on 17/03/2016.
 */
public class PolygonBoundary {
    private Polygon polygon;

    public PolygonBoundary(Line startLine, Line endLine) {
        int[] xPoints = new int[]{(int) startLine.getStartPosition().getX(),(int)startLine.getEndPosition().getX(), (int)endLine.getStartPosition().getX(), (int)endLine.getEndPosition().getX()};
        int[] yPoints = new int[]{(int) startLine.getStartPosition().getY(),(int)startLine.getEndPosition().getY(), (int)endLine.getStartPosition().getY(), (int)endLine.getEndPosition().getY()};
        polygon = new Polygon(xPoints, yPoints,4);
    }

    public boolean contains(Position pos){
        return this.polygon.contains(pos.getX(), pos.getY());
    }
}
