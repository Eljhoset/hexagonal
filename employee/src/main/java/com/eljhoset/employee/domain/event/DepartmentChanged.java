package com.eljhoset.employee.domain.event;

import com.eljhoset.sharedkernel.DomainEvent;

public class DepartmentChanged extends DomainEvent {

    private final Long id;
    private final Long department;

    public static DepartmentChanged of(final Long id, final Long department) {
        return new DepartmentChanged(id, department);
    }

    public DepartmentChanged(Long id, Long department) {
        this.id = id;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public Long getDepartment() {
        return department;
    }

}
