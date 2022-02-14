package com.trainee.moviestore.repositore;

import com.trainee.moviestore.model.User;
import com.trainee.moviestore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(value = {"create-user-before-test.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"delete-user-after-test.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getAllUserTest() {

        assertEquals(3, userRepository.findAll().size());
    }

    @Test
    public void findByIdUserTest() {

        assertEquals("user1", userRepository.findById(1L).get().getUsername());
    }

    @Test
    public void createUserTest() {

        User user = new User();
        user.setUsername("username4");
        user.setEmail("email4");
        user.setPassword("password4");
        userRepository.save(user);

        assertEquals(4, userRepository.findAll().size());
    }

    @Test
    public void deleteUserTest() {

        User user = userRepository.findById(1L).get();
        userRepository.delete(user);
        assertEquals(2, userRepository.findAll().size());
    }
}
