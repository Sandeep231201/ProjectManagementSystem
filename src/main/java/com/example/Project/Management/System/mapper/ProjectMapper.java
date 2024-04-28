package com.example.Project.Management.System.mapper;

import com.example.Project.Management.System.dto.ProjectDto;
import com.example.Project.Management.System.entity.Project;

public class ProjectMapper {

    public static Project mapToProject(ProjectDto projectDto) {
        Project project = new Project(
                projectDto.getId(),
                projectDto.getName(),
                projectDto.getDescription(),
                projectDto.getStartDate(),
                projectDto.getEndDate(),
                projectDto.getStatus(),
                projectDto.getProjectManager(),
                projectDto.getProjectManagerEmail(),
                projectDto.getProjectManagerPhone(),
                projectDto.getProjectManagerDepartment()
        );
        return project;
    }

    public static ProjectDto mapToProjectDto(Project project){
        ProjectDto projectDto = new ProjectDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                project.getStatus(),
                project.getProjectManager(),
                project.getProjectManagerEmail(),
                project.getProjectManagerPhone(),
                project.getProjectManagerDepartment()
        );
        return projectDto;
    }


}
