package com.pop.film.controller;

import com.pop.film.dto.FilmDTO;
import com.pop.film.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<FilmDTO> getRandomMovie(@RequestParam("query") String name) {
        return filmService.findByName(name);

    }

    @GetMapping(value = "/popular")
    public List<FilmDTO> getPopulrList(){
        return filmService.getPopularList();
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<FilmDTO>>(
        @RequestParam(required = false) String genre,
        @RequestParam(required = false) Float voteAverage,
        @RequestParam(required = false) Integer primaryReleaseY
    ){
        return filmService.getRandomFilm()
    }
}
