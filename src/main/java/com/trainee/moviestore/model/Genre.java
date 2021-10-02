package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "external_id")
    private long external_id;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

}
