package com.sample.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
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
}


