package utilities;

import things.Dust;
import things.StoryCharacter;
import things.VacuumCleaner;

public interface StoryCharacterInterface extends ThingInterface {
    void wonder(StoryCharacter other);

    void interactWith(VacuumCleaner vc, Action... ACTIONS);

    void sneeze(Dust dust);

    void hold(Object obj);
}
