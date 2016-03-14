package Model;

/**
 * Created by Lucas on 14/03/2016.
 */
public class Goal {
    private Line goalLine;
    private Line detectionLine;

    public Line getGoalLine() {
        return goalLine;
    }

    public void setGoalLine(Line goalLine) {
        this.goalLine = goalLine;
    }

    public Line getDetectionLine() {
        return detectionLine;
    }

    public void setDetectionLine(Line detectionLine) {
        this.detectionLine = detectionLine;
    }
}
