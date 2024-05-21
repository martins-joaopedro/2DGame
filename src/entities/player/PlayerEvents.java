package entities.player;

public enum PlayerEvents {
    PRESS_UP("UP", true),
    PRESS_DOWN("DOWN", true), 
    PRESS_LEFT("LEFT", true), 
    PRESS_RIGHT("RIGHT", true),
    RELEASE_UP("UP", false), 
    RELEASE_DOWN("DOWN", false), 
    RELEASE_LEFT("LEFT", false), 
    RELEASE_RIGHT("RIGHT", false); 

    private String key;
    private boolean value;

    PlayerEvents(String key, boolean value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public boolean getValue() {
        return this.value;
    }
}
