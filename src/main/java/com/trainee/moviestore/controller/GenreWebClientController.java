package com.trainee.moviestore.controller;

import com.trainee.moviestore.service.TheMoviedbService;
import com.trainee.moviestore.test.GenresDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genres/tmdb")
public class GenreWebClientController {

    final TheMoviedbService tmdbService;

    WebClient webClient;

    @PostConstruct
    private void setUpWebClient() {
        try {
            webClient = WebClient.create(tmdbService.createGenreUrlBuilder());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @GetMapping()
    public Flux<GenresDto> getAllGenreWebClient() {

        return webClient
                .get()
                .retrieve()
                .bodyToFlux(GenresDto.class);

    }
}
