package com.pop.film.client;

import com.pop.film.dto.FilmResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class FilmClient {

    @Value("${tmdb.api.url}")
    private String urlApi;

    @Value("${tmdb.api.token}")
    private String apiToken;

    private RestTemplate restTemplate;

    public FilmClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private HttpEntity<Void> buildEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiToken);
        return new HttpEntity<>(headers);
    }

    public FilmResponseDTO getByName(String name) {

        return restTemplate.exchange(
                urlApi + "/search/movie?query=" + name,
                HttpMethod.GET,
                buildEntity(),
                FilmResponseDTO.class
        ).getBody();
    }

    public FilmResponseDTO getPopular() {

        return restTemplate.exchange(
                urlApi + "/movie/popular?language=en-US&page=1" ,
                HttpMethod.GET,
                buildEntity(),
                FilmResponseDTO.class
        ).getBody();
    }


    public FilmResponseDTO getRandomFilms(String genre, Float voteAverage, Integer primaryReleaseY, Integer page) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlApi + "/discover/movie");

        if (genre != null)   builder.queryParam("with_genres", genre);
        if (voteAverage != null)   builder.queryParam("vote_average.lte", voteAverage);
        if (primaryReleaseY != null)  builder.queryParam("primary_release_year", primaryReleaseY);
        if (page != null)  builder.queryParam("page", page);

        String url = builder.toUriString();

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                buildEntity(),
                FilmResponseDTO.class
        ).getBody();
    }
}
