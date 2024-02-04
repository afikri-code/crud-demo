package de.tramotech.demo.dto;

import de.tramotech.demo.model.Image;
import lombok.Data;

@Data
public class ImageCreationDto {
  private long id;
  private String url;

  public static ImageCreationDto fromEntity(Image image) {
    ImageCreationDto dto = new ImageCreationDto();
    dto.setId(image.getId());
    dto.setUrl(image.getUrl());
    return dto;
  }

  public static Image toEntity(ImageCreationDto imageCreationDto){
    Image image = new Image();
    image.setUrl(imageCreationDto.getUrl());
    image.setId(imageCreationDto.getId());
    return image;
  }
}
