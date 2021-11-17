package utilities;

import things.Floor;

public interface VacuumCleanerInterface extends ThingInterface {
    void placeOn(Floor floor);

    void open();

    void unleash();
}