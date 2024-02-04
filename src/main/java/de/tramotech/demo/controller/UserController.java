package de.tramotech.demo.controller;

import de.tramotech.demo.dto.UserCreationDto;
import de.tramotech.demo.dto.UserDto;
import de.tramotech.demo.model.User;
import de.tramotech.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable long id) {
    return userService.getUserById(id).orElse(null);
  }

  @PostMapping
  public ResponseEntity<UserDto> saveUser(@RequestBody UserCreationDto userCreationDto) {
    User user = userService.saveUser(UserCreationDto.toEntity(userCreationDto));

    return new ResponseEntity<UserDto>(UserDto.fromEntity(user), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable long id) {
    userService.deleteUser(id);
  }

}

