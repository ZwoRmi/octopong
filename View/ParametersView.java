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

    public ParametersView() {
        this.initSetterSpeedBallButton();
        this.initStartButton();
        this.initSetterIntervalBallButton();
        this.speedBallValue = 1;
        this.intervalBallValue = 1;
    }

    private void initSetterIntervalBallButton() {
        buttonSetIntervalBall = new Button();
        buttonSetIntervalBall.setText("Fréquence d'apparition des billes");
        buttonSetIntervalBall.setTranslateX(0);
        buttonSetIntervalBall.setTranslateY(0);
        buttonSetIntervalBall.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changeIntervalBallValue();
            }
        });
    }

    private void initStartButton() {
        buttonStart = new Button();
        buttonStart.setText("Start");
        buttonStart.setTranslateX(0);
        buttonStart.setTranslateY(100);
        buttonStart.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                parametersController.startGame();
            }
        });
    }

    @Override
    public StackPane getPanel(IParametersController parametersController) {
        this.myPanel = new StackPane();
        this.parametersController = parametersController;
        this.drawLogo();
        this.drawButtonStart();
        this.drawSetterIntervalBall();
        this.drawSetterSpeedBall();
        this.drawIntervalValue();
        this.drawSpeedBallValue();
        return myPanel;
    }

    public void drawLogo() {
        ImageView logo = new ImageView();
        Image logoImage = new Image("Image/logoOctopong.png");
        logo.setImage(logoImage);
        logo.setTranslateX(-400);
        logo.setTranslateY(-300);
        this.myPanel.getChildren().add(logo);
    }

    public void drawButtonStart() {
        this.myPanel.getChildren().add(buttonStart);
    }

    public void drawSetterSpeedBall() {
        this.myPanel.getChildren().add(buttonSetSpeedBall);
    }

    private void initSetterSpeedBallButton() {
        buttonSetSpeedBall = new Button();
        buttonSetSpeedBall.setText("Vitesse de deplacement des billes");
        buttonSetSpeedBall.setTranslateX(0);
        buttonSetSpeedBall.setTranslateY(-100);
        buttonSetSpeedBall.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                changeSpeedBallValue();
            }
        });
    }

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
        t.setTranslateX(500);
        t.setTranslateY(-20);
        this.myPanel.getChildren().add(t);
    }

    @Override
    public void drawIntervalValue() {
        Text t = new Text(-500, -20, Integer.toString(this.intervalBallValue));
        t.setFont(new Font(20));
        this.myPanel.getChildren().add(t);
    }
}
