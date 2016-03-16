package View;

import Controller.IGameController;
import javafx.scene.layout.Pane;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public interface IGameView {
    Pane getPanel(IGameController gameController); //appel toutes les methodes sauf drawLogo
    void drawGoals();
    void drawGoalsKeeper();
    void drawBalls();
    void drawScores();
    void drawTime();
    void drawLogo();
}
