package com.pop.film.client;

import com.pop.film.dto.FilmResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FilmClient {

    @Value("${tmdb.api.url}")
    private String urlApi;

    @Value("${tmdb.api.token}")
    private String apiToken;


    public FilmResponseDTO getByName(String name){


         return WebClient.create(urlApi)
                 .get()                              // metodo HTTP
                 .uri("/search/movie?query=" + name)       // caminho
                 .header("Authorization", "Bearer " + apiToken)  // header
                 .retrieve()                         // dispara a requisição
                 .bodyToMono(FilmResponseDTO.class)           // tipo da resposta
                 .block();
    }
}
