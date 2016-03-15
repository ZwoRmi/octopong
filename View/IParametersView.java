package View;

import Controller.IParametersController;
import javafx.scene.layout.StackPane;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public interface IParametersView {

    void drawParameters(StackPane root, IParametersController parametersController);
    void unDrawParameters(StackPane root);
    void drawLogo();
    void drawButtonStart();
    void drawSetterSpeedBall();
    void drawSetterIntervalBall();
}
