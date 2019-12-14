
package com.eljhoset.persistence.repository;

import com.eljhoset.employee.application.repository.DepartmentRepository;
import com.eljhoset.persistence.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentSpringBootRepository extends CrudRepository<Department, Long>,DepartmentRepository {

    @Override
     default boolean exist(Long deparment){
         return existsById(deparment);
     }
    
}
