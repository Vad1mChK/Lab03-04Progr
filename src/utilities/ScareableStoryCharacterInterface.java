package utilities;

import things.Location;
import things.Roof;
import things.StoryCharacter;

public interface ScareableStoryCharacterInterface extends StoryCharacterBaseInterface {
    default void check(Location desiredLocation, Location undesiredLocation, StoryCharacter character) {
        System.out.println(getName() + " проверяет, есть ли персонаж \"" + character.getName() + "\" в локации \"" + desiredLocation.getName() + "\".");
        try {
            if (!desiredLocation.searchForCharacterWithMessage(character)) throw new ScaredException();
        } catch (ScaredException e) {
            scare();
            if (undesiredLocation.searchForCharacterWithMessage(character) && undesiredLocation instanceof Roof)
                call911();
        }
    }

    default void scare() {
        System.out.println(getName() + " пугается.");
    }

    default void call911() {
        System.out.println(getName() + " вызывает пожарников.");
    }
}
