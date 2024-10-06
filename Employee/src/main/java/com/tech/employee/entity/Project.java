package com.tech.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "project_id",
            updatable = false
    )
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @OneToMany(mappedBy = "employeeProject")
    @JsonManagedReference(value = "employee-project")
    private List<Employee> employeeList;

    public Project() { }

    public Project(String projectName, List<Employee> employeeList) {
        this.projectName = projectName;
        this.employeeList = employeeList;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
