package things;

import utilities.GarbageAdditionInterface;
import utilities.ThingInterface;

import java.util.LinkedList;
import java.util.Objects;

public class Floor implements ThingInterface, GarbageAdditionInterface {
    public static final String name = "Пол";
    private final LinkedList<Garbage> garbageList = new LinkedList<>();
    private Room room;

    public Floor(Room room){
        this.room = room;
    }
    public String getName() {
        return name;
    }

    public Room getRoom() {
        return this.room;
    }

    @Override
    public void addGarbage(Garbage garbage) {
        garbageList.add(garbage);
    }

    public void liftGarbage(Wind wind) {
        for (Garbage g : garbageList) {
            g.soar(wind);
        }
        garbageList.clear();
    }

    public LinkedList<Dust> getDusts() {
        LinkedList<Dust> dustList = new LinkedList<>();
        for (Garbage g : garbageList) {
            if (g instanceof Dust) dustList.add((Dust) g);
        }
        return dustList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Floor)) return false;
        return Objects.equals(garbageList, ((Floor) o).garbageList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(garbageList) + name.hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }

}
