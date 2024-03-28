package com.l2c.business.controller;

import com.l2c.business.dto.UserDto;
import com.l2c.business.entity.User;
import com.l2c.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUserAccount(@RequestBody UserDto userDto) {
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
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable(name = "id") long id) {
        User userUpdated = userService.updateUser(user, id);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }
}
