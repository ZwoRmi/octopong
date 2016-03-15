package View;


import Controller.IGameController;
import Controller.IParametersController;
import javafx.scene.layout.StackPane;

/**
 * Created by DanyPatient on 15/03/2016.
 */
public class ApplicationWindow {
    private IGameController gameController;
    private IParametersController parametersController;
    private StackPane root;
    private IGameView gameView;
    private IParametersView parametersView;

    public ApplicationWindow(IGameView gameView, IParametersView parametersView, StackPane root) {
        this.gameView = gameView;
        this.parametersView = parametersView;
        this.root = root;
    }

    public void setGameController(IGameController gameController) {
        this.gameController = gameController;
    }

    public void setParametersController(IParametersController parametersController) {
        this.parametersController = parametersController;
    }

    public void showParameters(){
        this.gameView.unDrawMap(root);
        this.parametersView.drawParameters(root, parametersController);
    }
    public void showGame(){
        this.parametersView.unDrawParameters(root);
        this.gameView.drawMap(root, gameController);
    }

    public void updateGameMap() {
        this.gameView.drawMap(root, gameController);
    }
}
