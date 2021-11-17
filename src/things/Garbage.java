package things;

import utilities.ThingInterface;

public abstract class Garbage implements ThingInterface {
    public void hoverOverFloor() {
        System.out.println(this.getName() + " летает над объектом \"" + new Floor() + "\".");
    }

    public void soar(Wind wind) {
        System.out.println(this.getName() + " поднимается.");
        wind.addGarbage(this);
    }

    public abstract String getName();
}
