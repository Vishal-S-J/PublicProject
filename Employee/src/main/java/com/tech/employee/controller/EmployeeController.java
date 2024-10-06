package com.tech.employee.controller;

import com.tech.employee.entity.Employee;
import com.tech.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/employee")
public class EmployeeController  {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @GetMapping("/get")
    public List<Employee> getEmployeeByFirstName(@RequestParam String firstName) {
        return this.employeeService.getAllEmployeeByFirstName(firstName);
    }

    @GetMapping("/get/dept_emp/{id}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable("id") int id) {
        return this.employeeService.getAllEmployeeByEmployeeDepartment(id);
    }

    @GetMapping("/get/pro_emp/{id}")
    public List<Employee> getAllEmployeesByProject(@PathVariable("id") int id) {
        return this.employeeService.getAllEmployeeByEmployeeProject(id);
    }

    //===========================================Done===========================================

    @GetMapping("/get/project_name")
    public List<Employee> getAllEmployeesByProjectName(@RequestParam String projectName) {
        return this.employeeService.getAllEmployeeByProjectName(projectName);
    }

    @GetMapping("/get/sal")
    public List<Employee> getAllEmployeeWithinSalaryRangeFrom(@RequestParam int from, @RequestParam int to) {
        BigDecimal fromSal = BigDecimal.valueOf(from);
        BigDecimal toSal = BigDecimal.valueOf(to);
        return this.employeeService.getAllEmployeeBySalaryFromAndTo(fromSal, toSal);
    }

    @PatchMapping("/update/{employeeId}")
    public Employee updateEmployeeProjectName(@RequestParam int projectId, @PathVariable int employeeId) {
        return this.employeeService.updateEmployeeProjectIdByEmployeeId(projectId, employeeId);
    }
}
