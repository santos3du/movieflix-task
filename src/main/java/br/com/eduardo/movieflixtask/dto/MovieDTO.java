package br.com.eduardo.movieflixtask.dto;

import br.com.eduardo.movieflixtask.entities.Genre;

import java.io.Serializable;

public class MovieDTO implements Serializable {

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;

    private Genre genre;
}
