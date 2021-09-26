package rover.java.commands;

import rover.java.enums.Direction;
import rover.java.Rover;

public class TurnRightCommand implements Command {
    private final Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void exec() {
        rover.turn(Direction.RIGHT);
    }
}
