package utilities;

public interface StoryCharacterHeldInterface extends ThingInterface {
    void addHeld(Object obj);

    void removeHeld(Object obj);

    void hold(Object obj);

    void release(Object obj);
}
