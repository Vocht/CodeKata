package rover.java.main.commands;

import rover.java.main.enums.Direction;
import rover.java.main.Rover;

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
