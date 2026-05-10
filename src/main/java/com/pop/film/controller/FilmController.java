package com.pop.film.controller;

import com.pop.film.dto.FilmDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movie")
public class FilmController {

    @GetMapping(value = "/{name}")
    public ResponseEntity<FilmDTO> getRandomMovie(@PathVariable String name) {
        return null;
    }
}
