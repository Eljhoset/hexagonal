package com.eljhoset.sharedkernel;

import java.time.LocalTime;

public abstract class DomainEvent implements DomainObject {

    private final LocalTime time;

    public DomainEvent() {
        this.time = LocalTime.now();
    }

    public LocalTime getTime() {
        return time;
    }

}
