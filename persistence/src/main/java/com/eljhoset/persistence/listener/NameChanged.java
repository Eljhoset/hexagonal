package com.eljhoset.persistence.listener;

import com.eljhoset.employee.domain.event.EmployeeNameChanged;
import com.eljhoset.persistence.repository.EmployeeSpringBootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NameChanged {

    @Autowired
    private EmployeeSpringBootRepository bootRepository;

    @EventListener
    void listen(EmployeeNameChanged nameChanged) {
        bootRepository.findById(nameChanged.getId())
                .ifPresent((employee) -> {
                    
                    employee.setFirstName(nameChanged.getNewFirstName());
                    employee.setLastName(nameChanged.getNewLastName());
                    bootRepository.save(employee);
                    
                });
    }
}
