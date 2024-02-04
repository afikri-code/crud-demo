package de.tramotech.demo.service;

import de.tramotech.demo.model.Image;
import de.tramotech.demo.model.Project;
import de.tramotech.demo.repositry.ImageRepository;
import de.tramotech.demo.repositry.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {
  private final ProjectRepository projectRepository;
  private final ImageRepository imageRepository;

  @Autowired
  public ProjectService(ProjectRepository projectRepository, ImageRepository imageRepository) {
    this.projectRepository = projectRepository;
    this.imageRepository = imageRepository;
  }

  public List<Project> getAllProjects() {
    return projectRepository.findAll();
  }

  public Optional<Project> getProjectById(long id) {
    return projectRepository.findById(id);
  }

  public Project saveProject(Project project) {
    List<Image> imgages = imageRepository.findAllById(project.getImages()
                                                             .stream()
                                                             .map(image -> image.getId())
                                                             .collect(Collectors.toList()));
    project.setImages(new HashSet<>(imgages));
    return projectRepository.save(project);
  }

  public void deleteProject(long id) {
    imageRepository.deleteById(id);
  }
}
