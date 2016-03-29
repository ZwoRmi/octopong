package View;

import Controller.IParametersController;
import Model.Tuple;
import Util.StopWatch;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

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
    private List<Tuple<ImageView, Boolean>> imagesRotation;
    private StopWatch stopWatchRotationImages;
    private int rotate;

    public ParametersView() {
        this.speedBallValue = 1;
        this.intervalBallValue = 1;
        this.initSetterSpeedBallButton();
        this.initLogo();
        this.initCopyright();
        this.initImageList();
        this.initStartButton();
        this.initSetterIntervalBallButton();
    }

    private void initImageList() {
        this.stopWatchRotationImages = new StopWatch();
        this.stopWatchRotationImages.start();
        this.imagesRotation = new ArrayList<>();
        this.imagesRotation.add(new Tuple<>(this.getFirstImage(), false));
        this.imagesRotation.add(new Tuple<>(this.getSecondImage(), true));
        this.imagesRotation.add(new Tuple<>(this.getThirdImage(), true));
    }

    private ImageView getThirdImage() {
        ImageView octogone = new ImageView();
        Image img = new Image("octogone.png");
        octogone.setImage(img);
        octogone.setTranslateX(400);
        octogone.setTranslateY(-200);
        return octogone;
    }

    private ImageView getSecondImage() {
        ImageView octogone = new ImageView();
        Image img = new Image("octogone.png");
        octogone.setImage(img);
        octogone.setTranslateX(-400);
        octogone.setTranslateY(200);
        return octogone;
    }

    private void upRotate() {
        this.rotate += 10;
        if (this.rotate > 360) {
            this.rotate -= 360;
        }
    }

    private ImageView getFirstImage() {
        ImageView octogone = new ImageView();
        Image img = new Image("octogoneWithShadow.png");
        octogone.setImage(img);
        octogone.setTranslateX(0);
        octogone.setTranslateY(0);
        octogone.setFitWidth(450);
        octogone.setPreserveRatio(true);
        return octogone;
    }

    private void setSpeedAndIntervalValue() {
        this.parametersController.setBallSpeed(this.speedBallValue);
        this.parametersController.setBallSPawnInterval(this.intervalBallValue);
    }

    private void initLogo() {
        this.logo = new ImageView();
        Image logoImage = new Image("logoOctopong.png");
        this.logo.setImage(logoImage);
        this.logo.setTranslateX(-450);
        this.logo.setTranslateY(-417);
    }

    private void initCopyright() {
        this.copyrightText = new Text();
        this.copyrightText.setFont(new Font(10));
        this.copyrightText.setText("Copyright © 2016 ZwoD. All rights reserved.");
        this.copyrightText.setTranslateY(470);
    }

    private void initSetterIntervalBallButton() {
        this.buttonSetIntervalBall = new Button();
        this.buttonSetIntervalBall.setText("Fréquence d'apparition des billes");
        this.buttonSetIntervalBall.setPrefWidth(245);
        this.buttonSetIntervalBall.setTranslateX(0);
        this.buttonSetIntervalBall.setTranslateY(0);
        this.buttonSetIntervalBall.setOnMousePressed(event -> ParametersView.this.changeIntervalBallValue());
    }

    private void initStartButton() {
        this.buttonStart = new ImageButton("resumeIconButton.png");
        this.buttonStart.setTranslateX(0);
        this.buttonStart.setTranslateY(125);
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
        this.drawImages();
        this.drawButtonStart();
        this.drawSetterIntervalBall();
        this.drawSetterSpeedBall();
        this.drawIntervalValue();
        this.drawSpeedBallValue();
        return this.myPanel;
    }

    private void drawImages() {
        if (this.stopWatchRotationImages.getTime() > 350) {
            this.upRotate();
            this.stopWatchRotationImages.reset();
            this.stopWatchRotationImages.start();
        }
        for (Tuple<ImageView, Boolean> imageRotation : this.imagesRotation) {

            if (imageRotation.y) {
                imageRotation.x.setRotate(this.rotate);
            }
            this.myPanel.getChildren().add(imageRotation.x);
        }
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
        this.buttonSetSpeedBall.setPrefWidth(245);
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
