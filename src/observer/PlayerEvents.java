package observer;

public enum PlayerEvents {
    PRESS_UP("UP", true),
    PRESS_DOWN("DOWN", true), 
    PRESS_LEFT("LEFT", true), 
    PRESS_RIGHT("RIGHT", true),
    RELEASE_UP("UP", false), 
    RELEASE_DOWN("DOWN", false), 
    RELEASE_LEFT("LEFT", false), 
    RELEASE_RIGHT("RIGHT", false); 

    private String event;
    private boolean value;

    PlayerEvents(String event, boolean value) {
        this.event = event;
        this.value = value;
    }

    public String getEvent() {
        return event;
    }

    public boolean getValue() {
        return this.value;
    }
}
