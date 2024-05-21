package entities.player;

public enum PlayerEvents {
    PRESS_UP("UP", true, "TURN_BACKWARD", 0),
    PRESS_DOWN("DOWN", true, "TURN_FORWARD", 2), 
    PRESS_LEFT("LEFT", true, "TURN_LEFT", 3), 
    PRESS_RIGHT("RIGHT", true, "TURN_RIGHT", 1),
    RELEASE_UP("UP", false, "TURN_FORWARD", 1), 
    RELEASE_DOWN("DOWN", false, "TURN_FORWARD", 2), 
    RELEASE_LEFT("LEFT", false, "TURN_FORWARD", 2), 
    RELEASE_RIGHT("RIGHT", false, "TURN_FORWARD", 2); 

    private String key;
    private boolean value;
    private String action;
    private int actionValue;

    PlayerEvents(String key, boolean value, String action, int actionValue) {
        this.key = key;
        this.value = value;
        this.action = action;
        this.actionValue = actionValue;
    }

    public String getKey() {
        return key;
    }

    public boolean getValue() {
        return this.value;
    }

    public String getAction() {
        return action;
    }
    
    public int getActionValue() {
        return actionValue;
    }
}
