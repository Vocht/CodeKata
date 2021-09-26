package rover.java.main.commands;

import rover.java.main.enums.Motion;
import rover.java.main.Rover;

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
