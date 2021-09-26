package rover.java.strategy;

import org.junit.jupiter.api.Test;
import rover.java.main.Coordinate;
import rover.java.main.enums.Facing;
import rover.java.main.strategy.EastFacingStrategy;
import rover.java.main.strategy.NorthFacingStrategy;
import rover.java.main.strategy.SouthFacingStrategy;
import rover.java.main.strategy.WestFacingStrategy;

import static org.junit.jupiter.api.Assertions.*;

class FacingStrategyTest {

    @Test
    void getFacinDirection_shouldReturnNorth_whenFacingStrategyNorth() {
        var strategy = new NorthFacingStrategy();
        assertEquals(Facing.NORTH, strategy.getFacingDirection());
    }

    @Test
    void getFacinDirection_shouldReturnEast_whenFacingStrategyEast() {
        var strategy = new EastFacingStrategy();
        assertEquals(Facing.EAST, strategy.getFacingDirection());
    }

    @Test
    void getFacinDirection_shouldReturnSouth_whenFacingStrategySouth() {
        var strategy = new SouthFacingStrategy();
        assertEquals(Facing.SOUTH, strategy.getFacingDirection());
    }

    @Test
    void getFacinDirection_shouldReturnWest_whenFacingStrategyWest() {
        var strategy = new WestFacingStrategy();
        assertEquals(Facing.WEST, strategy.getFacingDirection());
    }

    @Test
    void getNextFacingStrategy_shouldReturnEast_whenFacingStrategyNorth() {
        var strategy = new NorthFacingStrategy();
        assertEquals(Facing.EAST, strategy.getNextStrategy().getFacingDirection());
    }

    @Test
    void getNextFacingStrategy_shouldReturnSouth_whenFacingStrategyEast() {
        var strategy = new EastFacingStrategy();
        assertEquals(Facing.SOUTH, strategy.getNextStrategy().getFacingDirection());
    }

    @Test
    void getNextFacingStrategy_shouldReturnWest_whenFacingStrategySouth() {
        var strategy = new SouthFacingStrategy();
        assertEquals(Facing.WEST, strategy.getNextStrategy().getFacingDirection());
    }

    @Test
    void getNextFacingStrategy_shouldReturnNorth_whenFacingStrategyWest() {
        var strategy = new WestFacingStrategy();
        assertEquals(Facing.NORTH, strategy.getNextStrategy().getFacingDirection());
    }

    @Test
    void getPreviousStrategy_shouldReturnWest_whenFacingStrategyNorth() {
        var strategy = new NorthFacingStrategy();
        assertEquals(Facing.WEST, strategy.getPreviousStrategy().getFacingDirection());
    }

    @Test
    void getPreviousStrategy_shouldReturnNorth_whenFacingStrategyEast() {
        var strategy = new EastFacingStrategy();
        assertEquals(Facing.NORTH, strategy.getPreviousStrategy().getFacingDirection());
    }

    @Test
    void getPreviousStrategy_shouldReturnEast_whenFacingStrategySouth() {
        var strategy = new SouthFacingStrategy();
        assertEquals(Facing.EAST, strategy.getPreviousStrategy().getFacingDirection());
    }

    @Test
    void getPreviousStrategy_shouldReturnSouth_whenFacingStrategyWest() {
        var strategy = new WestFacingStrategy();
        assertEquals(Facing.SOUTH, strategy.getPreviousStrategy().getFacingDirection());
    }

    @Test
    void moveForward_shouldIncrementY_whenFacingStrategyNorth() {
        var strategy = new NorthFacingStrategy();
        var coordinate = strategy.moveForward(new Coordinate(0, 0));
        assertEquals(0, coordinate.getX());
        assertEquals(1, coordinate.getY());
    }

    @Test
    void moveForward_shouldIncrementX_whenFacingStrategyEast() {
        var strategy = new EastFacingStrategy();
        var coordinate = strategy.moveForward(new Coordinate(0, 0));
        assertEquals(1, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    void moveForward_shouldDecrementY_whenFacingStrategySouth() {
        var strategy = new SouthFacingStrategy();
        var coordinate = strategy.moveForward(new Coordinate(0, 0));
        assertEquals(0, coordinate.getX());
        assertEquals(-1, coordinate.getY());
    }

    @Test
    void moveForward_shouldDecrementX_whenFacingStrategyWest() {
        var strategy = new WestFacingStrategy();
        var coordinate = strategy.moveForward(new Coordinate(0, 0));
        assertEquals(-1, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    void moveBack_shouldIncrementY_whenFacingStrategyNorth() {
        var strategy = new NorthFacingStrategy();
        var coordinate = strategy.moveBack(new Coordinate(0, 0));
        assertEquals(0, coordinate.getX());
        assertEquals(-1, coordinate.getY());
    }

    @Test
    void moveBack_shouldIncrementX_whenFacingStrategyEast() {
        var strategy = new EastFacingStrategy();
        var coordinate = strategy.moveBack(new Coordinate(0, 0));
        assertEquals(-1, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    void moveBack_shouldDecrementY_whenFacingStrategySouth() {
        var strategy = new SouthFacingStrategy();
        var coordinate = strategy.moveBack(new Coordinate(0, 0));
        assertEquals(0, coordinate.getX());
        assertEquals(1, coordinate.getY());
    }

    @Test
    void moveBack_shouldDecrementX_whenFacingStrategyWest() {
        var strategy = new WestFacingStrategy();
        var coordinate = strategy.moveBack(new Coordinate(0, 0));
        assertEquals(1, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }
}