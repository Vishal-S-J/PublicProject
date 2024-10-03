package com.example.springgradle.service;

import com.example.springgradle.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee();
}
