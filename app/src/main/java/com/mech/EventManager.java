package com.mech;


import de.greenrobot.event.EventBus;

/**
 * Created by Agustin on 16/7/2017.
 */

public class EventManager {

    private EventBus eventBus = EventBus.getDefault();

    public void post(Event event) {
        eventBus.post(event);
    }

    public void postSticky(Event event) {
        eventBus.postSticky(event);
    }

    public Event getSticky(Event event) {
        return eventBus.getStickyEvent(event.getClass());
    }

    public void register(Subscriber subscriber) {
        if (!eventBus.isRegistered(subscriber)) {
            eventBus.register(subscriber);
        }
    }

    public void unregister(Subscriber subscriber) {
        if (eventBus.isRegistered(subscriber)) {
            eventBus.unregister(subscriber);
        }
    }
}
