package Controller;

import Model.Map;

import java.security.InvalidParameterException;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class ParametersController implements IParametersController {

    private Map map;

    public ParametersController(Map m) {
        this.map = m;
    }

    @Override
    public void setBallSpeed(int value) {
        switch (value) {
            case 1:
                this.map.setBallSpeed(1);
                break;
            case 2:
                this.map.setBallSpeed(2);
                break;
            case 3:
                this.map.setBallSpeed(3);
                break;
            case 4:
                this.map.setBallSpeed(4);
                break;
            case 5:
                this.map.setBallSpeed(5);
                break;
            default:
                throw new InvalidParameterException("value should be between 1-5 but the current value is : " + value);
        }
    }

    @Override
    public void setBallSPawnInterval(int value) {
        switch (value) {
            case 1:
                this.map.setBallSpawnInterval(1);
                break;
            case 2:
                this.map.setBallSpawnInterval(2);
                break;
            case 3:
                this.map.setBallSpawnInterval(3);
                break;
            case 4:
                this.map.setBallSpawnInterval(4);
                break;
            case 5:
                this.map.setBallSpawnInterval(5);
                break;
            default:
                throw new InvalidParameterException("value should be between 1-5 but the current value is : " + value);
        }
    }
}
