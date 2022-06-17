package br.com.eduardo.movieflixtask.repositories;

import br.com.eduardo.movieflixtask.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
