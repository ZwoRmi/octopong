package View;

import Controller.IGameController;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class GameView implements IGameView {
    private GridPane myPanel;
    private IGameController gameController;

    @Override
    public Pane getPanel(IGameController gameController) {
        this.gameController = gameController;
        this.initPane();
        //utiliser les données se trouvant dans gameController.getMap(), add les elements a myPanel
        this.drawTime();
        return myPanel;
    }

    private void initPane() {
        myPanel = new GridPane();
        myPanel.getColumnConstraints().add(new ColumnConstraints(120));
        myPanel.getColumnConstraints().add(new ColumnConstraints(960));
        myPanel.getColumnConstraints().add(new ColumnConstraints(120));
        myPanel.getRowConstraints().add(new RowConstraints(120));
        myPanel.getRowConstraints().add(new RowConstraints(660));
        myPanel.getRowConstraints().add(new RowConstraints(80));
        myPanel.getRowConstraints().add(new RowConstraints(40));
    }

    @Override
    public void drawGoals() {

    }

    @Override
    public void drawGoalsKeeper() {

    }

    @Override
    public void drawBalls() {

    }

    @Override
    public void drawScores() {

    }

    @Override
    public void drawTime() {
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText(this.getGameTimeFormatted());
        t.setTranslateX(0);
        t.setTranslateY(-50);
        this.myPanel.add(t,2,2);
    }

    private String getGameTimeFormatted(){
        long nanoseconds = this.gameController.getGameTime();
        long millis = TimeUnit.MILLISECONDS.convert(nanoseconds, TimeUnit.NANOSECONDS);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(millis));
        return (calendar.get(Calendar.HOUR)-1) + "H " + calendar.get(Calendar.MINUTE) + "M "+ calendar.get(Calendar.SECOND) + "S ";
    }

}
