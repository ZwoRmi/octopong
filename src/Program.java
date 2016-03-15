package src;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controller.*;
import Model.MapFactory;
import View.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import Model.Map;

/**
 *
 * @author maxime
 */
public class Program extends Application{
    private static StackPane root;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    private static ApplicationWindow getRootView() {
        IGameView gameView = new GameView();
        IParametersView parametersView = new ParametersView();
        return new ApplicationWindow(gameView, parametersView, root);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new StackPane();
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("OctoPong");
        primaryStage.setScene(scene);
        root.setStyle("-fx-background-color: #ffffff");
        primaryStage.show();
        ApplicationWindow appWin = getRootView();
        Map map = new MapFactory().create();
        IParametersController parametersController = new ParametersController(map, appWin);
        IGameController gameController = new GameController(appWin);
        IGameEngine gameEngine = new GameEngine(map, gameController);
        gameController.setGameEngine(gameEngine);
        appWin.setGameController(gameController);
        appWin.setParametersController(parametersController);
        parametersController.startParameters();
    }
}
