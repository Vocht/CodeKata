package rover.java.main.strategy;

import rover.java.main.enums.Facing;
import rover.java.main.Coordinate;

public class WestFacingStrategy implements FacingStrategy {
    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() - 1, coordinate.getY());
    }

    @Override
    public Coordinate moveBack(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() + 1, coordinate.getY());
    }

    @Override
    public FacingStrategy getNextStrategy() {
        return new NorthFacingStrategy();
    }

    @Override
    public FacingStrategy getPreviousStrategy() {
        return new SouthFacingStrategy();
    }

    @Override
    public Facing getFacingDirection() {
        return Facing.WEST;
    }
}
