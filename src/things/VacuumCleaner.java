package things;

import utilities.VacuumCleanerInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class VacuumCleaner implements VacuumCleanerInterface {
    private final String name;
    private boolean isOpen;
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
    public void open() {
        isOpen = true;
    }

    @Override
    public void unleash() {
        open();
        System.out.println("Содержимое пылесоса высыпано на объект \"" + floor + "\".");
        for (Garbage g : garbageList) {
            floor.addGarbage(g);
        }
        garbageList.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return isOpen == that.isOpen && name.equals(that.name) && floor.equals(that.floor) && garbageList.equals(that.garbageList);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 2*result + floor.hashCode();
        result = 2*result + garbageList.hashCode();
        result = 2*result + (isOpen ? Integer.MAX_VALUE : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\"";
    }
}
