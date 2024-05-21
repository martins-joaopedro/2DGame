package entities.player;

public enum PlayerEvents {
    PRESS_UP("UP", true, PlayerConstants.UP_WALKING),
    PRESS_DOWN("DOWN", true, PlayerConstants.DOWN_WALKING), 
    PRESS_LEFT("LEFT", true, PlayerConstants.LEFT_WALKING), 
    PRESS_RIGHT("RIGHT", true, PlayerConstants.RIGHT_WALKING),
    RELEASE_UP("UP", false, PlayerConstants.DOWN_WALKING), 
    RELEASE_DOWN("DOWN", false, PlayerConstants.DOWN_WALKING), 
    RELEASE_LEFT("LEFT", false, PlayerConstants.DOWN_WALKING), 
    RELEASE_RIGHT("RIGHT", false, PlayerConstants.DOWN_WALKING); 

    private String key;
    private boolean value;
    private int action;

    PlayerEvents(String key, boolean value, int action) {
        this.key = key;
        this.value = value;
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public boolean getValue() {
        return this.value;
    }

    public int getAction() {
        return action;
    }
}
