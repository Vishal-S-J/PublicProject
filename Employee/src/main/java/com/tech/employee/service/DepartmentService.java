package com.tech.employee.service;

import com.tech.employee.entity.Department;
import com.tech.employee.mapper.DepartmentMapper;
import com.tech.employee.repos.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id)
                .orElse(new Department());
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
