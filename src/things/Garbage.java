package things;

import utilities.ThingInterface;

public abstract class Garbage implements ThingInterface {
    public void hoverOverFloor() {
        System.out.println(this.getName() + " летает над объектом \"" + new Floor() + "\".");
    }

    public void soar() {
        System.out.println(this.getName() + " поднимается.");
    }

    public abstract String getName();
}
