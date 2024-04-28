package com.example.Project.Management.System.repository;

import com.example.Project.Management.System.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
