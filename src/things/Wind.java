package things;

import utilities.ThingInterface;

import java.util.Arrays;
import java.util.LinkedList;

public class Wind implements ThingInterface {
    public static final String name = "Ветер";
    private final LinkedList<Garbage> garbageList = new LinkedList<>();

    public void addGarbage(Garbage... garbage) {
        garbageList.addAll(Arrays.asList(garbage));
    }

    public void blowDust(Floor floor, StoryCharacter ch) {
        for (Garbage g : garbageList) {
            if (g instanceof Dust) {
                ((Dust) g).getIntoNose(ch);
                landOn(floor, g);
            }
        }
    }

    public void blowStamp(Floor floor, StoryCharacter ch) {
        for (Garbage g : garbageList) {
            if (g instanceof Stamp) {
                ((Stamp) g).fallBefore(floor, ch, this);
            }
        }
    }

    public void blow(Floor floor, StoryCharacter ch1, StoryCharacter ch2) {
        System.out.println("Объект \"" + name + "\" дует в открытое окно.");
        floor.liftGarbage(this);
        blowDust(floor, ch1);
        blowStamp(floor, ch2);
    }

    public void printGarbage() {
        LinkedList<String> stringList = new LinkedList<>();
        for (Garbage g : garbageList) {
            stringList.add(g.toString());
        }
        System.out.println("// Содержимое объекта " + this + ": " + String.join(", ", stringList));
    }

    public void landOn(Floor floor, Garbage... garbage) {
        for (Garbage g : garbage) {
            floor.addGarbage(g);
            garbageList.remove(g);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
