package com.example.ava.Controller;

import com.example.ava.Model.AvaE;
import com.example.ava.Model.Client;
import com.example.ava.Service.AvaEService;
import com.example.ava.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/avaes")
public class AvaEController {

    private final AvaEService avaEService;
    private final ClientService clientService;

    @Autowired
    public AvaEController(AvaEService avaEService, ClientService clientService) {
        this.avaEService = avaEService;
        this.clientService = clientService;
    }

    @GetMapping
    public List<AvaE> getAllAvaEs() {
        return avaEService.getAllAvaEs();
    }

    @GetMapping("/{id}")
    public AvaE getAvaEById(@PathVariable Long id) {
        return avaEService.getAvaEById(id).orElse(null);
    }

    @PostMapping
    public AvaE createAvaE(@RequestBody AvaE avaE) {
        if (avaE.getClient() != null) {

            Client savedClient = clientService.saveClient(avaE.getClient());
            avaE.setClient(savedClient);
        }
        return avaEService.saveAvaE(avaE);
    }

    @PutMapping("/{id}")
    public AvaE updateAvaE(@PathVariable Long id, @RequestBody AvaE avaE) {
        avaE.setId(id);
        return avaEService.saveAvaE(avaE);
    }

    @DeleteMapping("/{id}")
    public void deleteAvaE(@PathVariable Long id) {
        avaEService.deleteAvaE(id);
    }

    @GetMapping("/client-email/{clientEmail}")
    public List<AvaE> getAvaEsByClientEmail(@PathVariable String clientEmail) {
        return avaEService.getAvaEsByClientEmail(clientEmail);
    }
}
