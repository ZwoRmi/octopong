import Controller.*;
import Model.IMap;
import Model.MapFactory;
import View.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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

    private static IApplicationWindow getRootView() {
        IGameView gameView = new GameView();
        IParametersView parametersView = new ParametersView();
        return new ApplicationWindow(gameView, parametersView);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new StackPane(), 1920, 1000);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("OctoPong");
        primaryStage.setScene(scene);
        primaryStage.show();
        IApplicationWindow appWin = getRootView();
        IMap IMap = new MapFactory().create();
        IGameController gameController = new GameController(appWin);
        IParametersController parametersController = new ParametersController(IMap, appWin, gameController);
        gameController.setParametersController(parametersController);
        IGameEngine gameEngine = new GameEngine(IMap);
        gameController.setGameEngine(gameEngine);
        appWin.setGameController(gameController);
        appWin.setParametersController(parametersController);
        parametersController.startParameters();
        this.initKeys(scene, gameController);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                scene.setRoot(appWin.getCurrentPanel());
            }
        };
        timer.start();
    }
    private void initKeys(Scene scene, final IGameController gameController) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT){
                for (int i = 0;i<10;i++){
                    gameController.MoveSouthGoalKeeper(1);
                }
            }else if (event.getCode() == KeyCode.LEFT){
                for (int i = 0;i<10;i++){
                    gameController.MoveSouthGoalKeeper(-1);
                }
            }
            event.consume();
        });
    }
}
