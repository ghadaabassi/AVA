package com.example.ava.Service;

import com.example.ava.Model.Authentification;
import com.example.ava.Repository.AuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    private final AuthentificationRepository authentificationRepository;

    @Autowired
    public AuthentificationService(AuthentificationRepository authentificationRepository) {
        this.authentificationRepository = authentificationRepository;
    }

    public Authentification saveAuthentification(Authentification authentification) {

        return authentificationRepository.save(authentification);
    }

    public Authentification findByEmail(String email) {
        return authentificationRepository.findByEmail(email);
    }

}
