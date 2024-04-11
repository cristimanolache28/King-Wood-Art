package com.l2c.business.service;

import com.l2c.business.dto.UserDto;
import com.l2c.business.entity.User;


public interface UserService {
    UserDto createUser(UserDto userDto);

    void deleteUserById(long id);

    User getUserById(long id);

    UserDto updateUser(UserDto userDto, long id);
}
