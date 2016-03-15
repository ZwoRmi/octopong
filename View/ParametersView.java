package View;

import Controller.IParametersController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 *
 * @author maxime
 */
public class ParametersView implements IParametersView {
    private StackPane myPanel;

    public ParametersView() {
        this.myPanel = new StackPane();
    }

    public void unDrawParameters(StackPane root){
        root.getChildren().remove(myPanel);
    }

    public void drawParameters(StackPane root, IParametersController parametersController){
        this.drawLogo();
        this.drawButtonStart();
        this.drawSetterIntervalBall();
        this.drawSetterSpeedBall();
        root.getChildren().add(myPanel);
    }

    public void drawLogo(){
        //TODO add image to myPanel
    }

    public void drawButtonStart(){
        Button btn = new Button();
        btn.setText("Start");
        this.myPanel.getChildren().add(btn);
    }

    public void drawSetterSpeedBall(){
        Button btn = new Button();
        btn.setText("Vitesse de deplacement des billes");
        this.myPanel.getChildren().add(btn);
    }

    public void drawSetterIntervalBall(){
        Button btn = new Button();
        btn.setText("Fréquence d'apparition des billes");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        this.myPanel.getChildren().add(btn);
    }
}
