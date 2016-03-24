package View;


import Controller.IGameController;
import Controller.IParametersController;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * Created by DanyPatient on 15/03/2016.
 */
public class ApplicationWindow {
    private IGameController gameController;
    private IParametersController parametersController;
    private IGameView gameView;
    private IParametersView parametersView;
    private Object currentView;

    public ApplicationWindow(IGameView gameView, IParametersView parametersView) {
        this.gameView = gameView;
        this.parametersView = parametersView;
    }

    public void setGameController(IGameController gameController) {
        this.gameController = gameController;
    }

    public void setParametersController(IParametersController parametersController) {
        this.parametersController = parametersController;
    }

    public void showParameters() {
        this.currentView = this.parametersView;
    }

    public void showGame() {
        this.currentView = this.gameView;
    }

    public Pane getCurrentPanel() {
        Pane panel;
        if (this.currentView.equals(this.gameView)) {
            panel = this.gameView.getPanel(this.gameController);
        } else {
            panel = this.parametersView.getPanel(this.parametersController);
        }
        panel.setStyle("-fx-background-color: white");
        return panel;
    }


}
