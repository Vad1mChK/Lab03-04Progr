package things;

import utilities.ThingInterface;

public class Wind implements ThingInterface {
    public static final String name = "Ветер";

    public static void blow(StoryCharacter ch) {
        System.out.println("Объект \"" + name + "\" дует в открытое окно.");
        new Dust().soar();
        Dust.getIntoNose(ch);
    }

    @Override
    public String getName() {
        return name;
    }
}
