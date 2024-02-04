package de.tramotech.demo.controller;

import de.tramotech.demo.dto.ProjectCreationDto;
import de.tramotech.demo.dto.ProjectDto;
import de.tramotech.demo.model.Project;
import de.tramotech.demo.service.ImageService;
import de.tramotech.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

  private final ProjectService projectService;

  @Autowired
  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @GetMapping
  public List<Project> getAllUsers() {
    return projectService.getAllProjects();
  }

  @GetMapping("/{id}")
  public Project getUserById(@PathVariable long id) {
    return projectService.getProjectById(id).orElse(null);
  }

  @PostMapping
  public ResponseEntity<ProjectDto> saveUser(@RequestBody ProjectCreationDto projectCreationDto) {
     Project project = projectService.saveProject(ProjectCreationDto.toEntity(projectCreationDto));

    return new ResponseEntity<ProjectDto>(ProjectDto.fromEntity(project), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable long id) {
    projectService.deleteProject(id);
  }

}
