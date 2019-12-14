package com.eljhoset.employee.application.command;

public class ChangeName {

    private final Long employee;
    private final String firstname;
    private final String lastname;

    public ChangeName(Long employee, String firstname, String lastname) {
        this.employee = employee;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getEmployee() {
        return employee;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
