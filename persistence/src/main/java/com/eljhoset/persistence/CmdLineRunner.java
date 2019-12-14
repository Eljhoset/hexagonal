package com.eljhoset.persistence;

import com.eljhoset.persistence.model.Department;
import com.eljhoset.persistence.model.Employee;
import com.eljhoset.persistence.repository.DepartmentSpringBootRepository;
import com.eljhoset.persistence.repository.EmployeeSpringBootRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdLineRunner implements CommandLineRunner {

    @Autowired
    private EmployeeSpringBootRepository employeeRepository;
    @Autowired
    private DepartmentSpringBootRepository departmentRepository;

    @Override
    public void run(String... strings) throws Exception {
        Department department = new Department();
        department.setId(1l);
        department.setName("Tech");
        Department department2 = new Department();
        department.setId(2l);
        department.setName("sales");
        departmentRepository.saveAll(Arrays.asList(department, department2));

        Employee employee = new Employee();
        employee.setId(1l);
        employee.setFirstName("Jose");
        employee.setLastName("Perez");
        employee.setDepartment(department);
        employeeRepository.save(employee);

        System.out.println(employee);

    }

}
