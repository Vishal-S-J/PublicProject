package com.example.springgradle.web;

import com.example.springgradle.model.Employee;
import com.example.springgradle.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String showEmployeeList(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return View.INDEX;
    }
}
