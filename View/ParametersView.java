package View;

import Controller.IParametersController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author maxime
 */
public class ParametersView implements IParametersView {
    private StackPane myPanel;
    private IParametersController parametersController;
    private int speedBallValue;
    private int intervalBallValue;
    private Button buttonSetSpeedBall;
    private Button buttonStart;
    private Button buttonSetIntervalBall;
    private ImageView logo;

    public ParametersView() {
        this.initSetterSpeedBallButton();
        this.initLogo();
        this.initStartButton();
        this.initSetterIntervalBallButton();
        this.speedBallValue = 1;
        this.intervalBallValue = 1;
    }

    private void initLogo(){
        this.logo = new ImageView();
        Image logoImage = new Image("Image/logoOctopong.png");
        this.logo.setImage(logoImage);
        this.logo.setTranslateX(-400);
        this.logo.setTranslateY(-300);
    }
    private void initSetterIntervalBallButton() {
        this.buttonSetIntervalBall = new Button();
        this.buttonSetIntervalBall.setText("Fréquence d'apparition des billes");
        this.buttonSetIntervalBall.setTranslateX(0);
        this.buttonSetIntervalBall.setTranslateY(0);
        this.buttonSetIntervalBall.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ParametersView.this.changeIntervalBallValue();
            }
        });
    }

    private void initStartButton() {
        this.buttonStart = new Button();
        this.buttonStart.setText("Start");
        this.buttonStart.setTranslateX(0);
        this.buttonStart.setTranslateY(100);
        this.buttonStart.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ParametersView.this.parametersController.startGame();
            }
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
    public void drawLogo(){
        this.myPanel.getChildren().add(this.logo);
    }

    @Override
    public void drawCopyright() {
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
        this.buttonSetSpeedBall.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ParametersView.this.changeSpeedBallValue();
            }
        });
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
        this.parametersController.setBallSpeed(this.speedBallValue);
    }

    @Override
    public void changeIntervalBallValue() {
        if (this.intervalBallValue == 5) {
            this.intervalBallValue = 1;
        } else {
            this.intervalBallValue++;
        }
        this.parametersController.setBallSPawnInterval(this.intervalBallValue);
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
