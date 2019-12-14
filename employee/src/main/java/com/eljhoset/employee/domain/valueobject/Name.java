package com.eljhoset.employee.domain.valueobject;

import com.eljhoset.sharedkernel.ValueObject;
import java.util.Objects;

public class Name implements ValueObject {

    private final String firstname;
    private final String lastname;

    public static Name with(final String firstname, final String lastname) {
        return new Name(firstname, lastname);
    }

    private Name(String firstname, String lastname) {
        Objects.requireNonNull(firstname, "firstname can not be null");
        Objects.requireNonNull(lastname, "lastname can not be null");
        if (firstname.isBlank()) {
            throw new IllegalArgumentException("firstname can not be blank");
        }
        if (lastname.isBlank()) {
            throw new IllegalArgumentException("lastname can not be blank");
        }
        // validate against black list
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String name() {
        return String.format("%s %s", firstname, lastname);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.firstname);
        hash = 79 * hash + Objects.hashCode(this.lastname);
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
        final Name other = (Name) obj;
        if (!Objects.equals(this.firstname, other.getFirstname())) {
            return false;
        }
        return Objects.equals(this.lastname, other.getLastname());
    }

}
