package de.tramotech.demo.dto;

import de.tramotech.demo.model.Project;
import de.tramotech.demo.model.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ProjectDto {

  @Delegate
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.PRIVATE)
  private ProjectCreationDto userCreatedDto = new ProjectCreationDto();
  private LocalDate createdAt;
  private LocalDate updatedAt;


  public static ProjectDto fromEntity(Project project){
    ProjectDto dto = new ProjectDto();
    dto.setUserId(project.getUserId());
    dto.setUserCreatedDto(ProjectCreationDto.fromEntity(project));
    dto.setCreatedAt(project.getCreatedAt());
    dto.setUpdatedAt(project.getUpdatedAt());
    return dto;
  }

}

