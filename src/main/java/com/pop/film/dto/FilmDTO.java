package com.pop.film.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FilmDTO(
        String title, 
        String overview, 
        float popularity,
        @JsonProperty(value = "release_date")
        String releaseDate,
        @JsonProperty(value = "poster_path")
        String posterPath) {
}
