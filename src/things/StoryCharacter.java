package things;

import run.Story;
import utilities.Action;
import utilities.StoryCharacterBaseInterface;
import utilities.StoryCharacterHeldInterface;

import java.util.LinkedList;

public class StoryCharacter implements StoryCharacterBaseInterface, StoryCharacterHeldInterface {
    private final String name;
    private LinkedList<Object> held;
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

    public LinkedList<Object> getHeld() {
        return held;
    }

    public void addHeld(Object obj) {
        held.add(obj);
    }

    public void hold(Object obj) {
        if (held == null) held = new LinkedList<Object>();
        addHeld(obj);
        System.out.println(name + " берёт в руки объект \"" + obj + "\".");
        if (!getHappy()) setHappy();
    }

    public void removeHeld(Object obj) {
        held.remove(obj);
    }

    public void release(Object obj) {
        held.remove(obj);
        System.out.println(name + " кладёт объект \"" + obj + "\".");
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
        if (!floor.getDusts().isEmpty()) {
            for (Dust dust : floor.getDusts()) {
                dust.soar(sneezeWind);
                floor.getRoom().addDust(dust);
            }
        }
    }


    public void putIntoAlbum(Stamp stamp, Album album) {
        hold(album);
        try {
            album.addStamp(stamp);
            System.out.println(name + " вклеивает марку \"" + stamp.getName() + "\" в альбом \"" + album.getName() + "\".");
            removeHeld(stamp);
        } catch (Album.AlbumFullException e) {
            System.out.println(name + " не может вклеить марку \"" + stamp.getName() + "\" в альбом \"" + album.getName() + "\": альбом полон.");
        }
        admire(stamp, album);
        release(album);
    }

    private void admire(Stamp stamp, Album album) {
        System.out.println(name + " любуется маркой \"" + stamp.getName() + "\" в альбоме \"" + album.getName() + "\".");
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
