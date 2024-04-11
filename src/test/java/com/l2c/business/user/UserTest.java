package com.l2c.business.user;

import com.l2c.business.entity.User;
import com.l2c.business.repository.UserRepository;
import com.l2c.business.service.UserService;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class UserTest {
    // GIVEN, WHEN, THEN
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback
    public void givenUserObject_whenSavingUser_thenReturnUserObject() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("firstname");
        user.setSecondName("secondname");
        user.setUsername("username");
        user.setEmail("user@yahoo.com");
        user.setPhoneNumber("07112345678");
        user.setCity("City");
        user.setPassword("password");

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
    }
}
