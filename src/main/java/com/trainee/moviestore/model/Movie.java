package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "adult")
    private boolean adult;

    @Column(name = "backdrop_path")
    private String backdropPath;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @Column(name = "language")
    private String language;

    @Column(name = "title")
    private String title;

    @Column(name = "overview")
    private String overview;

    @OneToMany(mappedBy = "movie")
    private Set<UserMovie> userMovies;

}
