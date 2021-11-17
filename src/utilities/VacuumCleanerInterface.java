package utilities;

import things.Floor;

public interface VacuumCleanerInterface extends ThingInterface {
    void placeOn(Floor floor);

    void setFallenOnto(boolean isFallenOnto);

    void setHandleGrabbed(boolean isHandleGrabbed);

    void setOpen(boolean isOpen);

    void unleash();
}