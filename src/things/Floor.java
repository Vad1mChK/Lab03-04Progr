package things;

import utilities.ThingInterface;

public class Floor implements ThingInterface {
    public static final String name = "Пол";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
