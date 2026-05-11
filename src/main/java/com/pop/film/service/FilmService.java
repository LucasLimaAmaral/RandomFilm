package com.pop.film.service;

import com.pop.film.client.FilmClient;
import com.pop.film.dto.FilmDTO;
import com.pop.film.dto.FilmResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private FilmClient filmClient;

    public FilmService(FilmClient filmClient) {
        this.filmClient = filmClient;
    }

    public List<FilmDTO> findByName(String name){

        FilmResponseDTO films = filmClient.getByName(name);
        return films.results();
    }

    public List<FilmDTO> getPopularList(){
        FilmResponseDTO films = filmClient.getPopular();
        return films.results();
    }

    public List<FilmDTO> getRandomFilm(String genre, Float voteAverage, Integer primaryReleaseY){
        FilmResponseDTO films = filmClient.getRandomFilm(genre, voteAverage, primaryReleaseY);

        return films.results();
    }
}
