package br.com.eduardo.movieflixtask.dto;

import br.com.eduardo.movieflixtask.entities.Movie;
import br.com.eduardo.movieflixtask.entities.Review;
import br.com.eduardo.movieflixtask.entities.User;

import java.io.Serializable;

public class ReviewDTO implements Serializable {
    private static final long serialVersionUID = -7816222405100671346L;
    private Long id;
    private String text;
    private Long movieId;
    private Long userId;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text, Movie movie, User user) {
        this.id = id;
        this.text = text;
        this.movieId = movie.getId();
        this.userId = user.getId();
    }
    public ReviewDTO(Review entity) {
        this.id = entity.getId();
        this.text = entity.getText();
        this.movieId = entity.getMovie().getId();
        this.userId = entity.getUser().getId();
    }
}
