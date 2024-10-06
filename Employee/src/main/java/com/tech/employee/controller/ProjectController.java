package com.tech.employee.controller;

import com.tech.employee.entity.Project;
import com.tech.employee.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") int id) {
        return projectService.getProject(id);
    }

    @PostMapping("/add")
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }
}
