//package com.trainee.moviestore.service.themoviedb;
//
//import com.trainee.moviestore.dto.model.GenreDto;
//import com.trainee.moviestore.dto.model.GenresDto;
//import com.trainee.moviestore.model.Genre;
//import org.apache.http.client.HttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class GenreServerimpl {
//
//
//    private HttpClient httpClient = HttpClientBuilder.create().build();
//
//    private ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//
//    private RestTemplate restTemplate = new RestTemplate(requestFactory);
//
//    public List<GenreDto> getGenre() {
//
//        String url = "https://api.themoviedb.org/3/genre/movie/list?api_key=4f2a766c5f669997d1d63ea736387dd6";
//
//        try {
//            GenresDto response = restTemplate.getForObject(new URI(url), GenresDto.class);
//
//            return response.getGenres();
//
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
////    @Override // здесь будем сохранять модель фильма после распарсивания
////    public Movie create(Movie model) {
////        return movieRepository.save(model);
////    }
//
//    // здесь будем выводить модели фильма после распарсивания
//    public List<Genre> getAll() {
//        List<Genre> genres = getGenre().stream()
//                .map(this::toGenre)
//                .collect(Collectors.toList());
//        return genres;
//    }
//
//    private Genre toGenre(GenreDto genreDto) {
//        System.out.println(genreDto.toString());
//
//        Genre genre = new Genre();
//        genre.setName(genreDto.getName());
//        genre.setExternalId(genreDto.getId());
//
//
//        System.out.println(genre);
//
//        return genre;
//    }
//}
//


