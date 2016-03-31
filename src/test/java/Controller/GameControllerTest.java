package Controller;

import Model.*;
import View.ApplicationWindow;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameControllerTest {
    private IGameController gameController;
    private IGameEngine mockedGameEngine;
    private IParametersController mockedParametersController;

    @Before
    public void setUp() {
        this.mockedGameEngine = Mockito.mock(GameEngine.class);
        Mockito.when(mockedGameEngine.getMap()).thenReturn(this.getMap());
        this.mockedParametersController = Mockito.mock(ParametersController.class);
        this.gameController = new GameController(Mockito.mock(ApplicationWindow.class));
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
        this.gameController.setParametersController(this.mockedParametersController);
        this.gameController.startGame();
        this.gameController.stopGame();
        verify(mockedGameEngine, times(1)).stopGame();
    }

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

    @Test
    public void testSetParametersController() throws Exception {
        ParametersController parametersController = new ParametersController(null, null, null);
        this.gameController.setParametersController(parametersController);
        assertEquals(parametersController, this.gameController.getParametersController());
    }

    @Test
    public void testControlSouthGoalKeeper() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        GoalKeeper goalKeeper = this.gameController.getSouthGoalKeeper();
        this.gameController.ControlSouthGoalKeeper();
        assertEquals(true, goalKeeper.getPlayedByHuman());
    }

    @Test
    public void testMoveSouthGoalKeeper() throws Exception {
        IGoalEngine mockedGoalEngine = Mockito.mock(GoalEngine.class);
        Mockito.when(mockedGoalEngine.isInLimitedArea(any(GoalKeeper.class), any(Line.class))).thenReturn(true);
        Mockito.when(this.mockedGameEngine.getGoalEngine()).thenReturn(mockedGoalEngine);
        this.gameController.setGameEngine(mockedGameEngine);
        GoalKeeper goalKeeper = this.gameController.getSouthGoalKeeper();
        goalKeeper.setPlayedByHuman(true);
        this.gameController.MoveSouthGoalKeeper(1);
        assertEquals(1, goalKeeper.getActualPositionStart().getStartPosition().getX(), 0.0000000001);
    }

    @Test
    public void testGetSouthGoalKeeper() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        GoalKeeper goalKeeper = this.gameController.getSouthGoalKeeper();
        assertEquals(GoalPosition.South, goalKeeper.getGoalPosition());
    }

    @Test
    public void testUnControlSouthGoalKeeper() throws Exception {
        this.gameController.setGameEngine(mockedGameEngine);
        this.gameController.setParametersController(this.mockedParametersController);
        GoalKeeper goalKeeper = this.gameController.getSouthGoalKeeper();
        this.gameController.ControlSouthGoalKeeper();
        this.gameController.UnControlSouthGoalKeeper();
        assertEquals(false, goalKeeper.getPlayedByHuman());
    }

    private Map getMap() {
        Map map = new Map(null);
        map.setGoalsGoalKeepers(this.getGoalGoalKeepers());
        return map;
    }

    private List<GoalGoalKeeper> getGoalGoalKeepers() {
        GoalKeeper goalKeeper = new GoalKeeper();
        goalKeeper.setPlayedByHuman(false);
        goalKeeper.setGoalPosition(GoalPosition.South);
        goalKeeper.setActualPositionStart(new Line(new Position(), new Position()));
        goalKeeper.setActualPositionEnd(new Line(new Position(), new Position()));
        GoalGoalKeeper goalGoalKeeper = new GoalGoalKeeper();
        goalGoalKeeper.setGoalKeeper(goalKeeper);
        List<GoalGoalKeeper> goalGoalKeepers = new ArrayList<>();
        goalGoalKeepers.add(goalGoalKeeper);
        return goalGoalKeepers;
    }
}