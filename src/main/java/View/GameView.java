package View;

import Controller.IGameController;
import Model.Ball;
import Model.GoalGoalKeeper;
import Model.PolygonBoundary;
import Util.StopWatch;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GameView implements IGameView {
    private GridPane myPanel;
    private IGameController gameController;
    private GridPane myButtonsPanel;
    private Button playPauseButton;
    private Button restartButton;
    private Button stopButton;
    private Button startGameButton;
    private Button generateBallButton;
    private ImageView logo;
    private Text copyrightText;
    private Pane gamePanel;
    private ImageView commandToControlGoalKeeper;
    private Text timerToControlGoalKeeper;
    private boolean showGameInstructions;
    private StopWatch stopWatch;
    private boolean isPlaying;

    public GameView() {
        this.showGameInstructions = false;
        this.isPlaying = true;
        this.initButtons();
        this.initPaneButtons();
        this.initLogo();
        this.initCopyright();
        this.initCommandToControlGoalKeeper();
        this.initTimerToControlGoalKeeper();
    }

    private void initLogo(){
        this.logo = new ImageView();
        Image logoImage = new Image("logoOctopong.png");
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
        if(this.showGameInstructions){
            this.drawCommandToControlGoalKeeper();
            this.drawTimerToControlGoalKeeper();
        }
        this.myPanel.add(this.gamePanel,1,1);
    }

    private void drawGoalsKeepersArea() {
        for (GoalGoalKeeper goalGoalKeeper : this.gameController.getMap().getGoalsGoalKeepers()) {
            PolygonBoundary polygonBoundary = new PolygonBoundary(
                    goalGoalKeeper.getGoalKeeper().getActualPositionStart(),
                    goalGoalKeeper.getGoalKeeper().getActualPositionEnd());
            Polygon polygon = polygonBoundary.getPolygon();

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
        this.initPlayPauseButton();
        this.initStopButton();
        this.initRestartButton();
        this.initStartGameButton();
        this.initGenerateBallButton();
    }

    private void initGenerateBallButton() {
        this.generateBallButton = new ImageButton("addBallIconButton.png");
        this.generateBallButton.setPrefWidth(1);
        this.generateBallButton.setAlignment(Pos.CENTER);
        this.generateBallButton.setOnMousePressed(event -> GameView.this.gameController.generateBallGame());
    }

    private void initRestartButton() {
        this.restartButton = new ImageButton("restartIconButton.png");
        this.restartButton.setAlignment(Pos.CENTER);
        this.restartButton.setPrefWidth(1);
        this.restartButton.setOnMousePressed(event -> {
            GameView.this.gameController.restartGame();
            this.showGameInstructions = false;
            this.stopWatch.reset();
            this.startGameButton.setGraphic(new ImageView("playIconButton.png"));
        });
    }

    private void initStopButton() {
        this.stopButton = new ImageButton("stopIconButton.png");
        this.stopButton.setPrefWidth(1);
        this.stopButton.setAlignment(Pos.CENTER);
        this.stopButton.setOnMousePressed(event -> {
            GameView.this.gameController.stopGame();
            this.showGameInstructions = false;
            this.stopWatch.reset();
            this.startGameButton.setGraphic(new ImageView("playIconButton.png"));
        });
    }

    private void initPlayPauseButton() {
        this.playPauseButton = new ImageButton("pauseIconButton.png");
        this.playPauseButton.setPrefWidth(1);
        this.playPauseButton.setAlignment(Pos.CENTER);
        this.playPauseButton.setTextAlignment(TextAlignment.CENTER);
        this.playPauseButton.setOnMousePressed(
                event -> {
                    if(!this.isPlaying){
                        GameView.this.gameController.resumeGame();
                        this.playPauseButton.setGraphic(new ImageView("pauseIconButton.png"));
                        this.isPlaying = true;
                    } else {
                        GameView.this.gameController.pauseGame();
                        this.playPauseButton.setGraphic(new ImageView("resumeIconButton.png"));
                        this.isPlaying = false;
                    }
                }
        );
    }

    private void initStartGameButton() {
        this.startGameButton = new ImageButton("playIconButton.png");
        this.startGameButton.setPrefWidth(1);
        this.startGameButton.setAlignment(Pos.CENTER);
        this.startGameButton.setTextAlignment(TextAlignment.CENTER);
        this.startGameButton.setOnMousePressed(event -> {
            if(!showGameInstructions && gameController.getSouthGoalKeeper().getPlayedByHuman()){
                this.startGameButton.setGraphic(new ImageView("playIconButton.png"));
                GameView.this.gameController.UnControlSouthGoalKeeper();
                this.stopWatch.reset();
            } else if(!showGameInstructions){
                this.startGameButton.setGraphic(new ImageView("stopPlayIconButton.png"));
                this.showGameInstructions = true;
                GameView.this.gameController.pauseGame();
                GameView.this.gameController.ControlSouthGoalKeeper();
                this.stopWatch.start();
            }
        });
    }

    private void initTimerToControlGoalKeeper() {
        this.timerToControlGoalKeeper = new Text();
        this.timerToControlGoalKeeper.setTextAlignment(TextAlignment.CENTER);
        this.timerToControlGoalKeeper.setFont(new Font(60));
        this.stopWatch = new StopWatch();
    }

    private void drawTimerToControlGoalKeeper(){
        this.myPanel.add(this.timerToControlGoalKeeper,1,1);
        GridPane.setValignment(this.timerToControlGoalKeeper,VPos.CENTER);
        GridPane.setHalignment(this.timerToControlGoalKeeper,HPos.CENTER);
        if(this.stopWatch.isStarted() && this.stopWatch.getTime() > 5000){
            this.setColorToSouthGoalKeeper(true);
            this.showGameInstructions = false;
            GameView.this.gameController.ControlSouthGoalKeeper();
            GameView.this.gameController.resumeGame();
            GameView.this.gameController.resumeGame();
            stopWatch.reset();
        }
        else if (this.stopWatch.getTime()>4000){
            this.setColorToSouthGoalKeeper(false);
            this.timerToControlGoalKeeper.setText("1");
        }
        else if (this.stopWatch.getTime()>3000){
            this.setColorToSouthGoalKeeper(true);
            this.timerToControlGoalKeeper.setText("2");
        }
        else if (this.stopWatch.getTime()>2000){
            this.setColorToSouthGoalKeeper(false);
            this.timerToControlGoalKeeper.setText("3");
        }else if (this.stopWatch.getTime()>1000){
            this.setColorToSouthGoalKeeper(true);
            this.timerToControlGoalKeeper.setText("4");
        }else {
            this.setColorToSouthGoalKeeper(false);
            this.timerToControlGoalKeeper.setText("5");
        }
    }

    private void setColorToSouthGoalKeeper(boolean isBlack){
        if(isBlack) {
            gameController.getSouthGoalKeeper().setColor(Color.BLACK);
        }
        else{
            gameController.getSouthGoalKeeper().setColor(Color.TRANSPARENT);
        }
    }
    private void initCommandToControlGoalKeeper() {
        this.commandToControlGoalKeeper = new ImageView();
        Image commandImage = new Image("command.png");
        this.commandToControlGoalKeeper.setImage(commandImage);
    }

    private void drawCommandToControlGoalKeeper(){
        this.myPanel.add(this.commandToControlGoalKeeper,1,1);
        GridPane.setValignment(this.commandToControlGoalKeeper,VPos.BOTTOM);
        GridPane.setHalignment(this.commandToControlGoalKeeper,HPos.CENTER);
    }

    private void initPaneButtons() {
        this.myButtonsPanel = new GridPane();
        this.myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(320));
        this.myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(320));
        this.myButtonsPanel.getColumnConstraints().add(new ColumnConstraints(320));
        this.myButtonsPanel.getRowConstraints().add(new RowConstraints(60));
        this.myButtonsPanel.getRowConstraints().add(new RowConstraints(60));
        this.myButtonsPanel.add(this.playPauseButton, 0, 0);
        GridPane.setHalignment(this.playPauseButton, HPos.CENTER);
        GridPane.setValignment(this.playPauseButton, VPos.CENTER);
        this.myButtonsPanel.add(this.restartButton, 1, 0);
        GridPane.setHalignment(this.restartButton, HPos.CENTER);
        GridPane.setValignment(this.restartButton, VPos.CENTER);
        this.myButtonsPanel.add(this.stopButton, 2, 0);
        GridPane.setHalignment(this.stopButton, HPos.CENTER);
        GridPane.setValignment(this.stopButton, VPos.CENTER);
        this.myButtonsPanel.add(this.generateBallButton, 0, 1, 2, 1);
        GridPane.setHalignment(this.generateBallButton, HPos.CENTER);
        GridPane.setValignment(this.generateBallButton, VPos.CENTER);
        this.myButtonsPanel.add(this.startGameButton, 1, 1, 2, 1);
        GridPane.setHalignment(this.startGameButton, HPos.CENTER);
        GridPane.setValignment(this.startGameButton, VPos.CENTER);
    }

    private void initPane() {
        this.myPanel = new GridPane();
        this.myPanel.getColumnConstraints().add(new ColumnConstraints(120));
        this.myPanel.getColumnConstraints().add(new ColumnConstraints(960));
        this.myPanel.getColumnConstraints().add(new ColumnConstraints(120));
        this.myPanel.getRowConstraints().add(new RowConstraints(120));
        this.myPanel.getRowConstraints().add(new RowConstraints(660));
        this.myPanel.getRowConstraints().add(new RowConstraints(120));
        this.myPanel.getRowConstraints().add(new RowConstraints(40));
        this.myPanel.setGridLinesVisible(false);
        this.myButtonsPanel.setGridLinesVisible(false);
    }

    @Override
    public void drawGoals() {
        for (GoalGoalKeeper goalGoalKeeper : this.gameController.getMap().getGoalsGoalKeepers()) {
            Line line = new Line();
            line.setStrokeWidth(3);
            line.setStroke(Color.rgb(222,175,85));
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
            line.setStroke(goalGoalKeeper.getGoalKeeper().getColor());
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
                circle.setFill(ball.getColor());
                circle.setRadius(ball.getRadius());
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
            score.setStroke(Color.rgb(120,120,120));
            score.setText(goalGoalKeeper.getGoalKeeper().getScore().getScore() + "");
            score.setX(goalGoalKeeper.getGoalKeeper().getScore().getPosition().getX());
            score.setY(goalGoalKeeper.getGoalKeeper().getScore().getPosition().getY());
            score.setTranslateX(-125);
            this.gamePanel.getChildren().add(score);
        }
    }

    @Override
    public void drawTime() {
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText(this.getGameTimeFormatted());
        GridPane.setHalignment(t,HPos.CENTER);
        GridPane.setValignment(t,VPos.CENTER);
        this.myPanel.add(t, 2, 0);
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
        this.myPanel.add(this.copyrightText,1,4);
        GridPane.setHalignment(this.copyrightText,HPos.CENTER);
        GridPane.setValignment(this.copyrightText,VPos.BOTTOM);
        this.myPanel.setAlignment(Pos.CENTER);
    }

}
