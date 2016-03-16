package View;

import Controller.IGameController;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class GameView implements IGameView {
    private Pane myPanel;


    public GameView() {
        this.myPanel = new StackPane();
    }

    @Override
    public Pane getPanel(IGameController gameController) {
        //utiliser les données se trouvant dans gameController.getMap(), add les elements a myPanel

        return myPanel;
    }

    @Override
    public void drawGoal() {

    }

    @Override
    public void drawGoalKeeper() {

    }

    @Override
    public void drawBall() {

    }

    @Override
    public void drawScore() {

    }

    @Override
    public void drawTime() {

    }

    @Override
    public void drawLogo() {

    }
}
