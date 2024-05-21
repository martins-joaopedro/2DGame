package entities;

import observer.Event;
import observer.EventListener;
import observer.PlayerEvents;
import levels.LevelManager;

import static utils.Constants.PlayerConstants.*;

public class Player extends Entity implements EventListener {

    private int playerAction = LEFT_WALKING;
    
    public Player(float x, float y, float width, float height, LevelManager lm) {
        super(x, y, 2f, width, height, lm, "dodo.png");
        load();
        //initHitbox(x, y, 42*Game.SCALE, 48*Game.SCALE);
    }

    @Override
    public void update(Event eventType) {
        for(PlayerEvents event : PlayerEvents.values())
            if(event.name() == eventType.name())
                movePlayer(event.getEvent(), event.getValue());
    }
    
    public void movePlayer(String key, boolean value) {
        System.out.println(key);
        switch (key) {
            case "UP":
                setUp(value);
                break;
            case "DOWN":
                setDown(value);
                break;
            case "LEFT":
                setLeft(value);
                break;
            case "RIGHT":
                setRight(value);
                break;
        }
        updatePosition();
    }
}
