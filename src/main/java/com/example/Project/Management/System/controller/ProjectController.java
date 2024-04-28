package com.example.Project.Management.System.controller;

import com.example.Project.Management.System.dto.ProjectDto;
import com.example.Project.Management.System.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Add Project REST API
    @PostMapping
    public ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto projectDto){
        return  new ResponseEntity<>(projectService.createProject(projectDto), HttpStatus.CREATED);
    }

    // Get Project REST API
    @GetMapping("/{id}")
    public  ResponseEntity<ProjectDto> getProjectById(@PathVariable int id){
        ProjectDto projectDto = projectService.getProjectById(id);
        return ResponseEntity.ok(projectDto);
    }

    // Update Project REST API
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable int id, @RequestBody Map<String, String> project){
        return ResponseEntity.ok(projectService.update(id, project.get("name"), project.get("description"), project.get("startDate"), project.get("endDate"), project.get("status"), project.get("projectManager"), project.get("projectManagerEmail"), project.get("projectManagerPhone"), project.get("projectManagerDepartment")));
    }


    //Get All Projects REST API
    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        List<ProjectDto> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    // Delete Project REST API
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteProject(@PathVariable int id){
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project Deleted Successfully");
    }

}
