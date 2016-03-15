package View;

import Controller.IGameController;
import Controller.IParametersController;
import javafx.scene.layout.StackPane;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public interface IGameView {
    StackPane getPanel(IGameController gameController); //appel toutes les methodes sauf drawLogo
    void drawGoal();
    void drawGoalKeeper();
    void drawBall();
    void drawScore();
    void drawTime();
    void drawLogo();
}
