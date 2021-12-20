package things;

import java.util.LinkedList;
import java.util.List;

public class Room extends Location {
    public Room(String name, StoryCharacter...locationPeople) {
        setName(name);
        setLocationPeople(new LinkedList<StoryCharacter>(List.of(locationPeople)));
    }

    public Room(Room sameRoom) {
        setName(sameRoom.getName());
        setLocationPeople(sameRoom.getLocationPeople());
    }

    @Override
    public int hashCode() {
        return super.hashCode()+Integer.MAX_VALUE/2;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Комната";
    }
}
