package things;

import utilities.Action;
import utilities.StoryCharacterInterface;

public class StoryCharacter implements StoryCharacterInterface {
    private final String name;
    private Object held;
    private boolean isHappy;

    public StoryCharacter(String name) {
        this.name = name;
        this.held = null;
        this.isHappy = false;
    }

    public String getName() {
        return name;
    }

    public boolean getHappy() {
        return isHappy;
    }

    public Object getHeld() {
        return held;
    }

    public void setHappy() {
        System.out.println(name + " становится счастливым.");
        this.isHappy = true;
    }

    @Override
    public void wonder(StoryCharacter other) {
        System.out.println(name + " удивляется, что " + other.getName() + ", как маленький, играет в такие детские игры, но смотреть на это все же забавно.");
    }


    @Override
    public void interactWith(VacuumCleaner vc, Action... ACTIONS) {
        for (Action ACTION : ACTIONS) {
            switch (ACTION) {
                case FALL: {
                    System.out.println(name + " падает на объект " + vc + ".");
                    break;
                }
                case GRAB: {
                    System.out.println(name + " нажимает на ручку объекта " + vc + ".");
                    break;
                }
                default: {
                    System.out.println(name + " открывает объект " + vc + ".");
                    vc.unleash();
                    break;
                }
            }
        }
    }

    @Override
    public void sneeze() {
        System.out.println(name + " чихает.");
        new Dust().soar();
    }

    public void hold(Object object) {
        held = object;
        System.out.println(name + " берёт в руки объект \"" + held + "\".");
        this.setHappy();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof StoryCharacter) {
            return this.name.equals(((StoryCharacter) obj).getName())
                    && this.held.equals(((StoryCharacter) obj).getHeld())
                    && this.isHappy == ((StoryCharacter) obj).getHappy();
        } else return false;
    }

    @Override
    public int hashCode() {
        if (isHappy) {
            return name.hashCode() + held.hashCode() + name.length();
        } else {
            return name.hashCode() + held.hashCode();
        }
    }

    @Override
    public String toString() {
        return "Персонаж по имени " + name;
    }
}
