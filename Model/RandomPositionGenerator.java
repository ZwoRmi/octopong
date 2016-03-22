package Model;

/**
 * Created by DanyPatient on 15/03/2016.
 */
public class RandomPositionGenerator {
    public Position generatePosition(){
        Position randomPosition = new Position();
        randomPosition.setX(this.randRange(-2, 2));
        randomPosition.setY(this.randRange(-2, 2));
        //(randomPosition.getX()==0 && randomPosition.getY()==0 &&
        if (!this.isDirectionOk(randomPosition)) {
            return this.generatePosition();
        }
        return randomPosition;
    }

    private boolean isDirectionOk(Position randomPosition) {
        float maxValue = 1.2f;
        float minValue = 0.8f;
        double value = Math.sqrt(Math.pow(randomPosition.getX(),2)+Math.pow(randomPosition.getY(),2));
        return value>minValue && value<maxValue;
    }

    private float randRange(float min, float max) {
        return min + (float)Math.random() * (max - min);
    }
}
