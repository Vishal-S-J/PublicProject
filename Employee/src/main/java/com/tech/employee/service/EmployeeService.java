package com.tech.employee.service;

import com.tech.employee.entity.Employee;
import com.tech.employee.mapper.EmployeeMapper;
import com.tech.employee.repos.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id)
                .orElse(new Employee());
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployeeByFirstName(String first_name) {
        return employeeRepository.findByEmployeeFirstName(first_name);
    }

    public List<Employee> getAllEmployeeByEmployeeDepartment(int id) {
        return employeeRepository.findByEmployeeDepartment_DepartmentId(id);
    }

    public List<Employee> getAllEmployeeByEmployeeProject(int id) {
        return employeeRepository.findByEmployeeProject_ProjectId(id);
    }

    public List<Employee> getAllEmployeeByProjectName(String projectName) {
        return employeeRepository.findByEmployeeProject_ProjectName(projectName);
    }

    public List<Employee> getAllEmployeeBySalaryFromAndTo(BigDecimal fromSalary, BigDecimal toSalary) {
        return employeeRepository.findBySalaryBetween(fromSalary, toSalary);
    }

    public Employee updateEmployeeProjectIdByEmployeeId(int projectId, int employeeId) {
        return employeeRepository.setEmployeeProjectFor(projectId, employeeId);
    }
}
