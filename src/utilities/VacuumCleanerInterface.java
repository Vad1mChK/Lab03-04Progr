package utilities;

import things.Floor;

public interface VacuumCleanerInterface extends ThingInterface {
    void unleash();

    void placeOn(Floor floor);
}