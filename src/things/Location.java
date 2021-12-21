package things;

import utilities.ThingInterface;
import utilities.TransferUnavailableException;

import java.util.LinkedList;

public abstract class Location implements ThingInterface {
    private String name;
    private LinkedList<StoryCharacter> locationPeople;

    public LinkedList<StoryCharacter> getLocationPeople() {
        return locationPeople;
    }

    public void setLocationPeople(LinkedList<StoryCharacter> locationPeople) {
        this.locationPeople = locationPeople;
    }

    public void addLocationPerson(StoryCharacter character) {
        locationPeople.add(character);
    }

    public void removeLocationPerson(StoryCharacter character) {
        locationPeople.remove(character);
    }

    public boolean searchForCharacter(StoryCharacter character) {
        for (StoryCharacter object : locationPeople) {
            if (character == object) {
                return true;
            }
        }
        return false;
    }

    public boolean searchForCharacterWithMessage(StoryCharacter character) {
        if (searchForCharacter(character))
            System.out.println("Персонаж \"" + character.getName() + "\" обнаружен в локации \"" + getName() + "\".");
        else
            System.out.println("Персонаж \"" + character.getName() + "\" не обнаружен в локации \"" + getName() + "\".");
        return searchForCharacter(character);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void clear() {
        locationPeople = new LinkedList<StoryCharacter>();
    }

    private void assertNoMatches(Location destination, LinkedList<StoryCharacter> peopleToAssert) throws TransferUnavailableException {
        for (StoryCharacter character : peopleToAssert) {
            if (destination.searchForCharacter(character)) {
                throw new TransferUnavailableException();
            }
        }
    }

    public void transfer(Location destination, LinkedList<StoryCharacter> peopleToTransfer) {
        try {
            assertNoMatches(destination, peopleToTransfer);
            for (StoryCharacter character : new LinkedList<>(peopleToTransfer)) {
                destination.addLocationPerson(character);
                removeLocationPerson(character);
                System.out.println("Персонаж \"" + character.getName() + "\" перемещается из локации \"" + this.getName() + "\" в локацию \"" + destination.getName() + "\".");
            }

        } catch (TransferUnavailableException e) {
            System.out.println("Невозможно переместить персонажей в локацию \"" + destination.getName() + "\"");
        }
    }

    @Override
    public int hashCode() {
        int code = Integer.MAX_VALUE;
        for (StoryCharacter character : locationPeople) {
            code += character.hashCode();
        }
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return locationPeople.equals(room.getLocationPeople());
    }

    @Override
    public String toString() {
        return "Локация";
    }
}
