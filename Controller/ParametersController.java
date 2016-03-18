package Controller;

import Model.Map;
import View.ApplicationWindow;

import java.security.InvalidParameterException;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class ParametersController implements IParametersController {

    private ApplicationWindow rootWindow;
    private Map map;
    private IGameController gameController;

    public ParametersController(Map map, ApplicationWindow rootWindow, IGameController gameController) {
        this.map = map;
        this.rootWindow = rootWindow;
        this.gameController = gameController;
    }

    @Override
    public void setBallSpeed(int value) {
        switch (value) {
            case 1:
                this.map.setBallSpeed(0.25f);
                break;
            case 2:
                this.map.setBallSpeed(0.5f);
                break;
            case 3:
                this.map.setBallSpeed(0.75f);
                break;
            case 4:
                this.map.setBallSpeed(1);
                break;
            case 5:
                this.map.setBallSpeed(1.25f);
                break;
            default:
                throw new InvalidParameterException("value should be between 1-5 but the current value is : " + value);
        }
    }

    @Override
    public void setBallSPawnInterval(int value) {
        switch (value) {
            case 1:
                this.map.setBallSpawnInterval(20000);
                break;
            case 2:
                this.map.setBallSpawnInterval(15000);
                break;
            case 3:
                this.map.setBallSpawnInterval(10000);
                break;
            case 4:
                this.map.setBallSpawnInterval(5000);
                break;
            case 5:
                this.map.setBallSpawnInterval(2000);
                break;
            default:
                throw new InvalidParameterException("value should be between 1-5 but the current value is : " + value);
        }
    }

    @Override
    public void startParameters() {
        this.rootWindow.showParameters();
    }

    @Override
    public void startGame() {
        this.rootWindow.showGame();
        this.gameController.startGame();
    }
}
