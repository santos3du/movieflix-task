package br.com.eduardo.movieflixtask.repositories;

import br.com.eduardo.movieflixtask.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
