package com.trainee.moviestore.controller;

import com.trainee.moviestore.dto.GenreSaveTmdbDto;
import com.trainee.moviestore.dto.MovieSaveTmdbDto;
import com.trainee.moviestore.service.TmdbBuildURIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;

/**
 * Controller for searching movies and genres with themoviedb API
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class TmdbSearchController {

    final TmdbBuildURIService tmdbService;

    WebClient webClient;

    @PostConstruct
    private void setUpWebClient() {
        webClient = WebClient.create();
    }

    @GetMapping("/genres")
    public Flux<GenreSaveTmdbDto> getAllGenreWebClient() throws URISyntaxException {

        return webClient
                .get()
                .uri(tmdbService.createGenreSearchUrlBuilder())
                .retrieve()
                .bodyToFlux(GenreSaveTmdbDto.class);

    }

    @GetMapping("/movies/{title}")
    public Flux<MovieSaveTmdbDto> getAllMoviesWebClient(@PathVariable("title") String title) throws URISyntaxException {

        return webClient
                .get()
                .uri(tmdbService.createMoviesSearchByTitleUrlBuilder(title))
                .retrieve()
                .bodyToFlux(MovieSaveTmdbDto.class);

    }
}
