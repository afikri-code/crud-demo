package de.tramotech.demo.dto;

import de.tramotech.demo.model.Project;
import de.tramotech.demo.model.User;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ProjectCreationDto {
  private long id;
  private String name;
  private String description;
  private long userId;
  private Set<ImageCreationDto> images = new HashSet<>();


  // Static method to convert from Entity to DTO
  public static ProjectCreationDto fromEntity(Project project) {
    ProjectCreationDto dto = new ProjectCreationDto();
    dto.setId(project.getId());
    dto.setName(project.getName());
    dto.setDescription(project.getDescription());
    dto.setImages(project.getImages().stream().map(ImageCreationDto::fromEntity).collect(Collectors.toSet()));
    return dto;
  }

  public static Project toEntity(ProjectCreationDto projectCreationDto){
    Project project = new Project();
    project.setId(projectCreationDto.getId());
    project.setName(projectCreationDto.getName());
    project.setDescription(projectCreationDto.getDescription());
    project.setUserId(projectCreationDto.getUserId());
    project.setImages(projectCreationDto.getImages().stream().map(ImageCreationDto::toEntity).collect(Collectors.toSet()));
    return project;
  }
}
