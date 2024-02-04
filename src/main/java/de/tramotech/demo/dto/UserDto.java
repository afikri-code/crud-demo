package de.tramotech.demo.dto;

import de.tramotech.demo.model.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

import java.time.LocalDate;

@Data
public class UserDto {
  @Delegate
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.PRIVATE)
  private UserCreationDto userCreatedDto = new UserCreationDto();
  private LocalDate createdAt;
  private LocalDate updatedAt;

  public static UserDto fromEntity(User user){
    UserDto dto = new UserDto();
    dto.setUserCreatedDto(UserCreationDto.fromEntity(user));
    dto.setCreatedAt(user.getCreatedAt());
    dto.setUpdatedAt(user.getUpdatedAt());
    return dto;
  }
}
