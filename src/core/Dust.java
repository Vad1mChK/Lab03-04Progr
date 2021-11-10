package core;

public class Dust {
    private boolean isContained;
    public Dust() {
    }
    protected void unleash () {
        this.isContained = false;
    }
    protected void landOn (Floor f) {
        f.setDust(true);
    }
}
