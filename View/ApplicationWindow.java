package View;


import Controller.IGameController;
import Controller.IParametersController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Date;

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
        this.currentView = parametersView;
    }

    public void showGame() {
        this.currentView = gameView;
    }

    public Pane getCurrentPanel() {
        Pane panel;
        if (this.currentView.equals(this.gameView)) {
            panel = this.gameView.getPanel(gameController);
        } else {
            panel = this.parametersView.getPanel(parametersController);
        }
        panel.setStyle("-fx-background-color: white");
        return panel;
    }
}
