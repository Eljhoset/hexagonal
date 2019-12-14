package com.eljhoset.http.controller;

import com.eljhoset.employee.application.command.ChangeName;
import com.eljhoset.employee.application.service.NameChanger;
import com.eljhoset.http.model.ChangeNameRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameChangerController {

    @Autowired
    private NameChanger changer;

    @PostMapping("employee/{id}/changeName")
    public ResponseEntity<?> change(@PathVariable Long id,
            @Valid @RequestBody ChangeNameRequest changeName) {
        final ChangeName command = new ChangeName(id, changeName.getFirstname(), changeName.getLastname());
        changer.change(command);
        return ResponseEntity.ok().build();
    }
}
