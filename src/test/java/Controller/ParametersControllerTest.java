package Controller;

import Model.IMap;
import Model.Map;
import View.ApplicationWindow;
import View.IApplicationWindow;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.security.InvalidParameterException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ParametersControllerTest {
    @Mock
    IMap mockedMap;
    @Mock
    IApplicationWindow mockedApplicationWindow;
    @Mock
    IGameController mockedGameController;

    @Before
    public void setUp() {
        this.mockedMap = Mockito.mock(Map.class);
        this.mockedApplicationWindow = Mockito.mock(ApplicationWindow.class);
        this.mockedGameController = Mockito.mock(GameController.class);
    }

    @Test
    public void testSetBallSpeedCase1() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSpeed(1);
        //assert
        verify(mockedMap, times(1)).setBallSpeed(0.1f);
    }

    @Test
    public void testSetBallSpeedCase2() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSpeed(2);
        //assert
        verify(mockedMap, times(1)).setBallSpeed(0.15f);
    }

    @Test
    public void testSetBallSpeedCase3() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSpeed(3);
        //assert
        verify(mockedMap, times(1)).setBallSpeed(0.2f);
    }

    @Test
    public void testSetBallSpeedCase4() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSpeed(4);
        //assert
        verify(mockedMap, times(1)).setBallSpeed(0.25f);
    }

    @Test
    public void testSetBallSpeedCase5() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSpeed(5);
        //assert
        verify(mockedMap, times(1)).setBallSpeed(0.3f);
    }

    @Test(expected = InvalidParameterException.class)
    public void testSetBallSpeedCaseDefault() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSpeed(-1);
    }

    @Test
    public void testSetBallSPawnIntervalCase1() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSPawnInterval(1);
        //assert
        verify(mockedMap, times(1)).setBallSpawnInterval(20000);
    }

    @Test
    public void testSetBallSPawnIntervalCase2() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSPawnInterval(2);
        //assert
        verify(mockedMap, times(1)).setBallSpawnInterval(15000);
    }

    @Test
    public void testSetBallSPawnIntervalCase3() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSPawnInterval(3);
        //assert
        verify(mockedMap, times(1)).setBallSpawnInterval(10000);
    }

    @Test
    public void testSetBallSPawnIntervalCase4() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSPawnInterval(4);
        //assert
        verify(mockedMap, times(1)).setBallSpawnInterval(5000);
    }

    @Test
    public void testSetBallSPawnIntervalCase5() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSPawnInterval(5);
        //assert
        verify(mockedMap, times(1)).setBallSpawnInterval(2000);
    }

    @Test(expected = InvalidParameterException.class)
    public void testSetBallSPawnIntervalCaseDefault() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setBallSPawnInterval(-5);
    }

    @Test
    public void testStartParameters() throws Exception {
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        parametersController.startParameters();
        verify(mockedApplicationWindow, times(1)).showParameters();
    }

    @Test
    public void testStartGameAppWin() throws Exception {
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        parametersController.startGame();
        verify(mockedApplicationWindow, times(1)).showGame();
    }

    @Test
    public void testStartGameGameController() throws Exception {
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        parametersController.startGame();
        verify(mockedGameController, times(1)).startGame();
    }

    @Test
    public void testSetMap() throws Exception {
        IMap anotherMockedMap = Mockito.mock(Map.class);
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow,
                mockedGameController);
        //act
        parametersController.setMap(anotherMockedMap);
        parametersController.setBallSPawnInterval(5);
        //assert
        verify(anotherMockedMap, times(1)).setBallSpawnInterval(any(Integer.class));
    }
}