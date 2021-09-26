package rover.java.main.strategy;

import rover.java.main.enums.Facing;
import rover.java.main.Coordinate;

public interface FacingStrategy {
    Coordinate moveForward(Coordinate coordinate);

    Coordinate moveBack(Coordinate coordinate);

    FacingStrategy getNextStrategy();

    FacingStrategy getPreviousStrategy();

    Facing getFacingDirection();
}
