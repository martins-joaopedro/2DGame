package entities.player;

import observer.Event;
import observer.EventListener;
import entities.Entity;

public class Player extends Entity implements EventListener {

    public Player(float x, float y, float width, float height) {
        super(x, y, 1f, width, height, "dodo.png");
        load();
        //initHitbox(x, y, 42*Game.SCALE, 48*Game.SCALE);
    }

    @Override
    public void update(Event eventType) {
        //for movement event
        for(PlayerEvents event : PlayerEvents.values())
            if(event.name() == eventType.name()) {
                movements.put(event.getKey(), event.getValue());
                if(!event.getAction().isEmpty()) {
                    setAction(event.getActionValue());
                }
            }

        //for other events...
    }
}
