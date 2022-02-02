package com.learnrestservice.restservice.controllers;

import java.util.List;

import com.learnrestservice.restservice.EmployeeNotFoundException;
import com.learnrestservice.restservice.contracts.EmployeeRepository;
import com.learnrestservice.restservice.models.Employee;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {
    
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Employee> all()
    {
        return repository.findAll();
    }

    @PostMapping("/employees")
    public Employee store(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    public Employee show(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id));
    }
    
    @DeleteMapping("/employees/{id}")
    public Employee destroy(@PathVariable Long id) {
        Employee employee = repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id));
        repository.deleteById(id);
        return employee;
    }


    

}
