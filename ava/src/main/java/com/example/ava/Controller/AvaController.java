package com.example.ava.Controller;

import com.example.ava.Model.Ava;
import com.example.ava.Model.Client;
import com.example.ava.Service.AvaService;
import com.example.ava.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
        }
        return avaService.saveAva(ava);
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
