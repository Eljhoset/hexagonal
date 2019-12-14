package com.eljhoset.employee.application.service;

import com.eljhoset.employee.application.command.ChangeDepartment;
import com.eljhoset.employee.application.exception.DepartmentNotFoundException;
import com.eljhoset.employee.application.exception.EmployeeNotFoundException;
import com.eljhoset.employee.application.repository.DepartmentRepository;
import com.eljhoset.employee.application.repository.EmployeeRepository;
import com.eljhoset.employee.domain.aggregator.Employee;
import com.eljhoset.employee.domain.standartype.Department;
import com.eljhoset.employee.domain.valueobject.EmployeeId;
import com.eljhoset.sharedkernel.EventDispatcher;

public class DeparmentChanger {

    private final EmployeeRepository repository;
    private final DepartmentRepository departmentRepository;
    private final EventDispatcher dispatcher;

    public DeparmentChanger(EmployeeRepository repository, DepartmentRepository departmentRepository, EventDispatcher dispatcher) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
        this.dispatcher = dispatcher;
    }

    public void change(final ChangeDepartment changeDepartment) {

        final Long employeeLong = changeDepartment.getEmployee();
        final Long departmentLong = changeDepartment.getDepartment();
        final EmployeeId employeeId = EmployeeId.of(employeeLong);
        final Department department = new Department(departmentLong);
        if (!departmentRepository.exist(departmentLong)) {
            throw new DepartmentNotFoundException(String.format("deparment %d not found", departmentLong));
        }
        final Employee employee = repository.findById(employeeId).orElseThrow(() -> {
            return new EmployeeNotFoundException(String.format("employee %d not found", employeeLong));
        });

        employee.changeDepartment(department);

        dispatcher.dispatch(employee.getEvents());
    }
}
