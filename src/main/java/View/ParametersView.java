package View;

import Controller.IParametersController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ParametersView implements IParametersView {
    private StackPane myPanel;
    private IParametersController parametersController;
    private int speedBallValue;
    private int intervalBallValue;
    private Button buttonSetSpeedBall;
    private Button buttonStart;
    private Button buttonSetIntervalBall;
    private ImageView logo;
    private Text copyrightText;

    public ParametersView() {
        this.speedBallValue = 1;
        this.intervalBallValue = 1;
        this.initSetterSpeedBallButton();
        this.initLogo();
        this.initCopyright();
        this.initStartButton();
        this.initSetterIntervalBallButton();
    }

    private void setSpeedAndIntervalValue() {
        this.parametersController.setBallSpeed(this.speedBallValue);
        this.parametersController.setBallSPawnInterval(this.intervalBallValue);
    }

    private void initLogo() {
        this.logo = new ImageView();
        Image logoImage = new Image("logoOctopong.png");
        this.logo.setImage(logoImage);
        this.logo.setTranslateX(-400);
        this.logo.setTranslateY(-300);
    }

    private void initCopyright() {
        this.copyrightText = new Text();
        this.copyrightText.setFont(new Font(10));
        this.copyrightText.setText("Copyright © 2016 ZwoD. All rights reserved.");
        this.copyrightText.setTranslateY(350);
    }

    private void initSetterIntervalBallButton() {
        this.buttonSetIntervalBall = new Button();
        this.buttonSetIntervalBall.setText("Fréquence d'apparition des billes");
        this.buttonSetIntervalBall.setTranslateX(0);
        this.buttonSetIntervalBall.setTranslateY(0);
        this.buttonSetIntervalBall.setOnMousePressed(event -> ParametersView.this.changeIntervalBallValue());
    }

    private void initStartButton() {
        this.buttonStart = new Button();
        this.buttonStart.setText("Start");
        this.buttonStart.setTranslateX(0);
        this.buttonStart.setTranslateY(100);
        this.buttonStart.setOnMousePressed(event -> {
            ParametersView.this.setSpeedAndIntervalValue();
            ParametersView.this.parametersController.startGame();
        });
    }

    @Override
    public StackPane getPanel(IParametersController parametersController) {
        this.myPanel = new StackPane();
        this.parametersController = parametersController;
        this.drawLogo();
        this.drawCopyright();
        this.drawButtonStart();
        this.drawSetterIntervalBall();
        this.drawSetterSpeedBall();
        this.drawIntervalValue();
        this.drawSpeedBallValue();
        return this.myPanel;
    }

    @Override
    public void drawLogo() {
        this.myPanel.getChildren().add(this.logo);
    }

    @Override
    public void drawCopyright() {
        this.myPanel.getChildren().add(this.copyrightText);
    }

    @Override
    public void drawButtonStart() {
        this.myPanel.getChildren().add(this.buttonStart);
    }

    @Override
    public void drawSetterSpeedBall() {
        this.myPanel.getChildren().add(this.buttonSetSpeedBall);
    }

    private void initSetterSpeedBallButton() {
        this.buttonSetSpeedBall = new Button();
        this.buttonSetSpeedBall.setText("Vitesse de déplacement des billes");
        this.buttonSetSpeedBall.setTranslateX(0);
        this.buttonSetSpeedBall.setTranslateY(-100);
        this.buttonSetSpeedBall.setOnMousePressed(event -> ParametersView.this.changeSpeedBallValue());
    }

    @Override
    public void drawSetterIntervalBall() {
        this.myPanel.getChildren().add(this.buttonSetIntervalBall);
    }

    @Override
    public void changeSpeedBallValue() {
        if (this.speedBallValue == 5) {
            this.speedBallValue = 1;
        } else {
            this.speedBallValue++;
        }
    }

    @Override
    public void changeIntervalBallValue() {
        if (this.intervalBallValue == 5) {
            this.intervalBallValue = 1;
        } else {
            this.intervalBallValue++;
        }
    }

    @Override
    public void drawSpeedBallValue() {
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText(Integer.toString(this.speedBallValue));
        t.setTranslateX(0);
        t.setTranslateY(-50);
        this.myPanel.getChildren().add(t);
    }

    @Override
    public void drawIntervalValue() {
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText(Integer.toString(this.intervalBallValue));
        t.setTranslateX(0);
        t.setTranslateY(50);
        this.myPanel.getChildren().add(t);
    }
}
