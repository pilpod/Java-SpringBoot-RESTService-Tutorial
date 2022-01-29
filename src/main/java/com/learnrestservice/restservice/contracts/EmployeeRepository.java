package com.learnrestservice.restservice.contracts;

import com.learnrestservice.restservice.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
