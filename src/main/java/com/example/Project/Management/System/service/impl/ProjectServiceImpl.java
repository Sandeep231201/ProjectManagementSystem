package com.example.Project.Management.System.service.impl;

import com.example.Project.Management.System.dto.ProjectDto;
import com.example.Project.Management.System.entity.Project;
import com.example.Project.Management.System.mapper.ProjectMapper;
import com.example.Project.Management.System.repository.ProjectRepository;
import com.example.Project.Management.System.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = ProjectMapper.mapToProject(projectDto);
        Project savedProject = projectRepository.save(project);
        return ProjectMapper.mapToProjectDto(savedProject);
    }

    @Override
    public ProjectDto getProjectById(int id) {
        Project project = projectRepository
                .findById((long) id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return ProjectMapper.mapToProjectDto(project);
    }

    @Override
    public ProjectDto update(int id, String name, String description, String startDate, String endDate, String status, String projectManager, String projectManagerEmail, String projectManagerPhone, String projectManagerDepartment) {
        Project project = projectRepository
                .findById((long) id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.setName(name);
        project.setDescription(description);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setStatus(status);
        project.setProjectManager(projectManager);
        project.setProjectManagerEmail(projectManagerEmail);
        project.setProjectManagerPhone(projectManagerPhone);
        project.setProjectManagerDepartment(projectManagerDepartment);
        Project updatedProject = projectRepository.save(project);
        return ProjectMapper.mapToProjectDto(updatedProject);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map((project) -> ProjectMapper.mapToProjectDto(project))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteProject(int id) {


        Project project = projectRepository
                .findById((long) id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        projectRepository.deleteById((long) id);

    }

}
