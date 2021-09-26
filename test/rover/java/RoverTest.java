package rover.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rover.java.main.Coordinate;
import rover.java.main.Rover;
import rover.java.main.commands.BackCommand;
import rover.java.main.commands.ForwardCommand;
import rover.java.main.commands.TurnLeftCommand;
import rover.java.main.commands.TurnRightCommand;
import rover.java.main.enums.Facing;
import rover.java.main.strategy.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverTest {
    private final Coordinate initCoord = new Coordinate(0, 0);
    private final FacingStrategy initFacingStrategy = new NorthFacingStrategy();
    private Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover(initCoord, initFacingStrategy);
    }

    @Test
    void rover_shouldIinit() {
        assertEquals(rover.getFacingDirection(), Facing.NORTH);
        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
    }

    @Test
    void rover_shouldMoveForwardNorth() {
        var cmd = new ForwardCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(0, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
    }

    @Test
    void rover_shouldMoveBackNorth() {
        var cmd = new BackCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(0, rover.getPosition().getX());
        assertEquals(-1, rover.getPosition().getY());
    }

    @Test
    void rover_shouldMoveForwardEast() {
        rover.setFacingStrategy(new EastFacingStrategy());

        var cmd = new ForwardCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(1, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
    }

    @Test
    void rover_shouldMoveBackEast() {
        rover.setFacingStrategy(new EastFacingStrategy());

        var cmd = new BackCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(-1, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
    }

    @Test
    void rover_shouldMoveForwardSouth() {
        rover.setFacingStrategy(new SouthFacingStrategy());

        var cmd = new ForwardCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(0, rover.getPosition().getX());
        assertEquals(-1, rover.getPosition().getY());
    }

    @Test
    void rover_shouldMoveBackSouth() {
        rover.setFacingStrategy(new SouthFacingStrategy());

        var cmd = new BackCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(0, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
    }

    @Test
    void rover_shouldMoveForwardWest() {
        rover.setFacingStrategy(new WestFacingStrategy());

        var cmd = new ForwardCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(-1, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
    }

    @Test
    void rover_shouldMoveBackWest() {
        rover.setFacingStrategy(new WestFacingStrategy());

        var cmd = new BackCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(1, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
    }

    @Test
    void rover_shouldTurnRight() {
        var cmd = new TurnRightCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.EAST, rover.getFacingDirection());
    }

    @Test
    void rover_shouldTurnLeft() {
        var cmd = new TurnLeftCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.WEST, rover.getFacingDirection());
    }

    @Test
    void rover_shouldBeFacingEast_whenTurnRight_afterFacingNorth() {
        rover.setFacingStrategy(new NorthFacingStrategy());

        var cmd = new TurnRightCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.EAST, rover.getFacingDirection());
    }

    @Test
    void rover_shouldBeFacingWest_whenTurnLeft_afterFacingNorth() {
        rover.setFacingStrategy(new NorthFacingStrategy());

        var cmd = new TurnRightCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.EAST, rover.getFacingDirection());
    }

    @Test
    void rover_shouldBeFacingSouth_whenTurnRight_afterFacingEast() {
        rover.setFacingStrategy(new EastFacingStrategy());

        var cmd = new TurnRightCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.SOUTH, rover.getFacingDirection());
    }

    @Test
    void rover_shouldBeFacingNorth_whenTurnLeft_afterFacingEast() {
        rover.setFacingStrategy(new EastFacingStrategy());

        var cmd = new TurnLeftCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.NORTH, rover.getFacingDirection());
    }

    @Test
    void rover_shouldBeFacingWest_whenTurnRight_afterFacingSouth() {
        rover.setFacingStrategy(new SouthFacingStrategy());

        var cmd = new TurnRightCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.WEST, rover.getFacingDirection());
    }

    @Test
    void rover_shouldBeFacingEast_whenTurnLeft_afterFacingSouth() {
        rover.setFacingStrategy(new SouthFacingStrategy());

        var cmd = new TurnLeftCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.EAST, rover.getFacingDirection());
    }

    @Test
    void rover_shouldBeFacingNorth_whenTurnRight_afterFacingWest() {
        rover.setFacingStrategy(new WestFacingStrategy());

        var cmd = new TurnRightCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.NORTH, rover.getFacingDirection());
    }

    @Test
    void rover_shouldBeFacingSouth_whenTurnLeft_afterFacingWest() {
        rover.setFacingStrategy(new WestFacingStrategy());

        var cmd = new TurnLeftCommand(rover);
        rover.takeCommand(cmd);
        assertEquals(Facing.SOUTH, rover.getFacingDirection());
    }
}