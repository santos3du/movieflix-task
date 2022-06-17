package br.com.eduardo.movieflixtask.repositories;

import br.com.eduardo.movieflixtask.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
