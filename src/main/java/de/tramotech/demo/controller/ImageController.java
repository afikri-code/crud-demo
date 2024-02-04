package de.tramotech.demo.controller;

import de.tramotech.demo.dto.ImageCreationDto;
import de.tramotech.demo.dto.ImageDto;
import de.tramotech.demo.dto.ProjectCreationDto;
import de.tramotech.demo.dto.ProjectDto;
import de.tramotech.demo.model.Image;
import de.tramotech.demo.model.Project;
import de.tramotech.demo.service.ImageService;
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
@RequestMapping("/api/images")
public class ImageController {
  private final ImageService imageService;

  @Autowired
  public ImageController(ImageService imageService) {
    this.imageService = imageService;
  }

  @GetMapping
  public List<Image> getAllImages() {
    return imageService.getAllImages();
  }

  @GetMapping("/{id}")
  public Image getImageById(@PathVariable long id) {
    return imageService.getProjectById(id).orElse(null);
  }

  @PostMapping
  public ResponseEntity<ImageDto> saveImage(@RequestBody ImageCreationDto imageCreationDto) {
    Image image = imageService.saveProject(ImageCreationDto.toEntity(imageCreationDto));

    return new ResponseEntity<ImageDto>(ImageDto.fromEntity(image), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public void deleteImage(@PathVariable long id) {
    imageService.deleteProject(id);
  }
}
