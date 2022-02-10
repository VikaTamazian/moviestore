package com.trainee.moviestore.service;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;

@Service
public class TmdbBuildURIService {

    @Value("${tmdb.api.url}")
    private String tmdbApiUrl;
    @Value("${tmdb.apikey}")
    private String tmdbApiKey;
    @Value("${tmdb.api.path.get.genres}")
    private String tmdbGenres;
    @Value("${tmdb.api.path.search.titele}")
    private String tmdbMovies;
    @Value("${tmdb.language}")
    private String tmdbLanguage;


    private final String API_KEY = "api_key";
    private final String LANGUAGE = "language";
    private final String QUERY = "query";

    public String createGenreSearchUrlBuilder() throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(tmdbApiUrl + tmdbGenres);
        uriBuilder.addParameter(API_KEY, tmdbApiKey);
        return uriBuilder.build().toString();
    }

    public String createMoviesSearchByTitleUrlBuilder(String title) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(tmdbApiUrl + tmdbMovies);
        uriBuilder.addParameter(API_KEY, tmdbApiKey);
        uriBuilder.addParameter(LANGUAGE, tmdbLanguage);
        uriBuilder.addParameter(QUERY, title);
        System.out.println(uriBuilder.build().toString());
        return uriBuilder.build().toString();
    }

}
