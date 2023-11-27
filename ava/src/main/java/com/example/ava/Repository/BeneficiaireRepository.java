package com.example.ava.Repository;

import com.example.ava.Model.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, String> {
    Optional<Beneficiaire> findByEmail(String email);
}
