package com.springboot.blog.service.impl;

import com.springboot.blog.data.entity.Project;
import com.springboot.blog.data.repository.ProjectRepository;
import com.springboot.blog.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Long userId, String projectTitle, String contents, String urlLink, String fileName) {
        Project project = new Project();
        project.setUserId(userId);
        project.setProjectTitle(projectTitle);
        project.setContents(contents);
        project.setUrlLink(urlLink);
        project.setCreatedAt(LocalDateTime.now());
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @Override
    public Project updateProject(Long projectId, String projectTitle, String contents, String urlLink) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.setProjectTitle(projectTitle);
        project.setContents(contents);
        project.setUrlLink(urlLink);
        project.setModifiedAt(LocalDateTime.now());
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        projectRepository.delete(project);
    }
}