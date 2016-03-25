package View;

import Controller.IGameController;
import Controller.IParametersController;
import javafx.scene.layout.Pane;

public class ApplicationWindow implements IApplicationWindow {
    private final IGameView gameView;
    private final IParametersView parametersView;
    private IGameController gameController;
    private IParametersController parametersController;
    private Object currentView;

    public ApplicationWindow(IGameView gameView, IParametersView parametersView) {
        this.gameView = gameView;
        this.parametersView = parametersView;
    }

    @Override
    public void setGameController(IGameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void setParametersController(IParametersController parametersController) {
        this.parametersController = parametersController;
    }

    @Override
    public void showParameters() {
        this.currentView = this.parametersView;
    }

    @Override
    public void showGame() {
        this.currentView = this.gameView;
    }

    @Override
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
