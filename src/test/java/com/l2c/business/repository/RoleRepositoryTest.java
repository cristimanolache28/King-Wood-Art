package com.l2c.business.repository;

import com.l2c.business.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoleRepositoryTest {

    @Autowired
    RoleRepository repository;

    @Test
    @Rollback
    public void testCreateRoles_WithSuccessfully() {
        Role administrator = new Role("Admin", "manage everything");
        Role savedRole = repository.save(administrator);
        assertThat(savedRole.getId()).isGreaterThan(0);

        Role assistant = new Role("Assistant", "manage questions and reviews");
        Role savedAssistant = repository.save(assistant);
        assertThat(savedAssistant.getId()).isGreaterThan(0);

        Role moderator = new Role("Moderator", "manage questions, reviews, prices and other information about product" );
        Role savedModerator = repository.save(moderator);
        assertThat(savedModerator.getId()).isGreaterThan(0);

    }

}
