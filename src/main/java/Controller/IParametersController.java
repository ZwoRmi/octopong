package Controller;

import Model.IMap;

public interface IParametersController {
    void setBallSpeed(int value);
    void setBallSPawnInterval (int value);
    void startParameters();
    void startGame();

    void setMap(IMap map);
}
