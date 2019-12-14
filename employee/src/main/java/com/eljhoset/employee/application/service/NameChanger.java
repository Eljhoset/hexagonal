package com.eljhoset.employee.application.service;

import com.eljhoset.employee.application.command.ChangeName;
import com.eljhoset.employee.application.exception.EmployeeNotFoundException;
import com.eljhoset.employee.application.repository.EmployeeRepository;
import com.eljhoset.employee.domain.aggregator.Employee;
import com.eljhoset.employee.domain.valueobject.EmployeeId;
import com.eljhoset.employee.domain.valueobject.Name;
import com.eljhoset.sharedkernel.EventDispatcher;

public class NameChanger {

    private final EmployeeRepository repository;
    private final EventDispatcher dispatcher;

    public NameChanger(EmployeeRepository repository, EventDispatcher dispatcher) {
        this.repository = repository;
        this.dispatcher = dispatcher;
    }

    public void change(final ChangeName changeName) {

        final Long employeeLong = changeName.getEmployee();
        final String firstName = changeName.getFirstname();
        final String lastName = changeName.getLastname();
        final EmployeeId employeeId = EmployeeId.of(employeeLong);
        final Name name = Name.with(firstName, lastName);
        final Employee employee = repository.findById(employeeId).orElseThrow(() -> {
            return new EmployeeNotFoundException(String.format("employee %d not found", employeeLong));
        });

        employee.changeName(name);

        dispatcher.dispatch(employee.getEvents());
    }
}
