package things;

import utilities.VacuumCleanerInterface;

public class VacuumCleaner implements VacuumCleanerInterface {
    private final String name;
    private final boolean isOpen;

    public VacuumCleaner() {
        name = "Пылесос";
        isOpen = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void unleash() {
        System.out.println("Содержимое пылесоса высыпано на объект \"" + new Floor() + "\".");
    }

    public String toString() {
        return "\"" + this.name + "\"";
    }
}
