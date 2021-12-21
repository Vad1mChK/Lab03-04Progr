package things;

public class Stamp extends Garbage {
    private String name = "Марка";

    public Stamp(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void fallBefore(Floor floor, StoryCharacter character, Wind wind) {
        hoverOverFloor(floor);
        System.out.println(name + " падает к ногам персонажа \"" + character.getName() + "\".");
        character.hold(this);
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
