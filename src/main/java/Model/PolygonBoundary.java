package Model;

import javafx.scene.shape.Polygon;

public class PolygonBoundary {
    private Polygon polygon;

    public Polygon getPolygon() {
        return this.polygon;
    }

    private void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public PolygonBoundary(Line startLine, Line endLine) {
        double[] points = {
                startLine.getEndPosition().getX(),
                startLine.getEndPosition().getY(),
                endLine.getEndPosition().getX(),
                endLine.getEndPosition().getY(),
                endLine.getStartPosition().getX(),
                endLine.getStartPosition().getY(),
                startLine.getStartPosition().getX(),
                startLine.getStartPosition().getY()
        };
        this.setPolygon (new Polygon(points));
    }

    public boolean contains(Position pos){
        return this.polygon.contains(pos.getX(), pos.getY());
    }
}
