package com.eljhoset.employee.domain.valueobject;

import com.eljhoset.sharedkernel.ValueObject;
import java.util.Objects;

public class EmployeeId implements ValueObject {

    private final Long id;

    public static EmployeeId of(Long id) {
        return new EmployeeId(id);
    }

    private EmployeeId(Long id) {
        Objects.requireNonNull(id, "id can not be null");
        if (id <= 0) {
            throw new IllegalArgumentException("id must be positive");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final EmployeeId other = (EmployeeId) obj;
        return Objects.equals(this.id, other.getId());
    }

}
