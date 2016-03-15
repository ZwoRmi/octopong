package View;

import Controller.IParametersController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author maxime
 */
public class ParametersView implements IParametersView {
    private StackPane myPanel;
    private IParametersController parametersController;
    public ParametersView() {
        this.myPanel = new StackPane();
    }

    public void unDrawParameters(StackPane root){
        root.getChildren().remove(myPanel);
    }

    public void drawParameters(StackPane root, IParametersController parametersController){
        this.parametersController = parametersController;
        this.drawLogo();
        this.drawButtonStart();
        this.drawSetterIntervalBall();
        this.drawSetterSpeedBall();
        root.getChildren().add(myPanel);
    }

    public void drawLogo(){
        ImageView logo = new ImageView();
        Image logoImage = new Image("Image/logoOctopong.png");
        logo.setImage(logoImage);
        logo.setTranslateX(-400);
        logo.setTranslateY(-300);
        this.myPanel.getChildren().add(logo);
    }

    public void drawButtonStart(){
        Button btn = new Button();
        btn.setText("Start");
        btn.setTranslateX(0);
        btn.setTranslateY(0);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                parametersController.startGame();
            }
        });
        this.myPanel.getChildren().add(btn);


    }

    public void drawSetterSpeedBall(){
        Button btn = new Button();
        btn.setText("Vitesse de deplacement des billes");
        btn.setTranslateX(0);
        btn.setTranslateY(-200);
        this.myPanel.getChildren().add(btn);
    }

    public void drawSetterIntervalBall(){
        Button btn = new Button();
        btn.setText("Fréquence d'apparition des billes");
        btn.setTranslateX(0);
        btn.setTranslateY(-100);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        this.myPanel.getChildren().add(btn);
    }
}
