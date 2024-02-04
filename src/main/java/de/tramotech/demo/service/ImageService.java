package de.tramotech.demo.service;

import de.tramotech.demo.model.Image;
import de.tramotech.demo.model.Project;
import de.tramotech.demo.repositry.ImageRepository;
import de.tramotech.demo.repositry.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
  private final ImageRepository imageRepository;

  @Autowired
  public ImageService(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  public List<Image> getAllImages() {
    return imageRepository.findAll();
  }

  public Optional<Image> getProjectById(long id) {
    return imageRepository.findById(id);
  }

  public Image saveProject(Image image) {
    return imageRepository.save(image);
  }

  public void deleteProject(long id) {
    imageRepository.deleteById(id);
  }
}
