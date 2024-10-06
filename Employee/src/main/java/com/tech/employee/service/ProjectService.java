package com.tech.employee.service;

import com.tech.employee.entity.Project;
import com.tech.employee.mapper.ProjectMapper;
import com.tech.employee.repos.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public Project getProject(int id) {
        return projectRepository.findById(id)
                .orElse(new Project());
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }
}
