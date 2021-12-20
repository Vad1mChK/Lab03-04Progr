package things;

import run.Story;
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

    public void setHeld(Object held) {
        this.held = held;
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
                    vc.setFallenOnto(true);
                    break;
                }
                case GRAB: {
                    System.out.println(name + " нажимает на ручку объекта " + vc + ".");
                    vc.setHandleGrabbed(true);
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
    public void sneeze(Dust dust) {
        Wind sneezeWind = new Wind();
        System.out.println(name + " чихает.");
        dust.soar(sneezeWind);
    }

    public void sneeze(Floor floor) {
        Wind sneezeWind = new Wind();
        System.out.println(name + " чихает.");
        for (Dust dust : floor.getDusts()) {
            dust.soar(sneezeWind);
        }
    }

    public void hold(Object object) {
        setHeld(object);
        System.out.println(name + " берёт в руки объект \"" + held + "\".");
        this.setHappy();
    }

    public void remember(Story story) {
        System.out.println(name + " вспоминает:");
        story.playStory();
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
        int result = name.hashCode();
        result = 2 * result + held.hashCode();
        result += isHappy ? Integer.MAX_VALUE : 0;
        return result;
    }

    @Override
    public String toString() {
        return "Персонаж по имени " + name;
    }
}
