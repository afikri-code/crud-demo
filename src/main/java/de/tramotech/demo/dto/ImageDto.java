package de.tramotech.demo.dto;

import de.tramotech.demo.model.Image;
import de.tramotech.demo.model.Project;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;
@Data
public class ImageDto {
  @Delegate
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.PRIVATE)
  private ImageCreationDto imageCreationDto = new ImageCreationDto();


  public static ImageDto fromEntity(Image image){
    ImageDto dto = new ImageDto();
    dto.setId(image.getId());
    dto.setUrl(image.getUrl());
    return dto;
  }
}
