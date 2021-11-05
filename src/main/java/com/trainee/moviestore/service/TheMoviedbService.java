package com.trainee.moviestore.service;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;

@Service
public class TheMoviedbService {

    @Value("${tmdb.api.url}")
    private String tmdbApiUrl;
    @Value("${tmdb.apikey}")
    private String tmdbApiKey;
    @Value("${tmdb.api.path.get.genres}")
    private String tmdbGenres;

    private final String API_KEY = "api_key";

    public String createGenreUrlBuilder() throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(tmdbApiUrl + tmdbGenres);
        uriBuilder.addParameter(API_KEY, tmdbApiKey);
        return uriBuilder.build().toString();

    }
}
