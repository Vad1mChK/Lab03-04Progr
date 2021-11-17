package things;

import utilities.VacuumCleanerInterface;

import java.util.Arrays;
import java.util.LinkedList;

public class VacuumCleaner implements VacuumCleanerInterface {
    private final String name;
    private boolean isFallenOnto;
    private boolean isHandleGrabbed;
    private boolean isOpen;
    private Floor floor;
    private final LinkedList<Garbage> garbageList = new LinkedList<>();

    public VacuumCleaner(Garbage... garbage) {
        name = "Пылесос";
        garbageList.addAll(Arrays.asList(garbage));
        isHandleGrabbed = false;
        isFallenOnto = false;
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
    public void setFallenOnto(boolean isFallenOnto) {
        this.isFallenOnto = isFallenOnto;
    }

    @Override
    public void setHandleGrabbed(boolean isHandleGrabbed) {
        this.isHandleGrabbed = isHandleGrabbed;
    }

    @Override
    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public void unleash() {
        setOpen(true);
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
        return isOpen == that.isOpen && isFallenOnto==that.isFallenOnto && isHandleGrabbed == that.isHandleGrabbed &&
                name.equals(that.name) && floor.equals(that.floor) && garbageList.equals(that.garbageList);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 2*result + floor.hashCode();
        result = 2*result + garbageList.hashCode();
        if (isFallenOnto) result += Integer.MAX_VALUE;
        if (isHandleGrabbed) result += Integer.MAX_VALUE / 2;
        if (isOpen) result += Integer.MAX_VALUE / 4;
        return result;
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\"";
    }
}
