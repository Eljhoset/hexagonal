package com.eljhoset.sharedkernel;

public abstract class LocalEntity<T extends DomainObject> extends Entity<T> {

    public LocalEntity(T id) {
        super(id);
    }

}
