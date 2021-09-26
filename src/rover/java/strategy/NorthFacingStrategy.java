package rover.java.strategy;

import rover.java.Coordinate;
import rover.java.enums.Facing;

public class NorthFacingStrategy implements FacingStrategy {
    @Override
    public Coordinate moveBack(Coordinate coordinate) {
        return new Coordinate(coordinate.getX(), coordinate.getY() - 1);
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return new Coordinate(coordinate.getX(), coordinate.getY() + 1);
    }

    @Override
    public FacingStrategy getNextStrategy() {
        return new EastFacingStrategy();
    }

    @Override
    public FacingStrategy getPreviousStrategy() {
        return new WestFacingStrategy();
    }

    @Override
    public Facing getFacingDirection() {
        return Facing.NORTH;
    }
}
