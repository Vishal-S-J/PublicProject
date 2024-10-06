package com.tech.employee.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "employee_id",
            updatable = false
    )
    private Integer employeeId;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @ManyToOne
    @JoinColumn(
            name = "departmentId"
    )
    @JsonBackReference(value = "employee-department")
    private Department employeeDepartment;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(
            name = "employee_salary",
            precision = 10,
            scale = 2
    )
    private BigDecimal salary;

    @CreationTimestamp
    @Column(
            name = "create_timestamp",
            nullable = false,
            updatable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP"
    )
    private Timestamp dateOfJoining;

    @UpdateTimestamp
    @Column(
            name = "update_timestamp"
    )
    private Timestamp updateTimeStamp;

    @ManyToOne
    @JoinColumn(
            name = "projectId"
    )
    @JsonBackReference(value = "employee-project")
    private Project employeeProject;

    public Employee() {
    }

    public Employee(String employeeFirstName, String employeeLastName, Department employeeDepartment, String employeeEmail, BigDecimal salary, Timestamp dateOfJoining, Timestamp updateTimeStamp, Project employeeProject) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeDepartment = employeeDepartment;
        this.employeeEmail = employeeEmail;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.updateTimeStamp = updateTimeStamp;
        this.employeeProject = employeeProject;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Timestamp getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Timestamp dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Timestamp getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Timestamp updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public Project getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(Project employeeProject) {
        this.employeeProject = employeeProject;
    }
}
