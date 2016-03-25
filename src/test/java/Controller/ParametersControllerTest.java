package Controller;

import Model.IMap;
import Model.Map;
import View.ApplicationWindow;
import View.IApplicationWindow;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Lucas on 25/03/2016.
 */
public class ParametersControllerTest {
    @Mock
    IMap mockedMap;
    @Mock
    IApplicationWindow mockedApplicationWindow;
    @Mock
    IGameController mockedGameController;

    @Before
    public void setUp() throws Exception {
        this.mockedMap = Mockito.mock(Map.class);
        this.mockedApplicationWindow = Mockito.mock(ApplicationWindow.class);
        this.mockedGameController = Mockito.mock(GameController.class);
    }

    @Test
    public void testSetBallSpeedCase1() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow, mockedGameController);
        //act
        parametersController.setBallSpeed(1);
        //assert
        verify(mockedMap, times(1)).setBallSpeed(0.1f);
    }

    @Test
    public void testSetBallSPawnIntervalCase1() throws Exception {
        //arrange
        ParametersController parametersController = new ParametersController(mockedMap, mockedApplicationWindow, mockedGameController);
        //act
        parametersController.setBallSPawnInterval(1);
        //assert
        verify(mockedMap, times(1)).setBallSpawnInterval(20000);
    }

    @Test
    public void testStartParameters() throws Exception {

    }

    @Test
    public void testStartGame() throws Exception {

    }

    @Test
    public void testSetMap() throws Exception {

    }
}