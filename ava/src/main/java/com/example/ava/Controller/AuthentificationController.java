package com.example.ava.Controller;

import com.example.ava.Model.Authentification;
import com.example.ava.Service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentifications")
public class AuthentificationController {

    private final AuthentificationService authentificationService;

    @Autowired
    public AuthentificationController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping
    public Authentification createAuthentification(@RequestBody Authentification authentification) {
        return authentificationService.saveAuthentification(authentification);
    }

    @GetMapping("/{email}")
    public Authentification getAuthentificationByEmail(@PathVariable String email) {
        return authentificationService.findByEmail(email);
    }

}
