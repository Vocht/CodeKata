package rover.java.commands;

import rover.java.enums.Motion;
import rover.java.Rover;

public class ForwardCommand implements Command {
    private final Rover rover;

    public ForwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void exec() {
        rover.move(Motion.FORWARD);
    }
}
