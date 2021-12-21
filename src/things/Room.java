package things;

import java.util.LinkedList;
import java.util.List;

public class Room extends Location {
    private boolean isDusted;
    private LinkedList<Dust> dustList = new LinkedList<>();

    {
        isDusted = false;
    }

    public Room(String name, StoryCharacter... locationPeople) {
        setName(name);
        setLocationPeople(new LinkedList<StoryCharacter>(List.of(locationPeople)));
    }

    public Room(Room sameRoom) {
        setName(sameRoom.getName());
        setLocationPeople(sameRoom.getLocationPeople());
        setDusted(sameRoom.getDusted());
    }

    public void addDust(Dust dust){
        dustList.add(dust);
        setDusted(true);
    }

    public LinkedList<Dust> getDustList(){
        return dustList;
    }

    public void setDustList(){
        this.dustList = dustList;
        setDusted(!dustList.isEmpty());
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
        return "Комната";
    }
}
