package com.eljhoset.sharedkernel;

import java.util.Objects;

public abstract class IndentifiableObject<T> {

    private final T id;

    public IndentifiableObject(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IndentifiableObject<?> other = (IndentifiableObject<?>) obj;
        return Objects.equals(this.id, other.getId());
    }

}
