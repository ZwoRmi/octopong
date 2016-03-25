package Controller;

import Model.IMap;
import Model.Map;
import View.ApplicationWindow;
import View.IApplicationWindow;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameControllerTest {
    private IGameController gameController;
    private IGameEngine mockedGameEngine;
    private IApplicationWindow mockedApplicationWindow;
    private IParametersController mockedParametersController;

    @Before
    public void setUp() throws Exception {
        this.mockedGameEngine = Mockito.mock(GameEngine.class);
        this.mockedApplicationWindow = Mockito.mock(ApplicationWindow.class);
        this.gameController = new GameController(this.mockedApplicationWindow);
    }

    @Test
    public void testStartGame() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        this.gameController.startGame();
        verify(mockedGameEngine, times(1)).startGame();
    }

    @Test
    public void testResumeGame() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        this.gameController.startGame();
        this.gameController.pauseGame();
        this.gameController.resumeGame();
        verify(mockedGameEngine, times(1)).resumeGame();
    }

    @Test
    public void testPauseGame() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        this.gameController.startGame();
        this.gameController.pauseGame();
        verify(mockedGameEngine, times(1)).pauseGame();
    }

    @Test
    public void testRestartGame() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        this.gameController.startGame();
        this.gameController.restartGame();
        verify(mockedGameEngine, times(1)).restartGame();
    }

    @Test
    public void testStopGame() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        this.gameController.setParametersController(mockedParametersController);
        this.gameController.startGame();
        this.gameController.stopGame();
        verify(mockedGameEngine, times(1)).stopGame();
    }

    @Ignore
    @Test
    public void testGenerateBallGame() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        this.gameController.generateBallGame();
        verify(mockedGameEngine, times(1)).generateBall();
    }

    @Test
    public void testGetMap() throws Exception {
        IMap map = new Map(new ArrayList<>());
        GameEngine gameEngine = new GameEngine(new Map(null));
        this.gameController.setGameEngine(gameEngine);
        this.gameController.setMap(map);
        assertEquals(map, this.gameController.getMap());
    }

    @Ignore
    @Test
    public void testSetParametersController() throws Exception {
        throw new NotImplementedException();
        //TODO implement me
    }

    @Ignore
    @Test
    public void testGetGameTime() throws Exception {
        throw new NotImplementedException();
        //TODO implement me
    }

    @Ignore
    @Test
    public void testControlSouthGoalKeeper() throws Exception {
        throw new NotImplementedException();
        //TODO implement me
    }

    @Ignore
    @Test
    public void testMoveSouthGoalKeeper() throws Exception {
        throw new NotImplementedException();
        //TODO implement me
    }

    @Ignore
    @Test
    public void testGetSouthGoalKeeper() throws Exception {
        throw new NotImplementedException();
        //TODO implement me
    }

    @Ignore
    @Test
    public void testUnControlSouthGoalKeeper() throws Exception {
        throw new NotImplementedException();
        //TODO implement me
    }
}