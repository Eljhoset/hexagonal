package com.eljhoset.employee.domain.aggregator;

import com.eljhoset.employee.domain.event.DepartmentChanged;
import com.eljhoset.employee.domain.event.EmployeeNameChanged;
import com.eljhoset.employee.domain.standartype.Department;
import com.eljhoset.employee.domain.valueobject.EmployeeId;
import com.eljhoset.employee.domain.valueobject.Name;
import com.eljhoset.sharedkernel.Aggregate;
import java.util.Objects;

public class Employee extends Aggregate<EmployeeId> {

    private Name name;
    private Department department;

    public Employee(final EmployeeId id, final Department department) {
        super(id);
        Objects.requireNonNull(department, "department can not be null");
        this.department = department;
    }

    public void changeDepartment(Department department) {
        Objects.requireNonNull(department, "new department can not be null");
        this.department = department;
        addEvent(DepartmentChanged.of(getId().getId(), department.getId()));
    }

    public void changeName(Name name) {
        Objects.requireNonNull(name, "new name can not be null");
        this.name = name;
        addEvent(EmployeeNameChanged.of(getId().getId(), name.getFirstname(), name.getLastname()));
    }

    public Name getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

}
