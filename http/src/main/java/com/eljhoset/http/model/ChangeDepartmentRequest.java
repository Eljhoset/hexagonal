package com.eljhoset.http.model;

import javax.validation.constraints.NotNull;

public class ChangeDepartmentRequest {

    @NotNull
    private Long department;

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

}
