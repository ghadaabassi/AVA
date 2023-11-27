package com.example.ava.Repository;

import com.example.ava.Model.Authentification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthentificationRepository extends JpaRepository<Authentification, Long> {
    Authentification findByEmail(String email);
}
