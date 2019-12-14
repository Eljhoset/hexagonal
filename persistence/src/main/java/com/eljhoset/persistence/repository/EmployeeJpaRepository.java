package com.eljhoset.persistence.repository;

import com.eljhoset.employee.application.repository.EmployeeRepository;
import com.eljhoset.employee.domain.aggregator.Employee;
import com.eljhoset.employee.domain.standartype.Department;
import com.eljhoset.employee.domain.valueobject.EmployeeId;
import com.eljhoset.employee.domain.valueobject.Name;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJpaRepository implements EmployeeRepository {

    @Autowired
    private EmployeeSpringBootRepository repository;

    @Override
    public Employee save(Employee entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Employee> findById(EmployeeId id) {
        
        return repository.findById(id.getId()).map((employee) -> {
            
            final Employee employeeAggregate = new Employee(EmployeeId.of(id.getId()),
                    new Department(employee.getDepartment().getId()));
            
            employeeAggregate.changeName(Name.with(employee.getFirstName(), employee.getLastName()));
            
            return employeeAggregate;
        });
    }

}
