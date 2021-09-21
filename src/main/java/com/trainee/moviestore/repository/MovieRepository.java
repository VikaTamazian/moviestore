package com.trainee.moviestore.repository;

import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    Movie findMovieById(long id);

    List<Movie> findMovieByName(String name);

    List<Movie> findMovieByRating(int rating);

    List<Movie> findMovieByGenre(Genre genre);

    List<Movie> findMovieByCast(String cast);

}
