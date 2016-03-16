package View;

import Controller.IParametersController;
import javafx.scene.layout.StackPane;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public interface IParametersView {

    StackPane getPanel(IParametersController parametersController);
    void drawLogo();
    void drawCopyright();
    void drawButtonStart();
    void drawSetterSpeedBall();
    void drawSetterIntervalBall();
    void changeSpeedBallValue();
    void changeIntervalBallValue();
    void drawSpeedBallValue();
    void drawIntervalValue();

}
