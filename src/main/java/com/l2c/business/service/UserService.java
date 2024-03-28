package com.l2c.business.service;

import com.l2c.business.dto.UserDto;
import com.l2c.business.entity.User;


public interface UserService {
    UserDto createUser(UserDto userDto);

    void deleteUserById(long id);

    User getUserById(long id);

    User updateUser(User user, long id);
}
