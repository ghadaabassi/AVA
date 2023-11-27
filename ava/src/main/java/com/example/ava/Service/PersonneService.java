package com.example.ava.Service;

import com.example.ava.Model.Personne;
import com.example.ava.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    private final PersonneRepository personneRepository;

    @Autowired
    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    public Optional<Personne> getPersonneByEmail(String email) {
        return personneRepository.findByEmail(email);
    }

    public Personne savePersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    public void deletePersonneByEmail(String email) {
        Optional<Personne> existingPersonne = personneRepository.findByEmail(email);
        existingPersonne.ifPresent(personne -> personneRepository.delete(personne));
    }
}
