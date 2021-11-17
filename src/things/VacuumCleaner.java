package things;

import utilities.VacuumCleanerInterface;

import java.util.Arrays;
import java.util.LinkedList;

public class VacuumCleaner implements VacuumCleanerInterface {
    private final String name;
    private final boolean isOpen;
    private Floor floor;
    private final LinkedList<Garbage> garbageList = new LinkedList<>();

    public VacuumCleaner(Garbage... garbage) {
        name = "Пылесос";
        garbageList.addAll(Arrays.asList(garbage));
        isOpen = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void placeOn(Floor floor) {
        this.floor = floor;
    }

    @Override
    public void unleash() {
        System.out.println("Содержимое пылесоса высыпано на объект \"" + floor + "\".");
        for (Garbage g : garbageList) {
            floor.addGarbage(g);
        }
        garbageList.clear();
    }

    public String toString() {
        return "\"" + this.name + "\"";
    }

    public void printGarbage() {
        LinkedList<String> stringList = new LinkedList<>();
        for (Garbage g : garbageList) {
            stringList.add(g.toString());
        }
        System.out.println("// Содержимое объекта " + this + ": " + String.join(", ", stringList));
    }
}
