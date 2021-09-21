package com.trainee.moviestore.repository;

import com.trainee.moviestore.model.Profile;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Profile findProfileById(long id);

    List<Profile> findProfileByFirstName(String firstName);

    List<Profile> findProfileByLastName(String lastName);

    List<Profile> findProfileByCreated(Timestamp timestamp);

    List<Profile> findProfileByUpdated(Timestamp timestamp);

}
