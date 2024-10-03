package com.example.springgradle.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "emp_first_name")
    private String firstName;

    @Column(name = "emp_last_name")
    private String lastName;

    @Column(name = "emp_department")
    private String department;

    @Column(name = "email")
    private String email;

    @Column(name = "emp_sal", precision = 10, scale = 2)
    private BigDecimal salary;

    @CreationTimestamp
    @Column(name = "empDateOfJoining", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP"
    )
    private Timestamp dateOfJoining;

    @UpdateTimestamp
    @Column(name = "update_timestamp")
    private Timestamp updateTimeStamp;

    @Column(name = "emp_project")
    private String project;

    public Employee() { }

    public Employee(String firstName, String lastName, String department, String email, BigDecimal salary, Timestamp dateOfJoining, Timestamp updateTimeStamp, String project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.updateTimeStamp = updateTimeStamp;
        this.project = project;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
