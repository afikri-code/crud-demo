package de.tramotech.demo.dto;

import de.tramotech.demo.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreationDto {
  private long id;

  // user name should not be null or empty
  // user name should have at least 2 characters
  @NotEmpty
  @Size(min = 2, message = "user name should have at least 2 characters")
  private String name;

  // email should be a valid email format
  // email should not be null or empty
  @NotEmpty
  @Email
  private String email;

  public static UserCreationDto fromEntity(User user){
    UserCreationDto dto = new UserCreationDto();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    return dto;
  }

  public static User toEntity(UserCreationDto userCreationDto){
    User user = new User();
    user.setId(userCreationDto.getId());
    user.setName(userCreationDto.getName());
    user.setEmail(userCreationDto.getEmail());
    return user;
  }
}
