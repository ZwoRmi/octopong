package Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DanyPatient on 25/03/2016.
 */
public class PositionProviderTest {

    @Test
    public void testGetPositionGoalStartStartNorth() throws Exception {
        Position expectedPosition = new Position(512,95);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.StartNorth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartEndNorth() throws Exception {
        Position expectedPosition = new Position(692,95);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.EndNorth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartStartNorthEast() throws Exception {
        Position expectedPosition = new Position(692,95);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.StartNorthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartEndNorthEast() throws Exception {
        Position expectedPosition = new Position(821,224);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.EndNorthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartStartEast() throws Exception {
        Position expectedPosition = new Position(821,224);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.StartEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartEndEast() throws Exception {
        Position expectedPosition = new Position(821,404);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.EndEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartStartSouthEast() throws Exception {
        Position expectedPosition = new Position(821,404);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.StartSouthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartEndSouthEast() throws Exception {
        Position expectedPosition = new Position(692,533);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.EndSouthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartStartSouth() throws Exception {
        Position expectedPosition = new Position(692,533);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.StartSouth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartEndSouth() throws Exception {
        Position expectedPosition = new Position(512,533);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.EndSouth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartStartSouthWest() throws Exception {
        Position expectedPosition = new Position(512,533);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.StartSouthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartEndSouthWest() throws Exception {
        Position expectedPosition = new Position(383,404);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.EndSouthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartStartWest() throws Exception {
        Position expectedPosition = new Position(383,404);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.StartWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartEndWest() throws Exception {
        Position expectedPosition = new Position(383,224);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.EndWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartStartNorthWest() throws Exception {
        Position expectedPosition = new Position(383,224);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.StartNorthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalStartEndNorthWest() throws Exception {
        Position expectedPosition = new Position(512,95);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalStart(GoalPositions.EndNorthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndStartNorth() throws Exception {
        Position expectedPosition = new Position(502.5f,69);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.StartNorth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndEndNorth() throws Exception {
        Position expectedPosition = new Position(701.5f,69);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.EndNorth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndStartNorthEast() throws Exception {
        Position expectedPosition = new Position(701.5f,69);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.StartNorthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndEndNorthEast() throws Exception {
        Position expectedPosition = new Position(845.5f,213.5f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.EndNorthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndStartEast() throws Exception {
        Position expectedPosition = new Position(845.5f,213.5f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.StartEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndEndEast() throws Exception {
        Position expectedPosition = new Position(845.5f,414.5f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.EndEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndStartSouthEast() throws Exception {
        Position expectedPosition = new Position(845.5f,414.5f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.StartSouthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndEndSouthEast() throws Exception {
        Position expectedPosition = new Position(701.5f,559f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.EndSouthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndStartSouth() throws Exception {
        Position expectedPosition = new Position(701.5f,559f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.StartSouth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndEndSouth() throws Exception {
        Position expectedPosition = new Position(502.5f,559f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.EndSouth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndStartSouthWest() throws Exception {
        Position expectedPosition = new Position(502.5f,559f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.StartSouthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndEndSouthWest() throws Exception {
        Position expectedPosition = new Position(359,414.5f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.EndSouthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndStartWest() throws Exception {
        Position expectedPosition = new Position(359,414.5f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.StartWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndEndWest() throws Exception {
        Position expectedPosition = new Position(359,213.5f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.EndWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndStartNorthWest() throws Exception {
        Position expectedPosition = new Position(359,213.5f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.StartNorthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionGoalEndEndNorthWest() throws Exception {
        Position expectedPosition = new Position(502.5f,69f);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionGoalEnd(GoalPositions.EndNorthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineStartNorth() throws Exception {
        Position expectedPosition = new Position(531,147);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.StartNorth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineEndNorth() throws Exception {
        Position expectedPosition = new Position(673,147);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.EndNorth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineStartNorthEast() throws Exception {
        Position expectedPosition = new Position(673,147);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.StartNorthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineEndNorthEast() throws Exception {
        Position expectedPosition = new Position(772,245);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.EndNorthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineStartEast() throws Exception {
        Position expectedPosition = new Position(772,245);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.StartEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineEndEast() throws Exception {
        Position expectedPosition = new Position(772,383);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.EndEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineStartSouthEast() throws Exception {
        Position expectedPosition = new Position(772,383);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.StartSouthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineEndSouthEast() throws Exception {
        Position expectedPosition = new Position(673,481);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.EndSouthEast);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineStartSouth() throws Exception {
        Position expectedPosition = new Position(673,481);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.StartSouth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineEndSouth() throws Exception {
        Position expectedPosition = new Position(531,481);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.EndSouth);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineStartSouthWest() throws Exception {
        Position expectedPosition = new Position(531,481);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.StartSouthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineEndSouthWest() throws Exception {
        Position expectedPosition = new Position(431,383);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.EndSouthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineStartWest() throws Exception {
        Position expectedPosition = new Position(431,383);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.StartWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineEndWest() throws Exception {
        Position expectedPosition = new Position(431,245);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.EndWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineStartNorthWest() throws Exception {
        Position expectedPosition = new Position(431,245);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.StartNorthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetPositionDetectionLineEndNorthWest() throws Exception {
        Position expectedPosition = new Position(531,147);
        PositionProvider positionProvider = new PositionProvider();
        Position actualPosition = positionProvider.getPositionDetectionLine(GoalPositions.EndNorthWest);
        assertEquals(expectedPosition,actualPosition);
    }

    @Test
    public void testGetScorePosition() throws Exception {

    }

    @Test
    public void testGetGoalKeeperPositionStart() throws Exception {

    }

    @Test
    public void testGetGoalKeeperPositionEnd() throws Exception {

    }

    @Test
    public void testGetStartGoalPosition() throws Exception {

    }

    @Test
    public void testGetEndGoalPosition() throws Exception {

    }
}