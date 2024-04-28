package com.example.Project.Management.System.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "project_name")
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
