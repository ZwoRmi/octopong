package View;


import Controller.IGameController;
import Controller.IParametersController;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;

/**
 * Created by DanyPatient on 15/03/2016.
 */
public class ApplicationWindow {
    private IGameController gameController;
    private IParametersController parametersController;
    private IGameView gameView;
    private IParametersView parametersView;
    private Object currentView;
    private Text copyrightText;

    public ApplicationWindow(IGameView gameView, IParametersView parametersView) {
        this.gameView = gameView;
        this.parametersView = parametersView;
        this.drawCopyright();
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
        panel.getChildren().add(copyrightText);
        return panel;
    }

    public void drawCopyright(){
        copyrightText = new Text();
        copyrightText.setFont(new Font(10));
        copyrightText.setText("Copyright © 2016 ZwoD. All rights reserved.");
        copyrightText.setTranslateX(0);
        copyrightText.setTranslateY(350);
    }
}
