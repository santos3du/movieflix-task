package br.com.eduardo.movieflixtask.repositories;

import br.com.eduardo.movieflixtask.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
