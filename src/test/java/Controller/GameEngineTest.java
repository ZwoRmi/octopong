package Controller;

import Model.IMap;
import Model.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GameEngineTest {
    IGameEngine gameEngine;
    IMap mockedMap;
    IGoalEngine mockedGoalEngine;
    IBallEngine mockedBallEngine;

    @Before
    public void setUp() {
        this.mockedMap = Mockito.mock(Map.class);
        this.gameEngine = new GameEngine(mockedMap);
        this.mockedBallEngine = Mockito.mock(BallEngine.class);
        this.mockedGoalEngine = Mockito.mock(GoalEngine.class);
    }

    @Test
    public void testUpdateBallEngine() throws Exception {
        this.gameEngine.setBallEngine(mockedBallEngine);
        this.gameEngine.updateBallEngine();
        verify(mockedBallEngine, times(1)).update();
    }

    @Test
    public void testUpdateGoalEngine() throws Exception {
        this.gameEngine.setGoalEngine(mockedGoalEngine);
        this.gameEngine.updateGoalEngine();
        verify(mockedGoalEngine, times(1)).update();
    }

    @Test
    public void testGetMap() throws Exception {
        Map expected = new Map(null);
        this.gameEngine.setMap(expected);
        assertEquals(expected, this.gameEngine.getMap());
    }

    @Test
    public void testGetGoalEngine() throws Exception {
        GoalEngine expected = new GoalEngine(this.mockedMap);
        this.gameEngine.setGoalEngine(expected);
        assertEquals(expected, this.gameEngine.getGoalEngine());
    }

    @Test
    public void testGetBallEngine() throws Exception {
        BallEngine expected = new BallEngine(this.mockedMap);
        this.gameEngine.setBallEngine(expected);
        assertEquals(expected, this.gameEngine.getBallEngine());
    }

    @Test
    public void testGenerateBall() throws Exception {
        this.gameEngine.setBallEngine(mockedBallEngine);
        this.gameEngine.generateBall();
        verify(mockedBallEngine, times(1)).generateBall();
    }

    @Test
    public void testRestartGameRegenerateMap() throws Exception {
        Map expected = new Map(null);
        this.gameEngine.setMap(expected);
        this.gameEngine.restartGame();
        assertThat(expected, not(this.gameEngine.getMap()));
    }

    @Test
    public void testRestartGameRegenerateGoalEngine() throws Exception {
        GoalEngine expected = new GoalEngine(this.mockedMap);
        this.gameEngine.setGoalEngine(expected);
        this.gameEngine.restartGame();
        assertThat(expected, not(this.gameEngine.getGoalEngine()));
    }

    @Test
    public void testRestartGameRegenerateBallEngine() throws Exception {
        BallEngine expected = new BallEngine(this.mockedMap);
        this.gameEngine.setBallEngine(expected);
        this.gameEngine.restartGame();
        assertThat(expected, not(this.gameEngine.getBallEngine()));
    }

    @Test
    public void testRestartGameConserveBallSpeed() throws Exception {
        float ballSpeed = 71f;
        IMap map = Mockito.mock(Map.class);
        Mockito.when(map.getBallSpeed()).thenReturn(ballSpeed);
        this.gameEngine.setMap(map);
        this.gameEngine.restartGame();
        assertEquals(ballSpeed, this.gameEngine.getMap().getBallSpeed(), 0.000000000000001);
    }

    @Test
    public void testRestartGameConserveBallSpawnInterval() throws Exception {
        long ballSPawnInterval = 31;
        IMap map = Mockito.mock(Map.class);
        Mockito.when(map.getBallSpawnInterval()).thenReturn(ballSPawnInterval);
        this.gameEngine.setMap(map);
        this.gameEngine.restartGame();
        assertEquals(ballSPawnInterval, this.gameEngine.getMap().getBallSpawnInterval(), 0.000000000000001);
    }

    @Test
    public void testStopGameRegenerateGoalEngine() throws Exception {
        GoalEngine expected = new GoalEngine(this.mockedMap);
        this.gameEngine.setGoalEngine(expected);
        this.gameEngine.stopGame();
        assertThat(expected, not(this.gameEngine.getGoalEngine()));
    }

    @Test
    public void testStopGameRegenerateBallEngine() throws Exception {
        BallEngine expected = new BallEngine(this.mockedMap);
        this.gameEngine.setBallEngine(expected);
        this.gameEngine.stopGame();
        assertThat(expected, not(this.gameEngine.getBallEngine()));
    }

    @Test
    public synchronized void testStartGameUpdateBallEngine() throws Exception {
        this.gameEngine.setBallEngine(mockedBallEngine);
        this.gameEngine.startGame();
        Thread.sleep(500);
        verify(mockedBallEngine, atLeastOnce()).update();
    }

    @Test
    public synchronized void testStartGameUpdateGoalEngine() throws Exception {
        this.gameEngine.setGoalEngine(mockedGoalEngine);
        this.gameEngine.startGame();
        Thread.sleep(500);
        verify(mockedGoalEngine, atLeastOnce()).update();
    }

    @Test
    public synchronized void testPauseGameDoNotUpdateGoalEngine() throws Exception {
        this.gameEngine.setGoalEngine(mockedGoalEngine);
        this.gameEngine.startGame();
        Thread.sleep(500);
        this.gameEngine.pauseGame();
        Thread.sleep(200);
        Mockito.reset(mockedGoalEngine);
        Thread.sleep(500);
        verify(mockedGoalEngine, times(0)).update();
    }

    @Test
    public synchronized void testPauseGameDoNotUpdateBallEngine() throws Exception {
        this.gameEngine.setBallEngine(mockedBallEngine);
        this.gameEngine.startGame();
        Thread.sleep(500);
        this.gameEngine.pauseGame();
        Thread.sleep(200);
        Mockito.reset(mockedBallEngine);
        Thread.sleep(500);
        verify(mockedBallEngine, times(0)).update();
    }

    @Test
    public synchronized void testStopGameDoNotUpdateGoalEngine() throws Exception {
        this.gameEngine.setGoalEngine(mockedGoalEngine);
        this.gameEngine.startGame();
        Thread.sleep(500);
        this.gameEngine.stopGame();
        Thread.sleep(200);
        Mockito.reset(mockedGoalEngine);
        Thread.sleep(500);
        verify(mockedGoalEngine, times(0)).update();
    }

    @Test
    public synchronized void testStopGameDoNotUpdateBallEngine() throws Exception {
        this.gameEngine.setBallEngine(mockedBallEngine);
        this.gameEngine.startGame();
        Thread.sleep(500);
        this.gameEngine.stopGame();
        Thread.sleep(200);
        Mockito.reset(mockedBallEngine);
        Thread.sleep(500);
        verify(mockedBallEngine, times(0)).update();
    }

    @Test
    public synchronized void testRestartGameUpdateBallEngine() throws Exception {
        this.gameEngine.setBallEngine(mockedBallEngine);
        this.gameEngine.restartGame();
        this.gameEngine.setBallEngine(mockedBallEngine);
        Thread.sleep(500);
        verify(mockedBallEngine, atLeastOnce()).update();
    }

    @Test
    public synchronized void testRestartGameUpdateGoalEngine() throws Exception {
        this.gameEngine.setGoalEngine(mockedGoalEngine);
        this.gameEngine.restartGame();
        this.gameEngine.setGoalEngine(mockedGoalEngine);
        Thread.sleep(500);
        verify(mockedGoalEngine, atLeastOnce()).update();
    }

    @Test
    public synchronized void testResumeGameUpdateBallEngine() throws Exception {
        this.gameEngine.setBallEngine(mockedBallEngine);
        this.gameEngine.resumeGame();
        Thread.sleep(500);
        verify(mockedBallEngine, atLeastOnce()).update();
    }

    @Test
    public synchronized void testResumeGameUpdateGoalEngine() throws Exception {
        this.gameEngine.setGoalEngine(mockedGoalEngine);
        this.gameEngine.resumeGame();
        Thread.sleep(500);
        verify(mockedGoalEngine, atLeastOnce()).update();
    }
}