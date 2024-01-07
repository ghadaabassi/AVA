package com.example.ava.Controller;

import com.example.ava.Model.Ava;
import com.example.ava.Model.Client;
import com.example.ava.Model.Enums.Etat;
import com.example.ava.Service.AvaService;
import com.example.ava.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avas")
@CrossOrigin(origins = "*")
public class AvaController {

    private final AvaService avaService;
    private final ClientService clientService;

    @Autowired
    public AvaController(AvaService avaService, ClientService clientService) {
        this.avaService = avaService;
        this.clientService = clientService;

    }

    @GetMapping
    public List<Ava> getAllAvas() {
        return avaService.getAllAvas();
    }

    @GetMapping("/{id}")
    public Ava getAvaById(@PathVariable Long id) {
        return avaService.getAvaById(id).orElse(null);
    }

    @PostMapping()
    public Ava createAva(@RequestBody Ava ava) {

        if (ava.getClient() != null) {

            Client savedClient = clientService.saveClient(ava.getClient());
            ava.setClient(savedClient);
            ava.setSolde(ava.getBase() / 2);
            ava.setInitial(ava.getBase() / 2);
        }
        if (ava.getClass().getSimpleName().equals("AvaE")) {
            ava.setType(1);
        }
        return avaService.saveAva(ava);
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<String> activateAva(@PathVariable Long id) {
        Optional<Ava> optionalAva = avaService.getAvaById(id);

        if (optionalAva.isPresent()) {
            Ava ava = optionalAva.get();
            if (ava.getEtat() == Etat.Attente) {
                ava.setEtat(Etat.Actif);
                avaService.saveAva(ava);

                return ResponseEntity.ok("L'état de l'Ava a été changé avec succès.");
            } else {
                return ResponseEntity.badRequest().body("L'Ava n'est pas dans l'état 'Attente'.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/use/{id}")
    public ResponseEntity<String> utilizeAva(@PathVariable Long id, @RequestParam double amount) {
        Optional<Ava> optionalAva = avaService.getAvaById(id);
    
        if (optionalAva.isPresent()) {
            Ava ava = optionalAva.get();
    
           
            if (ava.getEtat() == Etat.Actif) {
         
                if (ava.getSolde() >= amount) {

                    double newSolde = ava.getSolde() - amount;
                    ava.setSolde(newSolde);

                    avaService.saveAva(ava);
    
                    return ResponseEntity.ok("Le montant a été retiré avec succès.");
                } else {
                    return ResponseEntity.badRequest().body("Solde insuffisant pour retirer le montant spécifié.");
                }
            } else {
                return ResponseEntity.badRequest().body("L'Ava n'est pas dans l'état 'Actif'.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    




    @PutMapping("/{id}")
    public Ava updateAva(@PathVariable Long id, @RequestBody Ava ava) {
        ava.setId(id);
        return avaService.saveAva(ava);
    }

    @DeleteMapping("/{id}")
    public String deleteAva(@PathVariable Long id) {
        if (avaService.deleteAva(id)) {
            return "Success";
        }
        ;
        return "Error";
    }

    @GetMapping("/client/{clientId}")
    public List<Ava> getAvasByClientId(@PathVariable Long clientId) {
        return avaService.getAvasByClientId(clientId);
    }

    @GetMapping("/notInAttente")
    public List<Ava> getAllAvasNotInAttente() {
        return avaService.getAllAvasNotInAttente();
    }

    @GetMapping("/inAttente")
    public List<Ava> getAllAvasInAttente() {
        return avaService.getAllAvasInAttente();
    }

}
