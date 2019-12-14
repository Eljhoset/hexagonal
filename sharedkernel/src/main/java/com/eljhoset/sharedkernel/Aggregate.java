package com.eljhoset.sharedkernel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Aggregate<T extends DomainObject> extends Entity<T> {

    private final Collection<DomainEvent> events;

    public Aggregate(T id) {
        super(id);
        events = new ArrayList<>();
    }

    public void addEvent(DomainEvent event) {
        events.add(event);
    }

    public Collection<DomainEvent> getEvents() {
        return Collections.unmodifiableCollection(events);
    }

}
