package things;

public class Dust extends Garbage {
    private static final String name = "Пыль";

    public void getIntoNose(StoryCharacter victim) {
        System.out.println("Персонажу \"" + victim.getName() + "\" в нос забивается пыль.");
        victim.sneeze(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        return obj instanceof Dust;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Integer.MAX_VALUE;
    }
}
