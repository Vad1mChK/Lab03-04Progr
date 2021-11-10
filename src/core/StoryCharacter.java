package core;

import util.StoryCharacterInterface;

public class StoryCharacter implements StoryCharacterInterface {
    private final String name;
    private boolean isTrulyHappy;
    private Stamp stamp;

    public StoryCharacter(String name) {
        this.name = name;
    }

    public void sneeze() {
        System.out.println(this + " чихает.");
    }

    public void fallOnto(VacuumCleaner vc) {
        System.out.println(this + " падает на "+vc+".");
        vc.setPressed(true);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Персонаж по имени " + getName();
    }
}
