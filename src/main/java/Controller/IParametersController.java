package Controller;

import Model.Map;

/**
 * Created by Lucas on 14/03/2016.
 */
public interface IParametersController {
    void setBallSpeed(int value);
    void setBallSPawnInterval (int value);
    void startParameters();
    void startGame();
    void setMap(Map map);
}
