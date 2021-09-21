package com.trainee.moviestore.repository;

import com.trainee.moviestore.model.Role;
import com.trainee.moviestore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(long id);

    User findUserByUsername(String name);

    List<User> findUserByRole(Role role);

}
