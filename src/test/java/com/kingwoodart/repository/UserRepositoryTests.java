package com.kingwoodart.repository;

import com.kingwoodart.entity.Role;
import com.kingwoodart.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser_withOneRole() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User user = new User("Cristian",
                "Manolache",
                "Cristi",
                "cristianmanolache0@gmail.com",
                "0731148192",
                "password",
                "Bucuresti");

        user.addRole(roleAdmin);

        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    @Rollback(value = false)
    public void testCreateUser_WithTwoRoles() {
        User user = new User("Ivan",
                "Ford",
                "Ivan Ford",
                "ivan_ford@gmail.com",
                "0733214192",
                "Brasov",
                "password");

        Role moderator = new Role(2);
        Role assistant = new Role(3);

        user.addRole(moderator);
        user.addRole(assistant);

        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = userRepository.findAll();

        listUsers.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById() {
        User findUser = userRepository.findById(2L).get();
        System.out.println(findUser);
        assertThat(findUser).isNotNull();
    }


}
