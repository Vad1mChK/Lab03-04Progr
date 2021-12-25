package things;

import java.util.Arrays;
import java.util.LinkedList;

public class Room extends Location {
    private boolean isDusted;
    private final LinkedList<Dust> dustList = new LinkedList<>();

    {
        isDusted = false;
    }

    public Room(String name, StoryCharacter... locationPeople) {
        setName(name);
        setLocationPeople(new LinkedList<StoryCharacter>(Arrays.asList(locationPeople)));
    }

    public Room(Room sameRoom) {
        setName(sameRoom.getName());
        setLocationPeople(sameRoom.getLocationPeople());
        for (Dust dust: sameRoom.getDustList()){
            addDust(dust);
        }
    }

    public LinkedList<Dust> getDustList() {
        return dustList;
    }

    public void addDust(Dust dust) {
        dustList.add(dust);
        setDusted(true);
    }

    public boolean getDusted() {
        return isDusted;
    }

    public void setDusted(boolean isDusted) {
        if (this.isDusted != isDusted) {
            if (isDusted) System.out.println(this + " \"" + getName() + "\" теперь покрыта пылью.");
            else System.out.println(this + " \"" + getName() + "\" теперь очищена от пыли.");
            this.isDusted = isDusted;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Integer.MAX_VALUE / 2;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Комната "+getName();
    }
}
