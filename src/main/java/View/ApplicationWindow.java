package View;

import Controller.IGameController;
import Controller.IParametersController;
import javafx.scene.layout.Pane;

public class ApplicationWindow {
    private IGameController gameController;
    private IParametersController parametersController;
    private final IGameView gameView;
    private final IParametersView parametersView;
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
