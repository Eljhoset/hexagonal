package com.eljhoset.application;

import com.eljhoset.employee.application.repository.DepartmentRepository;
import com.eljhoset.employee.application.repository.EmployeeRepository;
import com.eljhoset.employee.application.service.DeparmentChanger;
import com.eljhoset.employee.application.service.NameChanger;
import com.eljhoset.sharedkernel.EventDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
    "com.eljhoset.persistence",
    "com.eljhoset.application"
})

@EntityScan(basePackages = {
    "com.eljhoset.persistence"
})
@ComponentScan(value = {"com.eljhoset.persistence", "com.eljhoset.http"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    DeparmentChanger deparmentChanger(EmployeeRepository repository,
            DepartmentRepository departmentRepository,
            EventDispatcher dispatcher) {
        return new DeparmentChanger(repository, departmentRepository, dispatcher);
    }

    @Bean
    NameChanger nameChanger(EmployeeRepository repository,
            DepartmentRepository departmentRepository,
            EventDispatcher dispatcher) {
        return new NameChanger(repository, dispatcher);
    }

    @Bean
    EventDispatcher dispatcher(ApplicationEventPublisher applicationEventPublisher) {
        return new SpringBootEventDispatcher(applicationEventPublisher);
    }

}
