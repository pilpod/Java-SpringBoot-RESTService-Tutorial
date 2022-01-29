package com.learnrestservice.restservice.contracts;

import com.learnrestservice.restservice.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

