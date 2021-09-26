package rover.java.main.strategy;

import rover.java.main.enums.Facing;
import rover.java.main.Coordinate;

public class SouthFacingStrategy implements FacingStrategy {
    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return new Coordinate(coordinate.getX(), coordinate.getY() - 1);
    }

    @Override
    public Coordinate moveBack(Coordinate coordinate) {
        return new Coordinate(coordinate.getX(), coordinate.getY() + 1);
    }

    @Override
    public FacingStrategy getNextStrategy() {
        return new WestFacingStrategy();
    }

    @Override
    public FacingStrategy getPreviousStrategy() {
        return new EastFacingStrategy();
    }

    @Override
    public Facing getFacingDirection() {
        return Facing.SOUTH;
    }
}
