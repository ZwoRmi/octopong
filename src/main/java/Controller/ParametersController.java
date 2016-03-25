package Controller;

import Model.IMap;
import View.IApplicationWindow;

import java.security.InvalidParameterException;

public class ParametersController implements IParametersController {
    private final IApplicationWindow rootWindow;
    private final IGameController gameController;
    private IMap map;

    public ParametersController(IMap IMap, IApplicationWindow rootWindow, IGameController gameController) {
        this.map = IMap;
        this.rootWindow = rootWindow;
        this.gameController = gameController;
    }

    @Override
    public void setBallSpeed(int value) {
        switch (value) {
            case 1:
                this.map.setBallSpeed(0.1f);
                break;
            case 2:
                this.map.setBallSpeed(0.15f);
                break;
            case 3:
                this.map.setBallSpeed(0.2f);
                break;
            case 4:
                this.map.setBallSpeed(0.25f);
                break;
            case 5:
                this.map.setBallSpeed(0.3f);
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

    @Override
    public void setMap(IMap map) {
        this.map = map;
    }
}
