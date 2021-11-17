package things;

import utilities.ThingInterface;

public abstract class Garbage implements ThingInterface {
    public static final String name = "Мусор";

    public void hoverOverFloor() {
        System.out.println(this.getName() + " летает над объектом \"" + new Floor() + "\".");
    }

    public void soar(Wind wind) {
        System.out.println(this.getName() + " поднимается.");
        wind.addGarbage(this);
    }

    public abstract String getName();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj instanceof Garbage;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return name;
    }
}
