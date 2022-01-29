package com.learnrestservice.restservice.controllers;

import java.util.List;

import com.learnrestservice.restservice.contracts.EmployeeRepository;
import com.learnrestservice.restservice.models.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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



    

}
