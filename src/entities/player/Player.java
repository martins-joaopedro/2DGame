package entities.player;

import observer.Event;
import observer.EventListener;
import levels.LevelManager;

import static utils.Constants.PlayerConstants.*;

import entities.Entity;

public class Player extends Entity implements EventListener {

    private int playerAction = LEFT_WALKING;
    
    public Player(float x, float y, float width, float height, LevelManager lm) {
        super(x, y, 1f, width, height, lm, "dodo.png");
        load();
        //initHitbox(x, y, 42*Game.SCALE, 48*Game.SCALE);
    }

    @Override
    public void update(Event eventType) {
        //for movement event
        for(PlayerEvents event : PlayerEvents.values())
            if(event.name() == eventType.name())
                movements.put(event.getKey(), event.getValue());

        //for other events...
    }
}
