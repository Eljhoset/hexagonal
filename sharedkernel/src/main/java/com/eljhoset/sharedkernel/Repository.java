package com.eljhoset.sharedkernel;

import java.util.Optional;

public interface Repository<T extends IndentifiableObject, ID> {

    T save(T entity);

    Optional<T> findById(ID id);
}
