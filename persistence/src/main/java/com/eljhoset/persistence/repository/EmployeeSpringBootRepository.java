
package com.eljhoset.persistence.repository;

import com.eljhoset.persistence.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSpringBootRepository extends CrudRepository<Employee, Long> {
    
}
