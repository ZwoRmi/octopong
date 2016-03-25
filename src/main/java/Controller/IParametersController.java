package Controller;

import Model.Map;

public interface IParametersController {
    void setBallSpeed(int value);
    void setBallSPawnInterval (int value);
    void startParameters();
    void startGame();
    void setMap(Map map);
}
