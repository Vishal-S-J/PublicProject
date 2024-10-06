package com.tech.employee.repos;

import com.tech.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByEmployeeFirstName(String employeeFirstName);

    public List<Employee> findBySalaryBetween(BigDecimal startSalary, BigDecimal endSalary);

    public List<Employee> findByEmployeeDepartment_DepartmentId(int id);

    public List<Employee> findByEmployeeProject_ProjectId(int id);

    public List<Employee> findByEmployeeProject_ProjectName(String projectName);

    public Employee setEmployeeProjectFor(int projectId, int employeeId);
}
