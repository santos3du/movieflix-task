package br.com.eduardo.movieflixtask.dto;

import br.com.eduardo.movieflixtask.entities.Genre;

import java.io.Serializable;

public class GenreDTO implements Serializable {
    private Long id;
    private String name;

    public GenreDTO() {
    }

    public GenreDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDTO(Genre entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
