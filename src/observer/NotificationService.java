package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
    
    private final Map<Event, List<EventListener>> costumers;

    public NotificationService() {
        this.costumers = new HashMap<>();
        for(Event evenType : Event.values())
            this.costumers.put(evenType, new ArrayList<>());
    }

    public void subscribe(Event eventType, EventListener listener) {
        this.costumers.get(eventType).add(listener);
    }

    public void unSubscribe(Event eventType, EventListener listener) {
        this.costumers.get(eventType).remove(listener);
    }

    public void notify(Event eventType) {
        this.costumers.get(eventType).forEach(listener -> listener.update(eventType));
    }
    
}
