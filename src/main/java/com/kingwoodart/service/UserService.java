package com.kingwoodart.service;

import com.kingwoodart.entity.User;
import com.kingwoodart.dto.UserDto;


public interface UserService {
    UserDto createUser(UserDto userDto);

    void deleteUserById(long id);

    User getUserById(long id);

    UserDto updateUser(UserDto userDto, long id);
}
