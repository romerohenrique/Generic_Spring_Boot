package com.generics.springboot.controllers;

import com.generics.springboot.dto.EmployeeDTO;
import com.generics.springboot.entities.Employee;
import com.generics.springboot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping(value = "/post")
    public ResponseEntity<EmployeeDTO> save(@RequestBody Employee obj) {
        EmployeeDTO one = service.save(obj);
        return ResponseEntity.ok().body(one);
    }

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

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
