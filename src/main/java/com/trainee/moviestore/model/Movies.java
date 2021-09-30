package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "movies")
public class Movies {
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
    private List<Genres> genres;

    @Column(name = "language")
    private String language;

    @Column(name = "title")
    private String title;

    @Column(name = "overview")
    private String overview;

    @OneToMany(mappedBy = "movies")
    private Set<UserMovie> userMovies;

}
