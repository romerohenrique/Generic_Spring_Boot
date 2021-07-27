package com.generics.springboot.services;

import com.generics.springboot.dto.EmployeeDTO;
import com.generics.springboot.entities.Employee;
import com.generics.springboot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements GenericService<Employee, EmployeeDTO, Long> {


    @Autowired
    private EmployeeRepository repository;

    @Override
    public JpaRepository<Employee, Long> getRepository() {
        return repository;
    }
}
