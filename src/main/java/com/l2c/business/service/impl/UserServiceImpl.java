package com.l2c.business.service.impl;

import com.l2c.business.dto.UserDto;
import com.l2c.business.entity.User;
import com.l2c.business.exception.ResourceNotFoundException;
import com.l2c.business.repository.UserRepository;
import com.l2c.business.service.UserService;
import com.l2c.business.validation_group.ValidationGroups;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);

        User newUser = userRepository.save(user);

        UserDto userResponse = mapToDto(newUser);
        return userResponse;
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setUsername(userDto.getUsername());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCity(userDto.getCity());
        user.setPassword(userDto.getPassword());

        User updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    private User mapToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    private UserDto mapToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
