package com.generics.springboot.controllers;

import com.generics.springboot.dto.EmployeeDTO;
import com.generics.springboot.entities.Employee;
import com.generics.springboot.services.EmployeeService;
import com.generics.springboot.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        EmployeeDTO obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findById() {
        List<EmployeeDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
}
