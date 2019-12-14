package com.eljhoset.employee.domain.event;

import com.eljhoset.sharedkernel.DomainEvent;

public class EmployeeNameChanged extends DomainEvent {

    private final Long id;
    private final String newFirstName;
    private final String newLastName;

    public static EmployeeNameChanged of(final Long id, final String newFirstName, final String newLastName) {
        return new EmployeeNameChanged(id, newFirstName, newLastName);
    }

    public EmployeeNameChanged(Long id, String newFirstName, String newLastName) {
        this.id = id;
        this.newFirstName = newFirstName;
        this.newLastName = newLastName;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public Long getId() {
        return id;
    }

}
