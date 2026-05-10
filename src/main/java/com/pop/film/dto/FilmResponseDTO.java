package com.pop.film.dto;

import java.util.List;

public record FilmResponseDTO(
        int page,
        List<FilmDTO> results) {
}
