
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/**
 *
 * @author maxime
 */
public class ParametersView implements IParametersView {

    public void drawParameters(){
        this.drawLogo();
        this.drawButtonStart();
        this.drawSetterIntervalBall();
        this.drawSetterSpeedBall();
    };

    public void drawLogo(){
        
    };

    public void drawButtonStart(){
        Button btn = new Button();
        btn.setText("Start");
    };

    public void drawSetterSpeedBall(){
        Button btn = new Button();
        btn.setText("Vitesse de deplacement des billes");
    };

    public void drawSetterIntervalBall(){
        Button btn = new Button();
        btn.setText("Frequence d'apparition des billes");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
    };
}
