package com.eljhoset.http.model;

import javax.validation.constraints.NotBlank;

public class ChangeNameRequest {

    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
