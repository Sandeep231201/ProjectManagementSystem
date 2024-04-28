package com.example.Project.Management.System.service;

import com.example.Project.Management.System.dto.ProjectDto;

import java.util.List;


public interface ProjectService {

    ProjectDto createProject(ProjectDto projectDto);

    ProjectDto getProjectById(int id);

    ProjectDto update(int id , String name , String description , String startDate , String endDate , String status , String projectManager , String projectManagerEmail , String projectManagerPhone , String projectManagerDepartment);

    List<ProjectDto> getAllProjects();

    void deleteProject(int id);

}
