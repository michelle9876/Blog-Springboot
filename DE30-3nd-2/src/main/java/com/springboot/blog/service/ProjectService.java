package com.springboot.blog.service;

import com.springboot.blog.data.entity.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Long userId, String projectTitle, String contents, String urlLink, String fileName);
    List<Project> getAllProjects();
    Project getProjectById(Long projectId);
    Project updateProject(Long projectId, String projectTitle, String contents, String urlLink);
    void deleteProject(Long projectId);
}