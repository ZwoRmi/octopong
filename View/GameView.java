package View;

import Controller.IGameController;
import Model.Ball;
import Model.GoalGoalKeeper;
import Model.PolygonBoundary;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.awt.*;
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
    private ImageView logo;
    private Text copyrightText;
    private Pane gamePanel;

    public GameView() {
        this.initButtons();
        this.initPaneButtons();
        this.initLogo();
        this.initCopyright();
    }

    private void initLogo(){
        this.logo = new ImageView();
        Image logoImage = new Image("Image/logoOctopong.png");
        this.logo.setImage(logoImage);
    }

    private void initCopyright(){
        this.copyrightText = new Text();
        this.copyrightText.setTextAlignment(TextAlignment.CENTER);
        this.copyrightText.setFont(new Font(10));
        this.copyrightText.setText("Copyright © 2016 ZwoD. All rights reserved.");
    }

    @Override
    public Pane getPanel(IGameController gameController) {
        this.gameController = gameController;
        this.initPane();
        this.drawButtons();
        this.drawLogo();
        this.drawCopyright();
        this.drawTime();
        this.drawGame();
        return this.myPanel;
    }

    private void drawGame() {
        this.gamePanel = new Pane();

        this.drawGoals();
        this.drawBalls();
        this.drawGoalsKeeper();
        this.drawScores();


        this.myPanel.add(gamePanel,1,1);
    }

    private void drawPolygonBoundary() {
        for (GoalGoalKeeper goalGoalKeeper : this.gameController.getMap().getGoalsGoalKeepers()) {
            javafx.scene.shape.Polygon polygon = new Polygon(


            );
            polygon.setStyle("-fx-stroke: rgba(188, 0, 6, 0.72)");
            polygon.setFill(Color.BLUE);
            this.gamePanel.getChildren().add(polygon);
        }

    }

    private void drawGoalDetectionLine() {
        for (GoalGoalKeeper goalGoalKeeper : this.gameController.getMap().getGoalsGoalKeepers()) {
            Line line = new Line();
            line.setStrokeWidth(1);
            line.setStartX(goalGoalKeeper.getGoal().getDetectionLine().getStartPosition().getX()-125);
            line.setStartY(goalGoalKeeper.getGoal().getDetectionLine().getStartPosition().getY());
            line.setEndX(goalGoalKeeper.getGoal().getDetectionLine().getEndPosition().getX()-125);
            line.setEndY(goalGoalKeeper.getGoal().getDetectionLine().getEndPosition().getY());
            this.gamePanel.getChildren().add(line);
        }
    }

    private void drawGoalEnd() {
        for (GoalGoalKeeper goalGoalKeeper : this.gameController.getMap().getGoalsGoalKeepers()) {
            Line line = new Line();
            line.setStrokeWidth(1);
            line.setStartX(goalGoalKeeper.getGoal().getGoalEndLine().getStartPosition().getX()-125);
            line.setStartY(goalGoalKeeper.getGoal().getGoalEndLine().getStartPosition().getY());
            line.setEndX(goalGoalKeeper.getGoal().getGoalEndLine().getEndPosition().getX()-125);
            line.setEndY(goalGoalKeeper.getGoal().getGoalEndLine().getEndPosition().getY());
            this.gamePanel.getChildren().add(line);
        }
    }

    private void drawButtons() {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(this.myButtonsPanel);
        this.myPanel.add(vBox, 1, 2);
        GridPane.setHalignment(vBox, HPos.CENTER);
        GridPane.setValignment(vBox, VPos.CENTER);

    }

    private void initButtons() {
        this.initPlayButton();
        this.initPauseButton();
        this.initStopButton();
        this.initRestartButton();
        this.initGenerateBallButton();
    }

    private void initGenerateBallButton() {
        this.generateBallButton = new Button();
        this.generateBallButton.setText("Ajouter balle");
        this.generateBallButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameView.this.gameController.generateBallGame();
            }
        });
    }

    private void initRestartButton() {
        this.restartButton = new Button();
        this.restartButton.setText("Redémarrer");
        this.restartButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameView.this.gameController.restartGame();
            }
        });
    }

    private void initStopButton() {
        this.stopButton = new Button();
        this.stopButton.setText("Stop");
        this.stopButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameView.this.gameController.stopGame();
            }
        });
    }

    private void initPauseButton() {
        this.pauseButton = new Button();
        this.pauseButton.setText("Pause");
        this.pauseButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameView.this.gameController.pauseGame();
            }
        });
    }

    private void initPlayButton() {
        this.playButton = new Button();
        this.playButton.setText("Reprendre");
        this.playButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameView.this.gameController.resumeGame();
            }
        });
        this.playButton.setAlignment(Pos.CENTER);
        this.playButton.setTextAlignment(TextAlignment.CENTER);
    }

    private void initPaneButtons() {
        this.myButtonsPanel = new GridPane();
        this.myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        this.myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        this.myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        this.myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
        this.myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(192));
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
        this.myPanel = new GridPane();
        this.myPanel.getColumnConstraints().add(new ColumnConstraints(120));
        this.myPanel.getColumnConstraints().add(new ColumnConstraints(960));
        this.myPanel.getColumnConstraints().add(new ColumnConstraints(120));
        this.myPanel.getRowConstraints().add(new RowConstraints(120));
        this.myPanel.getRowConstraints().add(new RowConstraints(660));
        this.myPanel.getRowConstraints().add(new RowConstraints(80));
        this.myPanel.getRowConstraints().add(new RowConstraints(40));
        this.myPanel.setGridLinesVisible(false);
    }

    @Override
    public void drawGoals() {
        for (GoalGoalKeeper goalGoalKeeper : this.gameController.getMap().getGoalsGoalKeepers()) {
            Line line = new Line();
            line.setStrokeWidth(3);
            line.setStartX(goalGoalKeeper.getGoal().getGoalStartLine().getStartPosition().getX()-125);
            line.setStartY(goalGoalKeeper.getGoal().getGoalStartLine().getStartPosition().getY());
            line.setEndX(goalGoalKeeper.getGoal().getGoalStartLine().getEndPosition().getX()-125);
            line.setEndY(goalGoalKeeper.getGoal().getGoalStartLine().getEndPosition().getY());
            this.gamePanel.getChildren().add(line);
        }
    }

    @Override
    public void drawGoalsKeeper() {
        for (GoalGoalKeeper goalGoalKeeper : this.gameController.getMap().getGoalsGoalKeepers()) {
            Line line = new Line();
            line.setStrokeWidth(3);
            line.setStyle("-fx-stroke: rgba(71, 72, 70, 0.72)");
            line.setStartX(goalGoalKeeper.getGoalKeeper().getActualPositionStart().getStartPosition().getX()-125);
            line.setStartY(goalGoalKeeper.getGoalKeeper().getActualPositionStart().getStartPosition().getY());
            line.setEndX(goalGoalKeeper.getGoalKeeper().getActualPositionStart().getEndPosition().getX()-125);
            line.setEndY(goalGoalKeeper.getGoalKeeper().getActualPositionStart().getEndPosition().getY());
            this.gamePanel.getChildren().add(line);
        }
    }

    @Override
    public void drawBalls() {
        synchronized (this.gameController.getMap().getBalls()) {
            for (Ball ball : this.gameController.getMap().getBalls()) {
                Circle circle = new Circle();
                circle.setStyle("-fx-stroke: rgba(72, 0, 4, 0.72)");
                circle.setRadius(3);
                circle.setCenterX(ball.getActualPosition().getX() - 125);
                circle.setCenterY(ball.getActualPosition().getY());
                this.gamePanel.getChildren().add(circle);
            }
        }
    }

    @Override
    public void drawScores() {
        for (GoalGoalKeeper goalGoalKeeper : this.gameController.getMap().getGoalsGoalKeepers()) {
            Text score = new Text();
            score.setFont(new Font(20));
            score.setText(goalGoalKeeper.getGoalKeeper().getScore().getScore() + "");
            score.setX(goalGoalKeeper.getGoalKeeper().getScore().getPosition().getX());
            score.setY(goalGoalKeeper.getGoalKeeper().getScore().getPosition().getY());
            score.setTranslateX(-125);
            this.gamePanel.getChildren().add(score);
        }
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

    @Override
    public void drawLogo(){
        this.myPanel.add(this.logo,0,0);
    }

    private void drawCopyright(){
        this.myPanel.add(this.copyrightText,1,3);
        GridPane.setHalignment(this.copyrightText,HPos.CENTER);
        this.myPanel.setAlignment(Pos.CENTER);
    }
}
