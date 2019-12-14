package com.eljhoset.employee.application.repository;

import com.eljhoset.employee.domain.aggregator.Employee;
import com.eljhoset.employee.domain.valueobject.EmployeeId;
import com.eljhoset.sharedkernel.Repository;

public interface EmployeeRepository extends Repository<Employee, EmployeeId> {

}
