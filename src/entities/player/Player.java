package entities.player;

import observer.Event;
import observer.EventListener;
import entities.Entity;

public class Player extends Entity implements EventListener {

    public Player(float x, float y, float width, float height) {
        super(x, y, 1f, width, height, PlayerConstants.ATLAS, PlayerConstants.xDrawOffset, PlayerConstants.yDrawOffset);
        load();
    }

    @Override
    public void update(Event eventType) {
        //for movement event
        for(PlayerEvents event : PlayerEvents.values())
            if(event.name() == eventType.name()) {
                movements.put(event.getKey(), event.getValue());
                setAction(event.getAction());
            }

        //for other events...
    }
}
