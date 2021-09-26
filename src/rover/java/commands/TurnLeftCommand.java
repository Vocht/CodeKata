package rover.java.commands;

import rover.java.enums.Direction;
import rover.java.Rover;

public class TurnLeftCommand implements Command {
    private final Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void exec() {
        rover.turn(Direction.LEFT);
    }
}
