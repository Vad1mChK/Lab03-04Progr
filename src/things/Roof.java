package things;

import java.util.LinkedList;

public class Roof extends Location {
    public Roof(String name) {
        setName(name);
        setLocationPeople(new LinkedList<StoryCharacter>());
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Integer.MIN_VALUE / 2;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Крыша";
    }
}
