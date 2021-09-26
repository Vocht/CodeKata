package rover.java.strategy;

import rover.java.Coordinate;
import rover.java.enums.Facing;

public interface FacingStrategy {
    Coordinate moveForward(Coordinate coordinate);

    Coordinate moveBack(Coordinate coordinate);

    FacingStrategy getNextStrategy();

    FacingStrategy getPreviousStrategy();

    Facing getFacingDirection();
}
