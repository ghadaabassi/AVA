package com.example.ava.Controller;

import com.example.ava.Model.Personne;
import com.example.ava.Service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/personnes")
public class PersonneController {

    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @GetMapping("/{email}")
    public Personne getPersonneByEmail(@PathVariable String email) {
        return personneService.getPersonneByEmail(email).orElse(null);
    }

    @PostMapping
    public Personne createPersonne(@RequestBody Personne personne) {
        return personneService.savePersonne(personne);
    }

    @PutMapping("/{email}")
    public Personne updatePersonne(@PathVariable String email, @RequestBody Personne personne) {
        personne.setEmail(email);
        return personneService.savePersonne(personne);
    }

    @DeleteMapping("/{email}")
    public void deletePersonne(@PathVariable String email) {
        personneService.deletePersonneByEmail(email);
    }
}
