package Controller;

import Model.IMap;
import View.ApplicationWindow;

import java.security.InvalidParameterException;

public class ParametersController implements IParametersController {
    private final ApplicationWindow rootWindow;
    private final IGameController gameController;
    private IMap IMap;

    public ParametersController(IMap IMap, ApplicationWindow rootWindow, IGameController gameController) {
        this.IMap = IMap;
        this.rootWindow = rootWindow;
        this.gameController = gameController;
    }

    @Override
    public void setBallSpeed(int value) {
        switch (value) {
            case 1:
                this.IMap.setBallSpeed(0.1f);
                break;
            case 2:
                this.IMap.setBallSpeed(0.15f);
                break;
            case 3:
                this.IMap.setBallSpeed(0.2f);
                break;
            case 4:
                this.IMap.setBallSpeed(0.25f);
                break;
            case 5:
                this.IMap.setBallSpeed(0.3f);
                break;
            default:
                throw new InvalidParameterException("value should be between 1-5 but the current value is : " + value);
        }
    }

    @Override
    public void setBallSPawnInterval(int value) {
        switch (value) {
            case 1:
                this.IMap.setBallSpawnInterval(20000);
                break;
            case 2:
                this.IMap.setBallSpawnInterval(15000);
                break;
            case 3:
                this.IMap.setBallSpawnInterval(10000);
                break;
            case 4:
                this.IMap.setBallSpawnInterval(5000);
                break;
            case 5:
                this.IMap.setBallSpawnInterval(2000);
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

    @Override
    public void setMap(IMap IMap) {
        this.IMap = IMap;
    }
}
