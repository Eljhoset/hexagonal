package com.eljhoset.employee.application.command;

public class ChangeDepartment {

    private final Long employee;
    private final Long department;

    public ChangeDepartment(Long employee, Long department) {
        this.employee = employee;
        this.department = department;
    }

    public Long getEmployee() {
        return employee;
    }

    public Long getDepartment() {
        return department;
    }

}
