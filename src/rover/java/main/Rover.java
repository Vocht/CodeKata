package rover.java.main;

import rover.java.main.enums.Facing;
import rover.java.main.commands.Command;
import rover.java.main.enums.Direction;
import rover.java.main.enums.Motion;
import rover.java.main.strategy.FacingStrategy;

public class Rover {
    private Coordinate coordinate;
    private FacingStrategy facingStrategy;

    public Rover(Coordinate coordinate, FacingStrategy facingStrategy) {
        this.coordinate = coordinate;
        this.facingStrategy = facingStrategy;
    }

    public void setFacingStrategy(FacingStrategy facingStrategy) {
        this.facingStrategy = facingStrategy;
    }

    public Coordinate getPosition() {
        return coordinate;
    }

    public void takeCommand(Command cmd) {
        cmd.exec();
    }

    public void move(Motion motion) {
        switch (motion) {
            case FORWARD -> this.coordinate = facingStrategy.moveForward(coordinate);
            case BACK -> this.coordinate = facingStrategy.moveBack(coordinate);
        }
    }

    public void turn(Direction direction) {
        switch (direction) {
            case RIGHT -> this.facingStrategy = this.facingStrategy.getNextStrategy();
            case LEFT -> this.facingStrategy = this.facingStrategy.getPreviousStrategy();
        }
    }

    public Facing getFacingDirection() {
        return facingStrategy.getFacingDirection();
    }
}
