package View;

import Controller.IGameController;
import javafx.scene.layout.StackPane;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class GameView implements IGameView {
    private StackPane myPanel;


    public GameView() {
        this.myPanel = new StackPane();
    }

    @Override
    public void drawMap(StackPane root, IGameController gameController) {
        //utiliser les données se trouvant dans gameController.getMap(), add les elements a myPanel

        root.getChildren().add(myPanel);
    }
    @Override
    public void unDrawMap(StackPane root) {
        root.getChildren().remove(myPanel);
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
