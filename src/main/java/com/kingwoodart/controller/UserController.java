package com.kingwoodart.controller;

import com.kingwoodart.dto.UserDto;
import com.kingwoodart.entity.User;
import com.kingwoodart.service.UserService;
import com.kingwoodart.validation_group.ValidationGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUserAccount(@RequestBody @Validated(ValidationGroups.Create.class) UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User was deleted with successfully.", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Validated(ValidationGroups.Update.class) UserDto userDto,
                                              @PathVariable(name = "id") long id) {
        UserDto userUpdated = userService.updateUser(userDto, id);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }
}
