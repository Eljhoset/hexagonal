package com.eljhoset.http.controller;

import com.eljhoset.employee.application.command.ChangeDepartment;
import com.eljhoset.employee.application.service.DeparmentChanger;
import com.eljhoset.http.model.ChangeDepartmentRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentChangerController {

    @Autowired
    private DeparmentChanger changer;

    @PostMapping("employee/{id}/changeDepartment")
    public ResponseEntity<?> change(@PathVariable Long id,
            @Valid @RequestBody ChangeDepartmentRequest departmentRequest) {
        ChangeDepartment command = new ChangeDepartment(id, departmentRequest.getDepartment());
        changer.change(command);
        return ResponseEntity.ok().build();
    }
}
