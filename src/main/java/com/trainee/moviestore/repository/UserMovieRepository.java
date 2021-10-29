package com.trainee.moviestore.repository;

import com.trainee.moviestore.model.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {

    //TODO implement
    List<UserMovie> findAllByUserId(Long userId);
}
