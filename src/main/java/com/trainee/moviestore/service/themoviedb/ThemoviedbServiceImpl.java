package com.trainee.moviestore.service.themoviedb;

import com.trainee.moviestore.dto.model.MovieDto;
import com.trainee.moviestore.repository.GenreRepository;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class ThemoviedbServiceImpl {

    @Autowired
    GenreRepository genreRepository;


    public List<MovieDto> getMovies() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = restTemplate.headForHeaders("https://api.themoviedb.org/3/search/movie?api_key=4f2a766c5f669997d1d63ea736387dd6&language=ru&query=звёздные");
//        try {
//
//            MovieDto[] response = restTemplate.getForObject(new URI(url), MovieDto[].class);
//            assert response != null;
//            List<MovieDto> movieDtoList = Arrays.asList(response);
//
//            return movieDtoList;
//
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
        return null;
    }


//    @Override // здесь будем сохранять модель фильма после распарсивания
//    public Movie create(Movie model) {
//        return movieRepository.save(model);
//    }

    // здесь будем выводить модели фильма после распарсивания
//    public List<Movie> getAll() {
//        return  getMovies().stream()
//                .map(this::toMovie)
//                .collect(Collectors.toList());
//
//    }
//
//    private Movie toMovie(MovieDto movieDto) {
//        System.out.println(movieDto.toString());
//
//        List<Genre> genres = new ArrayList<>();
//        movieDto.getGenreIds().forEach(id -> {
//         Genre genre = genreRepository.findByExternalId(id);
//         genres.add(genre);
//        });
//
//        Movie movie = new Movie();
//       // GenreIdsDto genre = new GenreIdsDto();
//
//        movie.setAdult(Boolean.parseBoolean(movieDto.getAdult()));
//        movie.setBackdropPath(movieDto.getBackdropPath());
//        movie.setLanguage(movieDto.getLanguage());
//        movie.setTitle(movieDto.getTitle());
//        movie.setOverview(movieDto.getOverview());
//        movie.setExternalId(movieDto.getId());
//        movie.setGenres(genres);
//
////                (//movieDto.getAdult(),
////                movieDto.getBackdrop_path(),
////                //  movieDto.getGenre_ids(),
////                movieDto.getOriginal_language(),
////                movieDto.getOriginal_title(),
////                movieDto.getOverview(),
////                movieDto.getId());
//
//        System.out.println(movie);
//
//        return movie;
//    }

}
