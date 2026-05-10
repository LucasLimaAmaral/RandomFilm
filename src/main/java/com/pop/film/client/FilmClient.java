package com.pop.film.client;

import com.pop.film.dto.FilmResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FilmClient {

    @Value("${tmdb.api.url}")
    private String urlApi;

    @Value("${tmdb.api.token}")
    private String apiToken;


    public FilmResponseDTO getByName(String name) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                urlApi + "/search/movie?query=" + name,
                HttpMethod.GET,
                entity,
                FilmResponseDTO.class
        ).getBody();
    }

    public FilmResponseDTO getPopular() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                urlApi + "/movie/popular?language=en-US&page=1" ,
                HttpMethod.GET,
                entity,
                FilmResponseDTO.class
        ).getBody();
    }
}
