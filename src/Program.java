package src;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controller.*;
import Model.Map;
import Model.MapFactory;
import View.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author maxime
 */
public class Program extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    private static ApplicationWindow getRootView() {
        IGameView gameView = new GameView();
        IParametersView parametersView = new ParametersView();
        return new ApplicationWindow(gameView, parametersView);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new StackPane(), 1200, 800);
        primaryStage.setTitle("OctoPong");
        primaryStage.setScene(scene);
        primaryStage.show();
        ApplicationWindow appWin = getRootView();
        Map map = new MapFactory().create();
        IGameController gameController = new GameController(appWin);
        IParametersController parametersController = new ParametersController(map, appWin, gameController);
        gameController.setParametersController(parametersController);
        IGameEngine gameEngine = new GameEngine(map, gameController);
        gameController.setGameEngine(gameEngine);
        appWin.setGameController(gameController);
        appWin.setParametersController(parametersController);
        parametersController.startParameters();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                scene.setRoot(appWin.getCurrentPanel());
            }
        };
        timer.start();
    }
}
