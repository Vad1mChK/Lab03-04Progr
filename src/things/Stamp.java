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
    public String toString() {
        return getName();
    }
}
