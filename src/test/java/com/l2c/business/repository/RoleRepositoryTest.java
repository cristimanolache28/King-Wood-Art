package com.l2c.business.repository;

import com.l2c.business.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoleRepositoryTest {

    @Autowired
    RoleRepository repository;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "manage everything");
        Role savedRole = repository.save(roleAdmin);
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

}
