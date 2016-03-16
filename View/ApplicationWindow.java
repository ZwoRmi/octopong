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
    private Text copyrightText;
    private ImageView logo;
    private Date startDate;

    public ApplicationWindow(IGameView gameView, IParametersView parametersView) {
        this.logo = new ImageView();
        this.gameView = gameView;
        this.parametersView = parametersView;
        this.drawCopyright();
        this.drawLogo();
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
        panel.getChildren().add(this.copyrightText);
        panel.getChildren().add(this.logo);
        return panel;
    }

    public void drawCopyright() {
        this.copyrightText = new Text();
        this.copyrightText.setFont(new Font(10));
        this.copyrightText.setText("Copyright © 2016 ZwoD. All rights reserved.");
        this.copyrightText.setTranslateX(0);
        this.copyrightText.setTranslateY(350);
    }

    public void drawLogo() {
        Image logoImage = new Image("Image/logoOctopong.png");
        this.logo.setImage(logoImage);
        this.logo.setTranslateX(-400);
        this.logo.setTranslateY(-300);
    }
}
