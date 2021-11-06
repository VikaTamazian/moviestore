package com.trainee.moviestore.controller;

import com.trainee.moviestore.dto.GenresDto;
import com.trainee.moviestore.dto.MovieDto;
import com.trainee.moviestore.dto.MoviesResponseTmdb;
import com.trainee.moviestore.service.TheMoviedbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class GenreWebClientController {

    final TheMoviedbService tmdbService;

    WebClient webClient;

    @PostConstruct
    private void setUpWebClient() {
        webClient = WebClient.create();
    }

    @GetMapping("/genres")
    public Flux<GenresDto> getAllGenreWebClient() throws URISyntaxException {

        return webClient
                .get()
                .uri(tmdbService.createGenreSearchUrlBuilder())
                .retrieve()
                .bodyToFlux(GenresDto.class);

    }

    @GetMapping("/movies/{title}")
    public Flux<MoviesResponseTmdb> getAllMoviesWebClient(@PathVariable("title") String title) throws URISyntaxException {

        return webClient
                .get()
                .uri(tmdbService.createMoviesSearchByTitleUrlBuilder(title))
                .retrieve()
                .bodyToFlux(MoviesResponseTmdb.class);

    }

    @GetMapping("/movie/{id}")
    public Mono<MovieDto> getMovieWebClient(@PathVariable("id") Long id) throws URISyntaxException {

        return webClient
                .get()
                .uri(tmdbService.createMovieSearchByIdUrlBuilder(id))
                .retrieve()
                .bodyToMono(MovieDto.class);
    }
}
