package com.eljhoset.persistence.listener;

import com.eljhoset.employee.domain.event.DepartmentChanged;
import com.eljhoset.persistence.repository.DepartmentSpringBootRepository;
import com.eljhoset.persistence.repository.EmployeeSpringBootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DepartmentChange {

    @Autowired
    private EmployeeSpringBootRepository bootRepository;
    @Autowired
    private DepartmentSpringBootRepository department;

    @EventListener
    void listen(DepartmentChanged departmentChanged) {
        bootRepository.findById(departmentChanged.getId())
                .ifPresent((employee) -> {

                    department.findById(departmentChanged.getId()).ifPresent((entity) -> {
                        employee.setDepartment(entity);
                        bootRepository.save(employee);
                    });

                });
    }
}
