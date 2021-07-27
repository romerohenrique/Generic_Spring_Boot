package com.generics.springboot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.generics.springboot.dto.EmployeeDTO;
import com.generics.springboot.entities.Employee;
import com.generics.springboot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeDTO findById(Long id) {
        Optional<Employee> result = repository.findById(id);
        return new EmployeeDTO(result.get());
    }

    public List<EmployeeDTO> findAll() {
        List<Employee> list = repository.findAll();
        return list.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
    }
}
