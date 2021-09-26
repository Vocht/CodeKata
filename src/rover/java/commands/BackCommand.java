package rover.java.commands;

import rover.java.enums.Motion;
import rover.java.Rover;

public class BackCommand implements Command {
    private final Rover rover;

    public BackCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void exec() {
        rover.move(Motion.BACK);
    }
}
