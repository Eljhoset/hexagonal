package com.eljhoset.sharedkernel;

import java.util.Collection;

public interface EventDispatcher {

    void dispatch(DomainEvent event);

    default void dispatch(Collection<DomainEvent> events) {
        events.forEach(event -> dispatch(event));
    }
}
