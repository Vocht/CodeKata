package rover.java.strategy;

import rover.java.Coordinate;
import rover.java.enums.Facing;

public class EastFacingStrategy implements FacingStrategy {
    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() + 1, coordinate.getY());
    }

    @Override
    public Coordinate moveBack(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() - 1, coordinate.getY());
    }

    @Override
    public FacingStrategy getNextStrategy() {
        return new SouthFacingStrategy();
    }

    @Override
    public FacingStrategy getPreviousStrategy() {
        return new NorthFacingStrategy();
    }

    @Override
    public Facing getFacingDirection() {
        return Facing.EAST;
    }
}
