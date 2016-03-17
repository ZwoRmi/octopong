package Model;

/**
 * Created by Lucas on 14/03/2016.
 */
public class Goal {
    private Line goalStartLine;
    private Line goalEndLine;
    private Line detectionLine;

    public Line getGoalStartLine() {
        return this.goalStartLine;
    }

    public void setGoalStartLine(Line goalStartLine) {
        this.goalStartLine = goalStartLine;
    }

    public Line getGoalEndLine() {
        return this.goalEndLine;
    }

    public void setGoalEndLine(Line goalEndLine) {
        this.goalEndLine = goalEndLine;
    }

    public Line getDetectionLine() {
        return this.detectionLine;
    }

    public void setDetectionLine(Line detectionLine) {
        this.detectionLine = detectionLine;
    }
}
