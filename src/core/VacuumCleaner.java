package core;

import java.util.Objects;

public class VacuumCleaner {
    boolean isPressed;
    boolean isHandleGrabbed;
    boolean isOpen;
    Dust dust;
    Stamp stamp;
    public VacuumCleaner () {
        this.isPressed = false;
        this.isHandleGrabbed = false;
        this.isOpen = false;
        this.dust = new Dust();
    }
    protected void setPressed (boolean isPressed){
        this.isPressed = isPressed;
    }
    protected void setHandleGrabbed (boolean isHandleGrabbed) {
        this.isHandleGrabbed = isHandleGrabbed;
    }
    protected void setOpen (boolean isOpen){
        this.isOpen = isOpen;
        if (isOpen) {
            dust.unleash();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return isPressed == that.isPressed && isHandleGrabbed == that.isHandleGrabbed && isOpen == that.isOpen && Objects.equals(dust, that.dust) && Objects.equals(stamp, that.stamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPressed, isHandleGrabbed, isOpen, dust, stamp);
    }

    @Override
    public String toString() {
        return "Пылесос";
    }
}
