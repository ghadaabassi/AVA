package com.example.ava.Repository;

import com.example.ava.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Optional<Personne> findByEmail(String email);
}
