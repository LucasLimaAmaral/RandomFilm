package com.pop.film.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record FilmResponseDTO(
        int page,
        List<FilmDTO> results,
        @JsonProperty(value = "total_pages")
        int totalPages
        ) {
}
