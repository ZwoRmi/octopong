package View;

import Controller.IGameController;
import javafx.scene.layout.Pane;

public interface IGameView {
    Pane getPanel(IGameController gameController);
    void drawGoals();
    void drawGoalsKeeper();
    void drawBalls();
    void drawScores();
    void drawTime();
    void drawLogo();
}
