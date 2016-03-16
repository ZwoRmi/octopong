package View;

import Controller.IGameController;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public class GameView implements IGameView {
    private GridPane myPanel;
    private IGameController gameController;
    private GridPane myButtonsPanel;
    private Button playButton;
    private Button restartButton;
    private Button stopButton;
    private Button pauseButton;
    private Button generateBallButton;

    public GameView() {
        this.initButtons();
        this.initPaneButtons();
    }

    @Override
    public Pane getPanel(IGameController gameController) {
        this.gameController = gameController;
        this.initPane();
        this.drawButtons();
        //utiliser les données se trouvant dans gameController.getMap(), add les elements a myPanel
        this.drawTime();
        return myPanel;
    }

    private void drawButtons() {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(myButtonsPanel);
        //vBox.setAlignment(Pos.CENTER);
        this.myPanel.add(vBox, 1, 2);
        GridPane.setHalignment(vBox, HPos.CENTER);
        GridPane.setValignment(vBox, VPos.CENTER);

    }

    public void initButtons() {
        initPlayButton();
        initPauseButton();
        initStopButton();
        initRestartButton();
        initGenerateBallButton();
    }

    private void initGenerateBallButton() {
        generateBallButton = new Button();
        generateBallButton.setText("ajouter balle");
        generateBallButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                gameController.generateBallGame();
            }
        });
    }

    private void initRestartButton() {
        restartButton = new Button();
        restartButton.setText("Redémarrer");
        restartButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                gameController.restartGame();
            }
        });
    }

    private void initStopButton() {
        stopButton = new Button();
        stopButton.setText("Stop");
        stopButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                gameController.stopGame();
            }
        });
    }

    private void initPauseButton() {
        pauseButton = new Button();
        pauseButton.setText("Pause");
        pauseButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                gameController.pauseGame();
            }
        });
    }

    private void initPlayButton() {
        playButton = new Button();
        playButton.setText("Reprendre");
        playButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                gameController.resumeGame();
            }
        });
        playButton.setAlignment(Pos.CENTER);
        playButton.setTextAlignment(TextAlignment.CENTER);
    }

    private void initPaneButtons() {
        myButtonsPanel = new GridPane();
        myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        this.myButtonsPanel.add(this.playButton, 0, 0);
        GridPane.setHalignment(this.playButton, HPos.CENTER);
        GridPane.setValignment(this.playButton, VPos.CENTER);
        this.myButtonsPanel.add(this.pauseButton, 1, 0);
        GridPane.setHalignment(this.pauseButton, HPos.CENTER);
        GridPane.setValignment(this.pauseButton, VPos.CENTER);
        this.myButtonsPanel.add(this.stopButton, 2, 0);
        GridPane.setHalignment(this.stopButton, HPos.CENTER);
        GridPane.setValignment(this.stopButton, VPos.CENTER);
        this.myButtonsPanel.add(this.restartButton, 3, 0);
        GridPane.setHalignment(this.restartButton, HPos.CENTER);
        GridPane.setValignment(this.restartButton, VPos.CENTER);
        this.myButtonsPanel.add(this.generateBallButton, 4, 0);
        GridPane.setHalignment(this.generateBallButton, HPos.CENTER);
        GridPane.setValignment(this.generateBallButton, VPos.CENTER);


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
        VBox vbox = new VBox();
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText(this.getGameTimeFormatted());
        t.setTextAlignment(TextAlignment.CENTER);
        vbox.getChildren().addAll(t);
        this.myPanel.add(vbox, 2, 2);

        GridPane.setHalignment(vbox, HPos.CENTER);
        GridPane.setValignment(vbox, VPos.CENTER);
    }

    private String getGameTimeFormatted() {
        long nanoseconds = this.gameController.getGameTime();
        long millis = TimeUnit.MILLISECONDS.convert(nanoseconds, TimeUnit.NANOSECONDS);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(millis));
        return (calendar.get(Calendar.HOUR) - 1) + "H " + calendar.get(Calendar.MINUTE) + "M " + calendar.get(Calendar.SECOND) + "S ";
    }


}
