package com.l2c.business.service.impl;

import com.l2c.business.dto.UserDto;
import com.l2c.business.entity.User;
import com.l2c.business.exception.ResourceNotFoundException;
import com.l2c.business.repository.UserRepository;
import com.l2c.business.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


//        User newUser = new User();
//        newUser.setFirstName(userDto.getFirstName());
//        newUser.setSecondName(userDto.getSecondName());
//        newUser.setUsername(userDto.getUsername());
//        newUser.setEmail(userDto.getEmail());
//        newUser.setPhoneNumber(userDto.getPhoneNumber());
//        newUser.setCity(userDto.getCity());
//        newUser.setPassword(userDto.getPassword());
//
//        userRepository.save(newUser);
//        return newUser;
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
    public User updateUser(User user, long id) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        updateUser.setFirstName(user.getFirstName());
        updateUser.setSecondName(user.getSecondName());
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhoneNumber(user.getPhoneNumber());
        updateUser.setCity(user.getCity());
        updateUser.setPassword(user.getPassword());

        User updatedUser = userRepository.save(updateUser);
        return updatedUser;
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
