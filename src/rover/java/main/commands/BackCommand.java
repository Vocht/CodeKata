package rover.java.main.commands;

import rover.java.main.enums.Motion;
import rover.java.main.Rover;

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
