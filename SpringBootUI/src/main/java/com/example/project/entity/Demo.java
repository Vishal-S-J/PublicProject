package com.example.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "proDemo")
public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String demoDesc;

    public Demo() { }

    public Demo(String demoDesc) {
        this.demoDesc = demoDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDemoDesc() {
        return demoDesc;
    }

    public void setDemoDesc(String demoDesc) {
        this.demoDesc = demoDesc;
    }
}
