package com.eljhoset.sharedkernel;

public abstract class Entity<T extends DomainObject> extends IndentifiableObject<T> {

    public Entity(T id) {
        super(id);
    }

}
