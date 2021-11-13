package things;

public class Dust extends Garbage {
    private static final String name = "Пыль";

    public static void getIntoNose(StoryCharacter victim) {
        System.out.println("Персонажу \"" + victim.getName() + "\" в нос забивается пыль.");
        victim.sneeze();
    }

    @Override
    public String getName() {
        return name;
    }
}
