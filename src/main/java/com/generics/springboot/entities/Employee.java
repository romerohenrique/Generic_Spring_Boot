package com.generics.springboot.entities;

import com.generics.springboot.dto.EmployeeDTO;
import com.generics.springboot.util.Convertible;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_employee")
public class Employee implements Convertible<EmployeeDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Employee() {
    }

    public Employee(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public EmployeeDTO convert() {
        return new EmployeeDTO(this);
    }
}
