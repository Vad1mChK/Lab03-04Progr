package things;

public class Stamp extends Garbage {
    private static final String name = "Марка";

    @Override
    public String getName() {
        return name;
    }

    public void fallBefore(Floor floor, StoryCharacter ch, Wind wind) {
        hoverOverFloor();
        System.out.println(name + " падает к ногам персонажа \"" + ch.getName() + "\".");
        ch.hold(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj instanceof Stamp;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }
}
