package com.pop.film.service;

import com.pop.film.client.FilmClient;
import com.pop.film.dto.FilmDTO;
import com.pop.film.dto.FilmResponseDTO;
import com.pop.film.util.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    public List<FilmDTO> getRandomFilms(String genre, Float voteAverage, Integer primaryReleaseY){


        int page = RandomUtils.nextInt(500);

        FilmResponseDTO films = filmClient.getRandomFilms(genre, voteAverage, primaryReleaseY, page);

        return films.results();
    }

    public FilmDTO getRandomFilm(String genre, Float voteAverage, Integer primaryReleaseY){
        List<FilmDTO> listFilm = getRandomFilms(genre, voteAverage, primaryReleaseY);

        int position = RandomUtils.nextInt(listFilm.size());

        return listFilm.get(position);
    }
}
