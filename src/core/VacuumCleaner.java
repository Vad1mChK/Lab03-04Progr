package core;

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
}
