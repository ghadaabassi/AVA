package com.example.ava.Controller;

import com.example.ava.Model.Client;
import com.example.ava.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.getClientByEmail(email).orElse(null);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/{email}")
    public Client updateClient(@PathVariable String email, @RequestBody Client updatedClient) {
        return clientService.updateClient(email, updatedClient).orElse(null);
    }

    @DeleteMapping("/{email}")
    public void deleteClient(@PathVariable String email) {
        clientService.deleteClientByEmail(email);
    }
}
