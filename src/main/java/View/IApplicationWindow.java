package View;

import Controller.IGameController;
import Controller.IParametersController;
import javafx.scene.layout.Pane;

public interface IApplicationWindow {
    void setGameController(IGameController gameController);

    void setParametersController(IParametersController parametersController);

    void showParameters();

    void showGame();

    Pane getCurrentPanel();
}
