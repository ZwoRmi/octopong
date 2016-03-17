package Model;

/**
 * Created by DanyPatient on 15/03/2016.
 */
public class RandomPositionGenerator {
    public Position generatePosition(){
        Position randomPosition = new Position();
        randomPosition.setX(this.randRange(2, 2));
        randomPosition.setY(this.randRange(-2, 2));
        return randomPosition;
    }

    private float randRange(float min, float max) {
        return min + (float)Math.random() * (max - min);
    }
}
