package things;

import utilities.ThingInterface;

import java.util.LinkedList;

public class Floor implements ThingInterface {
    public static final String name = "Пол";
    private final LinkedList<Garbage> garbageList = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void addGarbage(Garbage g) {
        garbageList.add(g);
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
    public String toString() {
        return getName();
    }

    public void printGarbage() {
        LinkedList<String> stringList = new LinkedList<>();
        for (Garbage g : garbageList) {
            stringList.add(g.toString());
        }
        System.out.println("// Содержимое объекта " + this + ": " + String.join(", ", stringList));
    }
}
