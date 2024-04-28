package com.example.Project.Management.System.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDto {

    private int id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String status;
    private String projectManager;
    private String projectManagerEmail;
    private String projectManagerPhone;
    private String projectManagerDepartment;

}
