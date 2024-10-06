package com.tech.employee.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "student_id",
            updatable = false
    )
    private int studentId;

    @Column(name = "student_first_name")
    private String studentFirstName;

    @Column(name = "student_last_name")
    private String studentLastName;

    @Column(name = "student_department")
    private String studentDepartment;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(
            name = "student_salary",
            precision = 10,
            scale = 2
    )
    private BigDecimal Salary;

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

    @Column(name = "student_project")
    private String project;
}
